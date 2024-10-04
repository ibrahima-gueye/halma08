package ca.uqam.info.solanum.t08.f24halma.model;

import ca.uqam.info.solanum.inf2050.f24halma.controller.AbstractSquareModelFactoryTest;
import ca.uqam.info.solanum.inf2050.f24halma.controller.ModelFactory;
import ca.uqam.info.solanum.t08.f24halma.controller.SquareModelFactory;

/**
 * Classe de test pour la fabrique de modèles carrés.
 * Cette classe étend {@link AbstractSquareModelFactoryTest} et
 * fournit une implémentation de la méthode pour obtenir une instance
 * de {@link ModelFactory} spécifique pour les tests.
 */
public class SquareModelFactoryTest extends AbstractSquareModelFactoryTest {

    @Override
    public ModelFactory getModelFactory() {
        return new SquareModelFactory();
    }
}
