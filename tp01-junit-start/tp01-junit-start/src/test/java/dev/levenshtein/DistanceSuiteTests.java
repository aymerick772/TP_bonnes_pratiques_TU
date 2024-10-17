package dev.levenshtein;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("dev.levenshtein")
@IncludeTags("distance")
public class DistanceSuiteTests {
    // Cette classe ne contient pas de méthodes de test spécifiques
    // Les annotations @IncludeTags et @SelectPackages permettent de sélectionner les tests
}