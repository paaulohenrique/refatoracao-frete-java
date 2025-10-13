package src.test;

import src.CalculadoraFrete;
import src.estrategias.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraFreteTest {

    @Test
    void deveCalcularFreteSP() {
        CalculadoraFrete calculadora = new CalculadoraFrete(new FreteSp());
        double resultado = calculadora.calcular(3.0, 50.0);
        assertEquals(5.0, resultado);
    }

    @Test
    void deveCalcularFreteExterior() {
        CalculadoraFrete calculadora = new CalculadoraFrete(new FreteExterior());
        double resultado = calculadora.calcular(2.0, 150.0);
        assertEquals(60.0, resultado);
    }

    @Test
    void deveCalcularFreteNacional() {
        CalculadoraFrete calculadora = new CalculadoraFrete(new FreteNacional());
        double resultado = calculadora.calcular(4.0, 80.0);
        assertEquals(15.0, resultado);
    }
}
