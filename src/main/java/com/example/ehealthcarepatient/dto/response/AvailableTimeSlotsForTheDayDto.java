package com.example.ehealthcarepatient.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableTimeSlotsForTheDayDto {

    private long id;

    private long doctorId;

    private LocalDate date;

    private String time;
}
