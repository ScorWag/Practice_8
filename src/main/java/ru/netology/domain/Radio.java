package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {

    private int quantityStation = 10;
    private int minStation = 0;
    private int maxStation = quantityStation - 1;
    private int currentStation = minStation;
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume = minVolume;

    public Radio(int quantityStation) {
        if (quantityStation <= 0) {
            return;
        }
        this.quantityStation = quantityStation;
        this.maxStation = this.quantityStation - 1;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < minStation) {
            return;
        }
        if (currentStation > maxStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void nextStationSwitch() {
        if (currentStation >= maxStation) {
            currentStation = minStation;
            return;
        }
        this.currentStation = currentStation + 1;
    }

    public void prevStationSwitch() {
        if (currentStation <= minStation) {
            this.currentStation = maxStation;
            return;
        }
        this.currentStation = currentStation - 1;
    }


    public void increaseVolume() {
        if (currentVolume < minVolume) {
            this.currentVolume = 0;
        }
        if (currentVolume < maxVolume) {
            this.currentVolume = currentVolume + 1;
        }
        if (currentVolume >= maxVolume) {
            this.currentVolume = this.maxVolume;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > maxVolume) {
            this.currentVolume = maxVolume;
        }
        if (currentVolume > minVolume) {
            this.currentVolume = currentVolume - 1;
        }
        if (currentVolume <= minVolume) {
            this.currentVolume = minVolume;
        }
    }
}
