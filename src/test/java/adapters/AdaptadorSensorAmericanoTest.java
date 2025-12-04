package adapters;

import sistema.AdaptadorSensorAmericano;
import sistema.SensorTemperatura;
import sistema.SensorAmericano;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes do Adaptador Fahrenheit para Celsius")
class AdaptadorSensorAmericanoTest {

    private static final double DELTA = 0.0001;

    @Test
    @DisplayName("Deve converter 86°F para 30°C (Valor padrão do sensor)")
    void deveConverterValorPadraoCorretamente() {
        SensorAmericano sensorReal = new SensorAmericano();
        SensorTemperatura adaptador = new AdaptadorSensorAmericano(sensorReal);

        double resultadoCelsius = adaptador.lerTemperaturaCelsius();

        assertEquals(30.0, resultadoCelsius, DELTA, "A conversão de 86°F deveria ser 30°C");
    }

    @Test
    @DisplayName("Deve converter 32°F para 0°C (Ponto de congelamento)")
    void deveConverterPontoCongelamento() {
        SensorAmericano sensorStub = new SensorAmericano() {
            @Override
            public double getTemperatureFahrenheit() {
                return 32.0;
            }
        };

        SensorTemperatura adaptador = new AdaptadorSensorAmericano(sensorStub);

        double resultadoCelsius = adaptador.lerTemperaturaCelsius();

        assertEquals(0.0, resultadoCelsius, DELTA, "32°F deve ser 0°C");
    }

    @Test
    @DisplayName("Deve converter 212°F para 100°C (Ponto de ebulição)")
    void deveConverterPontoEbulicao() {
        SensorAmericano sensorStub = new SensorAmericano() {
            @Override
            public double getTemperatureFahrenheit() {
                return 212.0;
            }
        };

        SensorTemperatura adaptador = new AdaptadorSensorAmericano(sensorStub);

        assertEquals(100.0, adaptador.lerTemperaturaCelsius(), DELTA);
    }
}