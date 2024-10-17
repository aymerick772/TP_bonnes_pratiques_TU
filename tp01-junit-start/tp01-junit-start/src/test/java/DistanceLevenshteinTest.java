
import dev.levenshtein.exeption.AppException;
import dev.levenshtein.DistanceLevenshtein;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DistanceLevenshteinTest {


    private DistanceLevenshtein distanceLevenshtein;


    private static Object[][] testCas;


    @BeforeAll
    public static void initTestCases() {
        testCas = new Object[][] {
                {"chat", "chats", 1},
                {"machins", "machine", 1},
                {"aviron", "avion", 1},
                {"java", "jee", 3}
        };
    }


    @BeforeEach
    public void setUp() {
        distanceLevenshtein = new DistanceLevenshtein();
    }


    @Test
    @Tag("distance")
    public void testDistanceLevenshtein() {
        for (Object[] testCase : testCas) {
            String mot1 = (String) testCase[0];
            String mot2 = (String) testCase[1];
            int distanceAttendue = (int) testCase[2];
            int distanceCalculee = distanceLevenshtein.calculerDistance(mot1, mot2);

            assertEquals(distanceAttendue, distanceCalculee,
                    "Erreur : distance incorrecte pour les mots " + mot1 + " et " + mot2);
        }
    }

    @ParameterizedTest
    @Tag("distance")
    @CsvFileSource(resources ="/dev/levenshtein/data.csv", delimiter = ';', numLinesToSkip = 1)
    public void testLevenshteinDistanceFromCsv(String mot1, String mot2, int expectedDistance) {
        // Calculer la distance de Levenshtein entre les deux mots
        int actualDistance = distanceLevenshtein.calculerDistance(mot1, mot2);

        // Vérifier que la distance calculée correspond bien à la distance attendue
        assertEquals(expectedDistance, actualDistance,
                String.format("Erreur : Distance entre '%s' et '%s' devrait être %d, mais on a obtenu %d.",
                        mot1, mot2, expectedDistance, actualDistance));
    }
    @Test
    @Tag("validation")
    void testPremierParametreNull() {
        AppException exception = assertThrows(AppException.class, () -> {
            distanceLevenshtein.calculerDistance(null, "test");
        });
        assertEquals("le premier paramètre ne peut être null ou vide", exception.getMessage());
    }

    @Test
    @Tag("validation")
    void testPremierParametreVide() {
        AppException exception = assertThrows(AppException.class, () -> {
            distanceLevenshtein.calculerDistance("", "test");
        });
        assertEquals("le premier paramètre ne peut être null ou vide", exception.getMessage());
    }

    @Test
    @Tag("validation")
    void testSecondParametreNull() {
        AppException exception = assertThrows(AppException.class, () -> {
            distanceLevenshtein.calculerDistance("test", null);
        });
        assertEquals("le second paramètre ne peut être null ou vide", exception.getMessage());
    }

    @Test
    @Tag("validation")
    void testSecondParametreVide() {
        AppException exception = assertThrows(AppException.class, () -> {
            distanceLevenshtein.calculerDistance("test", "");
        });
        assertEquals("le second paramètre ne peut être null ou vide", exception.getMessage());
    }
}
