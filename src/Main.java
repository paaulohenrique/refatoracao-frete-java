package src;

import src.decoradores.FreteComSeguro;
import src.decoradores.FreteExpresso;
import src.estrategias.EstrategiaFrete;
import src.fabrica.FreteFactory;

public class Main {
    public static void main(String[] args) {

        // --- Strategy + Factory ---
        System.out.println("=== Strategy + Factory ===");

        EstrategiaFrete sp = FreteFactory.criar("SP");
        System.out.println("Frete SP (3kg, R$50):         R$" + new CalculadoraFrete(sp).calcular(3, 50));

        EstrategiaFrete exterior = FreteFactory.criar("EXTERIOR");
        System.out.println("Frete Exterior (2kg, R$150):  R$" + new CalculadoraFrete(exterior).calcular(2, 150));

        EstrategiaFrete nacional = FreteFactory.criar("NACIONAL");
        System.out.println("Frete Nacional (4kg, R$80):   R$" + new CalculadoraFrete(nacional).calcular(4, 80));

        // --- Decorator ---
        System.out.println("\n=== Decorator ===");

        EstrategiaFrete spBase = FreteFactory.criar("SP");
        System.out.println("SP puro (3kg, R$50):           R$" + new CalculadoraFrete(spBase).calcular(3, 50));

        EstrategiaFrete spComSeguro = new FreteComSeguro(FreteFactory.criar("SP"));
        System.out.println("SP + Seguro (3kg, R$50):       R$" + new CalculadoraFrete(spComSeguro).calcular(3, 50));

        EstrategiaFrete spComSeguroEExpresso = new FreteExpresso(new FreteComSeguro(FreteFactory.criar("SP")));
        System.out.println("SP + Seguro + Expresso (3kg):  R$" + new CalculadoraFrete(spComSeguroEExpresso).calcular(3, 50));
    }
}
