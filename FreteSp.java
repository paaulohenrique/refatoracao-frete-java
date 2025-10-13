public class FreteSp implements EstrategiaFrete {

    @Override
    public double calcularFrete(double peso, double valor) {
        if (isPesoMaiorQue5kg(peso)) {
            return 10.0 + (peso * 2.0);
        }
        return 5.0;
    }

    private boolean isPesoMaiorQue5kg(double peso) {
        return peso > 5.0;
    }
}
