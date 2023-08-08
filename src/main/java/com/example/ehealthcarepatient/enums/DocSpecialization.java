package com.example.ehealthcarepatient.enums;

import java.util.Optional;

public enum DocSpecialization {

    GYN("gynecology"),
    CRD("cardiology"),
    ONC("oncology"),
    DRM("dermatology"),
    GST("gastroenterology"),
    GPR("generalPractice");

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
