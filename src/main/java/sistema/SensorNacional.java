package sistema;

import sistema.SensorTemperatura;

public class SensorNacional implements SensorTemperatura {

    @Override
    public double lerTemperaturaCelsius() {
        // simula leitura direta em Celsius
        return 30.0;
    }
}