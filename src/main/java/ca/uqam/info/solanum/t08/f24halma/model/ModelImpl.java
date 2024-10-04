
package ca.uqam.info.solanum.t08.f24halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.model.Board;
import ca.uqam.info.solanum.inf2050.f24halma.model.Field;
import ca.uqam.info.solanum.inf2050.f24halma.model.FieldException;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;

import java.util.*;

/**
 * Implémentation de l'interface {@link Model}.
 * Cette classe représente le modèle du jeu, gérant l'état du plateau,
 * les joueurs et leurs mouvements.
 */
public class ModelImpl implements Model {
    private final Board board;
    private final Map<Integer, Set<Field>> playerFields = new HashMap<>();
    private int currentPlayer;
    private final String[] playerNames;


    /**
     * Constructeur de la classe ModelImpl.
     *
     * @param board Le plateau de jeu à utiliser.
     * @param playerNames Les noms des joueurs participant au jeu.
     */
    public ModelImpl(Board board, String[] playerNames) {
        this.board = board;
        this.playerNames = playerNames;
        for (int i = 0; i < playerNames.length; i++) {
            playerFields.put(i, new HashSet<>(board.getHomeFieldsForPlayer(i)));
        }
        currentPlayer = 0;
    }

    @Override
    public void occupyField(int playerIndex, Field field) throws FieldException {
        if (!board.getAllFields().contains(field)) {
            throw new FieldException("Field is not valid on the board.");
        }
        if (!isClear(field)) {
            throw new FieldException("Field is already occupied.");
        }
        playerFields.get(playerIndex).add(field);
    }

    @Override
    public void clearField(Field field) throws FieldException {
        boolean fieldCleared = false;
        for (Set<Field> fields : playerFields.values()) {
            if (fields.remove(field)) {
                fieldCleared = true;
                break;
            }
        }
        if (!fieldCleared) {
            throw new FieldException("Field was not occupied.");
        }
    }

    @Override
    public void setCurrentPlayer(int playerIndex) {
        currentPlayer = playerIndex;
    }

    @Override
    public String[] getPlayerNames() {
        return playerNames.clone();
    }

    @Override
    public Set<Field> getPlayerFields(int playerIndex) {
        return Set.copyOf(playerFields.get(playerIndex));
    }

    @Override
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public boolean isClear(Field field) {
        for (Set<Field> fields : playerFields.values()) {
            if (fields.contains(field)) {
                return false;
            }
        }
        return true;
    }


}
