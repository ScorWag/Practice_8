import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Radio;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {


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
    void setStationWithQuantityStation(String test, int setStation, int expected) {
        Radio station = new Radio(100);
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
    void setStationWithMinusQuantityStation(String test, int setStation, int expected) {
        Radio station = new Radio(-100);
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
    void shouldToNextStationWithQuantityStation(String test, int setStation, int expected) {
        Radio station = new Radio(100);

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
    void shouldToPrevStationWithQuantityStation(String test, int setStation, int expected) {
        Radio station = new Radio(100);

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
