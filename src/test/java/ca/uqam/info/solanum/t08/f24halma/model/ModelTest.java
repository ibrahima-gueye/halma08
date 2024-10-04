package ca.uqam.info.solanum.t08.f24halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.model.AbstractModelTest;
import ca.uqam.info.solanum.inf2050.f24halma.model.Board;
import ca.uqam.info.solanum.inf2050.f24halma.model.Model;

/**
 * Classe de test pour le modèle de jeu.
 * Cette classe étend {@link AbstractModelTest} et fournit une instance
 * de {@link Model} pour effectuer des tests unitaires.
 */
public class ModelTest extends AbstractModelTest {

       private final Model model;

    /**
     * Constructeur de la classe ModelTest.
     * Il initialise le modèle avec un plateau de taille 3 et deux joueurs,
     * "MAX" et "RYAN".
     */
    public ModelTest() {
        Board board = new BoardImpl(3);
        String[] playerNames = new String[] { "MAX", "RYAN" };
        model = new ModelImpl(board, playerNames);
    }


    @Override
    public Model getModel() {
                return model;
    }
}
