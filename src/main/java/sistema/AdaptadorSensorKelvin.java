package sistema;

import sistema.SensorTemperatura;
import sistema.SensorKelvin;

public class AdaptadorSensorKelvin implements SensorTemperatura {

    private final SensorKelvin sensorKelvin;

    public AdaptadorSensorKelvin(SensorKelvin sensor) {
        this.sensorKelvin = sensor;
    }

    @Override
    public double lerTemperaturaCelsius() {
        return this.sensorKelvin.getTempKelvin() - 273.15;
    }
}