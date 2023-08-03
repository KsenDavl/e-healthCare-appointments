package com.example.ehealthcarepatient.enums;

public enum TimeSlot {

    A("10:00"),
    B("11:00"),
    C("12:00"),
    D("13:00"),
    E("15:00"),
    F("16:00");

    private final String time;

    TimeSlot(String time) {
        this.time = time;
    }

    String getTime() {
        return time;
    }

}
