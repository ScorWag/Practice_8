package ru.netology.domain;

public class Radio {

    private int currentStation;
    private int currentVolume;

    public void setCurrentStation(int currentStation) {
        if (currentStation < 0) {
            return;
        }
        if (currentStation > 9) {
            return;
        }
        this.currentStation = currentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void nextStationSwitch() {
        if (currentStation == 9) {
            currentStation = 0;
            return;
        }
        this.currentStation = currentStation + 1;
        setCurrentStation(currentStation);
    }

    public void prevStationSwitch() {
        if (currentStation == 0) {
            this.currentStation = 9;
            return;
        }
        this.currentStation = currentStation - 1;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 0) {
            this.currentVolume = 0;
        }
        if (currentVolume < 10) {
            this.currentVolume = currentVolume + 1;
        }
        if (currentVolume >= 10) {
            this.currentVolume = 10;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 10) {
            this.currentVolume = 10;
        }
        if (currentVolume > 0) {
            this.currentVolume = currentVolume - 1;
        }
        if (currentVolume <= 0) {
            this.currentVolume = 0;
        }
    }
}
