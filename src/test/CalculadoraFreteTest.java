package src.test;

import org.junit.jupiter.api.Test;
import src.CalculadoraFrete;
import src.decoradores.FreteComSeguro;
import src.decoradores.FreteExpresso;
import src.estrategias.EstrategiaFrete;
import src.estrategias.FreteExterior;
import src.estrategias.FreteNacional;
import src.estrategias.FreteSp;
import src.fabrica.FreteFactory;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraFreteTest {

    // --- Strategy ---

    @Test
    void deveCalcularFreteSP() {
        CalculadoraFrete calculadora = new CalculadoraFrete(new FreteSp());
        assertEquals(5.0, calculadora.calcular(3.0, 50.0));
    }

    @Test
    void deveCalcularFreteExterior() {
        CalculadoraFrete calculadora = new CalculadoraFrete(new FreteExterior());
        assertEquals(60.0, calculadora.calcular(2.0, 150.0));
    }

    @Test
    void deveCalcularFreteNacional() {
        CalculadoraFrete calculadora = new CalculadoraFrete(new FreteNacional());
        assertEquals(15.0, calculadora.calcular(4.0, 80.0));
    }

    // --- Factory ---

    @Test
    void factoryDeveCriarFreteSP() {
        EstrategiaFrete estrategia = FreteFactory.criar("SP");
        assertInstanceOf(FreteSp.class, estrategia);
    }

    @Test
    void factoryDeveCriarFreteNacional() {
        EstrategiaFrete estrategia = FreteFactory.criar("NACIONAL");
        assertInstanceOf(FreteNacional.class, estrategia);
    }

    @Test
    void factoryDeveCriarFreteExterior() {
        EstrategiaFrete estrategia = FreteFactory.criar("EXTERIOR");
        assertInstanceOf(FreteExterior.class, estrategia);
    }

    @Test
    void factoryDeveLancarExcecaoParaTipoDesconhecido() {
        assertThrows(IllegalArgumentException.class, () -> FreteFactory.criar("INVALIDO"));
    }

    // --- Decorator ---

    @Test
    void freteComSeguroDeveAdicionarTaxa() {
        EstrategiaFrete spComSeguro = new FreteComSeguro(new FreteSp());
        // FreteSP(3kg) = 5.0 + seguro(15.0) = 20.0
        assertEquals(20.0, new CalculadoraFrete(spComSeguro).calcular(3.0, 50.0));
    }

    @Test
    void freteExpressoDeveAdicionarTaxa() {
        EstrategiaFrete spExpresso = new FreteExpresso(new FreteSp());
        // FreteSP(3kg) = 5.0 + expresso(20.0) = 25.0
        assertEquals(25.0, new CalculadoraFrete(spExpresso).calcular(3.0, 50.0));
    }

    @Test
    void decoradoresDevemSerEmpilhados() {
        EstrategiaFrete spComSeguroEExpresso = new FreteExpresso(new FreteComSeguro(new FreteSp()));
        // FreteSP(3kg) = 5.0 + seguro(15.0) + expresso(20.0) = 40.0
        assertEquals(40.0, new CalculadoraFrete(spComSeguroEExpresso).calcular(3.0, 50.0));
    }
}
