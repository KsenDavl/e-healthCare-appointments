package com.example.ehealthcarepatient.enums;

import java.util.Optional;

public enum DocSpecialization {

    GYN("Gynecology"),
    CRD("Cardiology"),
    ONC("Oncology"),
    DRM("Dermatology"),
    GST("Gastroenterology"),
    GPR("General Practice");

    private final String fullName;

    DocSpecialization(String name) {
        this.fullName = name;
    }

    public String getFullName() {
        return fullName;
    }

    public static Optional<DocSpecialization> getByName(String fullName) {
        for (DocSpecialization s : values()) {
            if (s.fullName.equals(fullName)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
}
