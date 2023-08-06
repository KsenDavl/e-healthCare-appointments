package com.example.ehealthcarepatient.mapper;

import com.example.ehealthcarepatient.dto.response.AvailableTimeSlotsForTheDayDto;
import com.example.ehealthcarepatient.entity.Appointment;
import com.example.ehealthcarepatient.entity.DoctorAvailableTimeSlot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {

    @Mapping(expression = "java(timeSlotEntity.getDoctor().getId())", target = "doctorId")
    @Mapping(expression = "java(timeSlotEntity.getTimeSlot().getTime())", target = "time")
    AvailableTimeSlotsForTheDayDto toDto(DoctorAvailableTimeSlot timeSlotEntity);

    List<AvailableTimeSlotsForTheDayDto> toDtoList(List<DoctorAvailableTimeSlot> timeSlotEntities);

    @Mapping(target = "id", ignore = true)
    Appointment toAppointment(DoctorAvailableTimeSlot timeSlot);
}
