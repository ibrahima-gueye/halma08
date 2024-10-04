package ca.uqam.info.solanum.t08.f24halma.view;

import ca.uqam.info.solanum.inf2050.f24halma.controller.ModelFactory;
import ca.uqam.info.solanum.inf2050.f24halma.model.ModelReadOnly;
import ca.uqam.info.solanum.inf2050.f24halma.view.TextualVisualizer;
import ca.uqam.info.solanum.t08.f24halma.controller.SquareModelFactory;

/**
 * Classe principale pour lancer l'application en mode console.
 * Cette classe contient la méthode main qui initialise et exécute
 * une instance de modèle de jeu.
 */
public class DefaultConsoleLauncher {

    /**
     * Constructeur de la classe DefaultConsoleLauncher.
     */
    public DefaultConsoleLauncher() {
    }

    /**
     * Méthode principale pour exécuter l'application.
     *
     * @param args Arguments de ligne de commande, non utilisés dans cette implémentation.
     */
    public static void main(String[] args) {
        runTp01();
    }

    /**
     * Méthode pour initialiser et exécuter le modèle de jeu.
     * Elle crée un modèle carré avec une taille de base de 9 et
     * deux joueurs, puis affiche la représentation textuelle du modèle.
     */
    private static void runTp01() {
        int baseSize = 3;
        String[] playerNames = new String[] {"MAX", "RYAN"};
        ModelFactory modelFactory = new SquareModelFactory();
        ModelReadOnly model = modelFactory.createModel(baseSize, playerNames);
        TextualVisualizer visualizer = new TextualVisualizer(false);
        System.out.println(visualizer.stringifyModel(model));
    }
}
