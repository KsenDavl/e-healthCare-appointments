package com.example.ehealthcarepatient.integration;

import com.example.ehealthcarepatient.repository.DoctorAvailableTimeSlotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = "classpath:data/01-init_test_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class AppointmentControllerTest extends AbstractIntegrationTest{

    @Autowired
    private DoctorAvailableTimeSlotRepository timeSlotRepository;

    private final HttpStatus OK_STATUS = HttpStatus.OK;

    @Test
    void shouldCreateAppointmentAndDeleteTimeSlot() throws Exception {
        mockMvc.perform(post(UriComponentsBuilder.fromPath("/appointment/2/12").toUriString()))
                .andExpect(status().is(OK_STATUS.value()));

        assertEquals(timeSlotRepository.findById(12L), Optional.empty());
        //todo add checking if appointment was created
    }
}