package src.decoradores;

import src.estrategias.EstrategiaFrete;

public class FreteExpresso extends FreteDecorator {

    private static final double TAXA_EXPRESSA = 20.0;

    public FreteExpresso(EstrategiaFrete estrategia) {
        super(estrategia);
    }

    @Override
    public double calcularFrete(double peso, double valor) {
        return estrategia.calcularFrete(peso, valor) + TAXA_EXPRESSA;
    }
}
