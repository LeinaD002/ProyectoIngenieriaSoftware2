package gt.edu.umes.proy.calculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CalculoSegundosTest {
    private final LogicaDelNegocio logica = new LogicaDelNegocio();

    @Test
    void rechazaUnArgumentoQueContieneLetras() {
        IllegalArgumentException error = assertThrows(
            IllegalArgumentException.class,
            () -> logica.calcularSegundos(new String[] {"1", "tres", "6", "20", "1"})
        );

        assertTrue(error.getMessage().contains("semanas"));
    }

    @Test
    void calculaLosSegundosDelEjemploDeFaseDos() {
        long resultado = logica.calcularSegundos(new String[] {"1", "3", "6", "20", "1"});

        assertEquals(4_996_860L, resultado);
    }
}
