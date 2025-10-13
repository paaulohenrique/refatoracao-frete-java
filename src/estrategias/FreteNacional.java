package src.estrategias;

public class FreteNacional implements EstrategiaFrete {

    @Override
    public double calcularFrete(double peso, double valor) {
        return 15.0;
    }
}
