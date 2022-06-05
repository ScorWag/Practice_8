import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Radio;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void defaultValues() {
        Radio radio = new Radio();
        assertEquals(10, radio.getQuantityStation());
        assertEquals(0, radio.getMinStation());
        assertEquals(9, radio.getMaxStation());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getMinVolume());
        assertEquals(100, radio.getMaxVolume());
        assertEquals(0, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 100, 100, 0, 99, 0",
                    "border condition value, 1, 1, 0, 0, 0",
                    "border condition value, 0, 10, 0, 9, 0",
                    "border condition value, -1, 10, 0, 9, 0"
            }
    )
    void setQuantityStation(String test, int setQuantityStation, int quantityStationExp, int minStationExp, int maxStationExp, int currentStationExp) {
        Radio radio = new Radio(setQuantityStation);

        assertEquals(quantityStationExp, radio.getQuantityStation());
        assertEquals(minStationExp, radio.getMinStation());
        assertEquals(maxStationExp, radio.getMaxStation());
        assertEquals(currentStationExp, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 5",
                    "border condition, 1, 1",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "border condition, 8, 8",
                    "border condition, 9, 9",
                    "border condition, 10, 0",
                    "minus, -10, 0",
                    "not valid big value, 50, 0"
            }
    )
    void setStationQuantityStationDefault(String test, int setStation, int expected) {
        Radio station = new Radio();
        station.setCurrentStation(setStation);

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 5",
                    "border condition, 1, 1",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "border condition, 98, 98",
                    "border condition, 99, 99",
                    "border condition, 100, 0",
                    "minus, -100, 0",
                    "not valid big value, 150, 0"
            }
    )
    void setStationWithBigQuantityStation(String test, int setStation, int expected) {
        Radio station = new Radio(100);
        station.setCurrentStation(setStation);

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "border condition, 1, 0",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "border condition, 2, 0",
                    "not valid big minus, -100, 0",
                    "not valid big value, 150, 0"
            }
    )
    void setStationWithBorderQuantityStationOne(String test, int setStation, int expected) {
        Radio station = new Radio(1);
        station.setCurrentStation(setStation);

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 5",
                    "border condition, 1, 1",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "border condition, 8, 8",
                    "border condition, 9, 9",
                    "border condition, 10, 0",
                    "minus, -10, 0",
                    "not valid big value, 50, 0"
            }
    )
    void setStationWithBorderQuantityStationMinusOne(String test, int setStation, int expected) {
        Radio station = new Radio(-1);
        station.setCurrentStation(setStation);

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 5",
                    "border condition, 1, 1",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "border condition, 8, 8",
                    "border condition, 9, 9",
                    "border condition, 10, 0",
                    "minus, -10, 0",
                    "not valid big value, 50, 0"
            }
    )
    void setStationWithQuantityStationZero(String test, int setStation, int expected) {
        Radio station = new Radio(0);
        station.setCurrentStation(setStation);

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 5",
                    "border condition, 1, 1",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "border condition, 8, 8",
                    "border condition, 9, 9",
                    "border condition, 10, 0",
                    "minus, -10, 0",
                    "not valid big value, 50, 0"
            }
    )
    void setStationWithQuantityStationMinusOne(String test, int setStation, int expected) {
        Radio station = new Radio(-1);
        station.setCurrentStation(setStation);

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 5",
                    "border condition, 1, 1",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "border condition, 8, 8",
                    "border condition, 9, 9",
                    "border condition, 10, 0",
                    "minus, -10, 0",
                    "not valid big value, 50, 0"
            }
    )
    void setStationWithBigMinusQuantityStation(String test, int setStation, int expected) {
        Radio station = new Radio(-100);
        station.setCurrentStation(setStation);

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 6",
                    "border condition, 9, 0",
                    "border condition, 0, 1",
                    "border condition, -1, 1",
                    "border condition, 10, 1"
            }
    )
    void shouldToNextStationQuantityStationDefault(String test, int setStation, int expected) {
        Radio station = new Radio();

        station.setCurrentStation(setStation);

        station.nextStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 55, 56",
                    "border condition, 99, 0",
                    "border condition, 0, 1",
                    "border condition, -1, 1",
                    "border condition, 100, 1"
            }
    )
    void shouldToNextStationWithBigQuantityStation(String test, int setStation, int expected) {
        Radio station = new Radio(100);

        station.setCurrentStation(setStation);

        station.nextStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "border condition, 1, 0",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "not valid big value, 100, 0",
                    "not valid minus big value, -100, 0"
            }
    )
    void shouldToNextStationWithQuantityStationOne(String test, int setStation, int expected) {
        Radio station = new Radio(1);

        station.setCurrentStation(setStation);

        station.nextStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 6",
                    "border condition, 9, 0",
                    "border condition, 0, 1",
                    "border condition, -1, 1",
                    "border condition, 10, 1"
            }
    )
    void shouldToNextStationWithQuantityStationZero(String test, int setStation, int expected) {
        Radio station = new Radio(0);

        station.setCurrentStation(setStation);

        station.nextStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 6",
                    "border condition, 9, 0",
                    "border condition, 0, 1",
                    "border condition, -1, 1",
                    "border condition, 10, 1"
            }
    )
    void shouldToNextStationWithQuantityStationMinusOne(String test, int setStation, int expected) {
        Radio station = new Radio(-1);

        station.setCurrentStation(setStation);

        station.nextStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 6, 5",
                    "border condition, 0, 9",
                    "border condition, 9, 8",
                    "border condition, 1, 0",
                    "border condition, -1, 9",
                    "border condition, 10, 9"
            }
    )
    void shouldToPrevStationQuantityStationDefault(String test, int setStation, int expected) {
        Radio station = new Radio();

        station.setCurrentStation(setStation);

        station.prevStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 65, 64",
                    "border condition, 0, 99",
                    "border condition, 99, 98",
                    "border condition, 1, 0",
                    "border condition, -1, 99",
                    "border condition, 100, 99"
            }
    )
    void shouldToPrevStationWithBigQuantityStation(String test, int setStation, int expected) {
        Radio station = new Radio(100);

        station.setCurrentStation(setStation);

        station.prevStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 0, 0",
                    "border condition, 1, 0",
                    "border condition, -1, 0",
                    "border condition, 2, 0",
                    "not valid big minus value, -100, 0",
                    "not valid big value, 100, 0"
            }
    )
    void shouldToPrevStationWithQuantityStationOne(String test, int setStation, int expected) {
        Radio station = new Radio(1);

        station.setCurrentStation(setStation);

        station.prevStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 6, 5",
                    "border condition, 0, 9",
                    "border condition, 9, 8",
                    "border condition, 1, 0",
                    "border condition, -1, 9",
                    "border condition, 10, 9"
            }
    )
    void shouldToPrevStationWithQuantityStationMinusOne(String test, int setStation, int expected) {
        Radio station = new Radio(-1);

        station.setCurrentStation(setStation);

        station.prevStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 6, 5",
                    "border condition, 0, 9",
                    "border condition, 9, 8",
                    "border condition, 1, 0",
                    "border condition, -1, 9",
                    "border condition, 10, 9"
            }
    )
    void shouldToPrevStationWithQuantityStationZero(String test, int setStation, int expected) {
        Radio station = new Radio(0);

        station.setCurrentStation(setStation);

        station.prevStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 55, 56",
                    "border condition, 101, 100",
                    "border condition, 100, 100",
                    "border condition, 99, 100",
                    "border condition, -1, 1",
                    "border condition, 0, 1",
                    "border condition, 1, 2",
                    "not valid value, -15, 1",
                    "not valid value, 150, 100"
            }
    )
    void shouldToIncreaseVolume(String test, int setVolume, int expected) {
        Radio volume = new Radio();

        volume.setCurrentVolume(setVolume);

        volume.increaseVolume();

        int actual = volume.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 66, 65",
                    "border condition, 101, 99",
                    "border condition, 100, 99",
                    "border condition, 99, 98",
                    "border condition, 1, 0",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "not valid value, -15, 0",
                    "not valid value, 150, 99"
            }
    )
    void shouldToDecreaseVolume(String test, int setVolume, int expected) {
        Radio volume = new Radio();

        volume.setCurrentVolume(setVolume);

        volume.decreaseVolume();

        int actual = volume.getCurrentVolume();

        assertEquals(expected, actual);
    }
}
