package ca.uqam.info.solanum.t08.f24halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.model.Board;
import ca.uqam.info.solanum.inf2050.f24halma.model.Field;

import java.util.HashSet;
import java.util.Set;

        /**
        * Implémentation de l'interface {@link Board}.
        * Cette classe représente un plateau de jeu et fournit les
        * méthodes nécessaires pour gérer l'état du plateau,
        * y compris l'ajout de pièces, la vérification des conditions
        * de victoire et la gestion des joueurs.
       */

public class BoardImpl implements Board {

    private final Set<Field> allFields = new HashSet<>();
    private final Set<Field> homeFieldsPlayer1 = new HashSet<>();
    private final Set<Field> homeFieldsPlayer2 = new HashSet<>();
    private final Set<Field> allHomeFields = new HashSet<>();

    /**
     * Constructeur de BoardImpl pour initialiser un plateau avec une certaine taille.
     * @param baseSize taille de la base du plateau (ex : 3 pour un plateau de 9x9).
     */
    public BoardImpl(int baseSize) {
        initializeBoard(baseSize);
        initializeHomeFields(baseSize);
    }

    /**
     * Initialisation des champs du plateau selon la taille donnée.
     * @param baseSize taille de la base du plateau.
     */
    private void initializeBoard(int baseSize) {
        int boardSize = baseSize * 3;
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                allFields.add(new Field(x, y));
            }
        }
    }

    /**
     * Initialisation des zones d'origine (home fields) des joueurs.
     * @param baseSize taille de la base du plateau.
     */
    private void initializeHomeFields(int baseSize) {

        for (int i = 0; i < baseSize ; i++) {
            for (int j = 0; j < baseSize - i; j++) {
                homeFieldsPlayer1.add(new Field(i, j));
            }
        }
        int k = 0;
        for (int i = baseSize * 3 - 1; i >= baseSize * 2 ; i--) {
            for (int j = baseSize * 3 - 1; j >= baseSize * 2 + k ; j--) {
                homeFieldsPlayer2.add(new Field(j, i));
            }
            k++;
        }
        allHomeFields.addAll(homeFieldsPlayer1);
        allHomeFields.addAll(homeFieldsPlayer2);
    }


    @Override
    public Set<Field> getAllFields() {
        return Set.copyOf(allFields);
    }

    @Override
    public Set<Field> getHomeFieldsForPlayer(int playerIndex) {
        if (playerIndex == 0) {
            return Set.copyOf(homeFieldsPlayer1);
        } else if (playerIndex == 1) {
            return Set.copyOf(homeFieldsPlayer2);
        } else {
            throw new IllegalArgumentException("Invalid player index");
        }
    }

    @Override
    public Set<Field> getAllHomeFields() {
        return Set.copyOf(allHomeFields);
    }

    @Override
    public Set<Field> getTargetFieldsForPlayer(int playerIndex) {
               return getHomeFieldsForPlayer(1 - playerIndex);
    }

    @Override
    public Set<Field> getNeighbours(Field field) {
               Set<Field> neighbours = new HashSet<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            Field neighbour = new Field(field.x() + direction[0], field.y() + direction[1]);
            if (allFields.contains(neighbour)) {
                neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    @Override
    public Field getExtendedNeighbour(Field origin, Field neighbour) {
                int dx = neighbour.x() - origin.x();
        int dy = neighbour.y() - origin.y();
        Field extendedNeighbour = new Field(neighbour.x() + dx, neighbour.y() + dy);

        if (allFields.contains(extendedNeighbour)) {
            return extendedNeighbour;
        }
        return null;
    }
}