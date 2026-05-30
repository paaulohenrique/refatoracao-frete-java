package src.fabrica;

import src.estrategias.EstrategiaFrete;
import src.estrategias.FreteExterior;
import src.estrategias.FreteNacional;
import src.estrategias.FreteSp;

// Padrão Factory: centraliza a criação de estratégias, eliminando `new` espalhado pelo código
public class FreteFactory {

    public static EstrategiaFrete criar(String tipo) {
        return switch (tipo.toUpperCase()) {
            case "SP"       -> new FreteSp();
            case "NACIONAL" -> new FreteNacional();
            case "EXTERIOR" -> new FreteExterior();
            default -> throw new IllegalArgumentException("Tipo de frete desconhecido: " + tipo);
        };
    }
}
