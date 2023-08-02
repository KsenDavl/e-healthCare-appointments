package com.example.ehealthcarepatient.enums;

public enum DocSpecialization {

    GYN("Gynecology"),
    CRD("Cardiology"),
    ONC("Oncology"),
    DRM("Dermatology"),
    GST("Gastroenterology"),
    GPR("General Practice");

    private final String name;

    DocSpecialization(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
