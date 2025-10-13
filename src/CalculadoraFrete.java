package src;

import src.estrategias.EstrategiaFrete;

public class CalculadoraFrete {

    private EstrategiaFrete estrategia;

    public CalculadoraFrete(EstrategiaFrete estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double peso, double valor) {
        return estrategia.calcularFrete(peso, valor);
    }
}
