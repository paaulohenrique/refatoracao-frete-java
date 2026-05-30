package src.decoradores;

import src.estrategias.EstrategiaFrete;

// Padrão Decorator: classe base que envolve qualquer EstrategiaFrete e permite empilhar comportamentos
public abstract class FreteDecorator implements EstrategiaFrete {

    protected final EstrategiaFrete estrategia;

    public FreteDecorator(EstrategiaFrete estrategia) {
        this.estrategia = estrategia;
    }
}
