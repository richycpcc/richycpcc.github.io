package io.catalyte.training.controllers;

import static io.catalyte.training.constants.StringConstants.CONTEXT_VACCINATIONS;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.catalyte.training.entities.Pet;
import io.catalyte.training.entities.Vaccination;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class VaccinationControllerTest {

  ResultMatcher okStatus = MockMvcResultMatchers.status().isOk();
  ResultMatcher createdStatus = MockMvcResultMatchers.status().isCreated();
  ResultMatcher deletedStatus = MockMvcResultMatchers.status().isNoContent();
  ResultMatcher notFoundStatus = MockMvcResultMatchers.status().isNotFound();
  ResultMatcher expectedType = MockMvcResultMatchers.content()
      .contentType(MediaType.APPLICATION_JSON);

  ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private WebApplicationContext wac;
  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
    this.mockMvc = builder.build();
  }

  @Test
  public void getVaccinationsReturnsFour() throws Exception {
    mockMvc
        .perform(get(CONTEXT_VACCINATIONS))
        .andExpect(okStatus) // always check status first
        .andExpect(expectedType)
        .andExpect(jsonPath("$", hasSize(4)));
  }

  @Test
  public void getVaccinationThatDoesExistById() throws Exception {
    mockMvc
        .perform(get(CONTEXT_VACCINATIONS + "/1"))
        .andExpect(okStatus)
        .andExpect(expectedType)
        .andExpect(jsonPath("$.innoculation", is("Rabies")));
  }

  @Test
  public void postNewVaccination() throws Exception {
    Vaccination vaccination = new Vaccination();
    Pet pet = new Pet();

    pet.setId(1L);
    pet.setName("Cletus");
    pet.setBreed("Dog");
    pet.setAge(6);

    vaccination.setInnoculation("Rabies");
    vaccination.setDate(Date.from(
        LocalDate.parse("2019-10-17").atStartOfDay(ZoneId.systemDefault()).toInstant()));

    vaccination.setPet(pet);

    String vaccinationAsJson = mapper.writeValueAsString(vaccination);

    mockMvc
        .perform(post(CONTEXT_VACCINATIONS)
            .contentType(MediaType.APPLICATION_JSON)
            .content(vaccinationAsJson))
        .andExpect(createdStatus)
        .andExpect(expectedType)
        .andExpect(jsonPath("$.innoculation", is("Rabies")));
  }

  @Test
  public void deleteVaccination() throws Exception {
    mockMvc
        .perform(delete(CONTEXT_VACCINATIONS + "/3"))
        .andExpect(deletedStatus); //all we can do is check status
  }

}