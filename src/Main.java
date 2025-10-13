package src;

import src.estrategias.FreteExterior;
import src.estrategias.FreteNacional;
import src.estrategias.FreteSp;

public class Main {
    public static void main(String[] args) {

        CalculadoraFrete freteSp = new CalculadoraFrete(new FreteSp());
        System.out.println("Frete SP (3kg, R$50): " + freteSp.calcular(3, 50));

        CalculadoraFrete freteExterior = new CalculadoraFrete(new FreteExterior());
        System.out.println("Frete Exterior (2kg, R$150): " + freteExterior.calcular(2, 150));

        CalculadoraFrete freteNacional = new CalculadoraFrete(new FreteNacional());
        System.out.println("Frete Nacional (4kg, R$80): " + freteNacional.calcular(4, 80));
    }
}
