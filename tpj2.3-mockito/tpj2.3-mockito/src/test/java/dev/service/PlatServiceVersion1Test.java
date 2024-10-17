package dev.service;

import dev.dao.IPlatDao;
import dev.entite.Plat;
import dev.exception.PlatException;
import dev.service.PlatServiceVersion1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlatServiceVersion1Test {

    @Mock
    private IPlatDao platDao;

    @InjectMocks
    private PlatServiceVersion1 platService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test_listerPlats_returnsListWithUppercaseNames() {
        // Arrange
        List<Plat> platsMock = Arrays.asList(
                new Plat("spaghetti", 1200),
                new Plat("pizza", 1300)
        );
        when(platDao.listerPlats()).thenReturn(platsMock);

        // Act
        List<Plat> result = platService.listerPlats();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("SPAGHETTI", result.get(0).getNom());
        assertEquals("PIZZA", result.get(1).getNom());

        // Vérifier que la méthode listerPlats du DAO a été appelée une fois
        verify(platDao, times(1)).listerPlats();
    }

    @Test
    void test_listerPlats_throwsPlatExceptionOnNullPointerException() {
        // Simuler un comportement du DAO qui lance une NullPointerException
        when(platDao.listerPlats()).thenThrow(NullPointerException.class);

        // Vérifier qu'une PlatException est bien levée avec une NullPointerException comme cause
        PlatException exception = assertThrows(PlatException.class, () -> platService.listerPlats());
        assertTrue(exception.getCause() instanceof NullPointerException);
    }
}
