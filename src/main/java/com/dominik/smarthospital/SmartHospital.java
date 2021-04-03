package com.dominik.smarthospital;

import com.dominik.smarthospital.services.Core;
public class SmartHospital {

    public static void main(String[] args) {
        try {
            new Core();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
