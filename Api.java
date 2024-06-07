package CONVERSOR;

import java.util.Map;

public class Api {
    private String baseCurrency;
    private Map<String, Double> conversionRates;

    public Api(String baseCurrency, Map<String, Double> conversionRates) {
        this.baseCurrency = baseCurrency;
        this.conversionRates = conversionRates;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    @Override
    public String toString() {
        return "Api{" + "baseCurrency: '" + baseCurrency + '\'' + ", conversionRates: " + conversionRates + '}';
    }

    
}


