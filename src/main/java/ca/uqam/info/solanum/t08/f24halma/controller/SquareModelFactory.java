package ca.uqam.info.solanum.t08.f24halma.controller;

import ca.uqam.info.solanum.inf2050.f24halma.controller.ModelFactory;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;
import ca.uqam.info.solanum.inf2050.f24halma.model.ModelInitializationException;
import ca.uqam.info.solanum.t08.f24halma.model.BoardImpl;
import ca.uqam.info.solanum.t08.f24halma.model.ModelImpl;

/**
 * Fabrique de modèles pour créer des instances de {@link Model}
 * spécifiquement pour un plateau carré.
 * Cette classe implémente l'interface {@link ModelFactory}.
 */
public class SquareModelFactory implements ModelFactory {

    /**
     * Constructeur de la classe SquareModelFactory.
     * Initialise une nouvelle instance de la fabrique de modèles carrés.
     */
    public SquareModelFactory() {
    }

    @Override
    public Model createModel(int baseSize, String[] players) {
        if (players.length != 2) {
            throw new ModelInitializationException("The game must have exactly 2 players.");
        }

        BoardImpl board = new BoardImpl(baseSize);

        return new ModelImpl(board, players);
    }
}
