package adapters;

import sistema.AdaptadorSensorKelvin;
import sistema.SensorTemperatura;
import sistema.SensorKelvin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes do Adaptador Kelvin para Celsius")
class AdaptadorSensorKelvinTest {

    private static final double DELTA = 0.001; // Precisão de 3 casas decimais

    @Test
    @DisplayName("Deve converter 300K para aprox. 26.85°C (Valor padrão)")
    void deveConverterValorPadrao() {
        SensorKelvin sensorReal = new SensorKelvin();
        SensorTemperatura adaptador = new AdaptadorSensorKelvin(sensorReal);

        // 300 - 273.15 = 26.85
        assertEquals(26.85, adaptador.lerTemperaturaCelsius(), DELTA);
    }

    @Test
    @DisplayName("Deve converter 0K (Zero Absoluto) para -273.15°C")
    void deveConverterZeroAbsoluto() {
        // Arrange: Simulando sensor lendo 0K
        SensorKelvin sensorStub = new SensorKelvin() {
            @Override
            public double getTempKelvin() {
                return 0.0;
            }
        };

        SensorTemperatura adaptador = new AdaptadorSensorKelvin(sensorStub);

        // Act & Assert
        assertEquals(-273.15, adaptador.lerTemperaturaCelsius(), DELTA);
    }

    @Test
    @DisplayName("Deve converter 273.15K para 0°C")
    void deveConverterPontoZero() {
        // Arrange
        SensorKelvin sensorStub = new SensorKelvin() {
            @Override
            public double getTempKelvin() {
                return 273.15;
            }
        };

        SensorTemperatura adaptador = new AdaptadorSensorKelvin(sensorStub);

        // Act & Assert
        assertEquals(0.0, adaptador.lerTemperaturaCelsius(), DELTA);
    }
}