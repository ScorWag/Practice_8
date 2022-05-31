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
    void setStation(String test, int setStation, int expected) {
        Radio station = new Radio();
        station.setCurrentStation(setStation);

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 6",
                    "border condition, 9, 0"
            }
    )
    void shouldToNextStation(String test, int setStation, int expected) {
        Radio station = new Radio();

        station.setCurrentStation(setStation);

        station.nextStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 6, 5",
                    "border condition, 0, 9"
            }
    )
    void shouldToPrevStation(String test, int setStation, int expected) {
        Radio station = new Radio();

        station.setCurrentStation(setStation);

        station.prevStationSwitch();

        int actual = station.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "valid value, 5, 6",
                    "border condition, 11, 10",
                    "border condition, 10, 10",
                    "border condition, 9, 10",
                    "border condition, -1, 1",
                    "border condition, 0, 1",
                    "border condition, 1, 2",
                    "not valid value, -15, 1",
                    "not valid value, 15, 10"
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
                    "valid value, 6, 5",
                    "border condition, 11, 9",
                    "border condition, 10, 9",
                    "border condition, 9, 8",
                    "border condition, 1, 0",
                    "border condition, 0, 0",
                    "border condition, -1, 0",
                    "not valid value, -15, 0",
                    "not valid value, 15, 9"
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
