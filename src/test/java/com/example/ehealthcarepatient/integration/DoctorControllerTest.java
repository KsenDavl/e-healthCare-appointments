package com.example.ehealthcarepatient.integration;

import com.example.ehealthcarepatient.entity.Doctor;
import com.example.ehealthcarepatient.enums.DocSpecialization;
import org.junit.jupiter.api.Test;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = "classpath:data/01-init_test_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@EnableSpringDataWebSupport
class DoctorControllerTest extends AbstractIntegrationTest {

    private final HttpStatus OK_STATUS = HttpStatus.OK;

    @Test
    void shouldReturnDoctorBySpecialization() throws Exception {
        List<Doctor> doctors = List.of(new Doctor(2, "Petr", "Myshkin",
                DocSpecialization.ONC, 203, List.of()));

        mockMvc.perform(get(UriComponentsBuilder.fromPath("/doctor/all/oncology").toUriString()))
                .andExpect(status().is(OK_STATUS.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.content().json(toJson(doctors)));
    }

    @Test
    void shouldReturnCorrectNumberOfSpecializations() throws Exception {
        int expectedNumberOfSpecializations = DocSpecialization.values().length;

        mockMvc.perform(get(UriComponentsBuilder.fromPath("/doctor/all-specializations").toUriString()))
                .andExpect(status().is(OK_STATUS.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(expectedNumberOfSpecializations)));
    }

    @Test
    void shouldReturnTwoAvailableTimeSlotsForTheDay() throws Exception {
        mockMvc.perform(get(UriComponentsBuilder.fromPath("/doctor/1/timeslots").toUriString())
                        .param("date", "2023-10-10"))
                .andExpect(status().is(OK_STATUS.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].time", is("10:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].time", is("11:00")));
    }
}