package src.decoradores;

import src.estrategias.EstrategiaFrete;

public class FreteComSeguro extends FreteDecorator {

    private static final double TAXA_SEGURO = 15.0;

    public FreteComSeguro(EstrategiaFrete estrategia) {
        super(estrategia);
    }

    @Override
    public double calcularFrete(double peso, double valor) {
        return estrategia.calcularFrete(peso, valor) + TAXA_SEGURO;
    }
}
