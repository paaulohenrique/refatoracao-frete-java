package src.estrategias;

public class FreteExterior implements EstrategiaFrete {

    @Override
    public double calcularFrete(double peso, double valor) {
        if (isValorMaiorQue100(valor)) {
            return 50.0 + (peso * 5.0);
        }
        return 30.0;
    }

    private boolean isValorMaiorQue100(double valor) {
        return valor > 100.0;
    }
}
