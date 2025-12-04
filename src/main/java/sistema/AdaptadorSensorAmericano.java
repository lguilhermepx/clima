package sistema;

import sistema.SensorTemperatura;
import sistema.SensorAmericano;

public class AdaptadorSensorAmericano implements SensorTemperatura {

    private final SensorAmericano sensorEstrangeiro;

    public AdaptadorSensorAmericano(SensorAmericano sensor) {
        this.sensorEstrangeiro = sensor;
    }

    @Override
    public double lerTemperaturaCelsius() {
        double temperaturaFahrenheit = this.sensorEstrangeiro.getTemperatureFahrenheit();
        return (temperaturaFahrenheit - 32) * 5.0 / 9.0;
    }
}