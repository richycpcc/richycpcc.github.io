package io.catalyte.springboot.controllers;

import io.catalyte.springboot.entities.Address;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.internal.matchers.ContainsExtraTypeInfo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static io.catalyte.springboot.constants.StringConstants.CONTEXT_CUSTOMERS;
import static io.catalyte.springboot.constants.StringConstants.CONTEXT_USERS;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class CustomersControllerTest {

    ResultMatcher okStatus = MockMvcResultMatchers.status().isOk();
    ResultMatcher createdStatus = MockMvcResultMatchers.status().isCreated();
    ResultMatcher deletedStatus = MockMvcResultMatchers.status().isNoContent();
    ResultMatcher notFoundStatus = MockMvcResultMatchers.status().isNotFound();
    ResultMatcher badRequestStatus = MockMvcResultMatchers.status().isBadRequest();
    ResultMatcher dataErrorStatus = MockMvcResultMatchers.status().isServiceUnavailable();
    ResultMatcher serverErrorStatus = MockMvcResultMatchers.status().isInternalServerError();
    ResultMatcher expectedType = MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_JSON);

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;


    @BeforeEach
    public void setUp(){

        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void getAllCustomersReturnsAtLeastThree() throws Exception {
        mockMvc
                .perform(get(CONTEXT_CUSTOMERS))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$", hasSize(greaterThan(3))));
    }

    @Test
    public void getUserThatDoesExistById() throws Exception {
        mockMvc
                .perform(get(CONTEXT_CUSTOMERS + "/1"))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.name", is("Richy Phongsavath")));
    }


    @Test
    public void saveNewCustomer() throws Exception {

        String json = "{\"name\":\"Steve Rover\",\"email\":\"sr99@test.org\",\"address\":{\"street\":\"98 Crossing\",\"City\":\"Denver\",\"State\":\"CO\",\"zipCode\":89364}}";
        this.mockMvc
                .perform(post(CONTEXT_CUSTOMERS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(createdStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.name", is("Steve Rover")));
    }


    @Test
    public void updateUserById() throws Exception {
        String json = "{\"id\":6,\"name\":\"Leo Tostoy\",\"email\":\"yt1@test.org\",\"address\":{\"id\":6,\"street\":\"5 Block\",\"City\":\"Denver\",\"State\":\"CO\",\"zipCode\":89364}}";
        this.mockMvc
                .perform(put(CONTEXT_CUSTOMERS+"/6")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.name", is("Leo Tostoy")));
    }


    @Test
    //@DirtiesContext
    public void deleteUser() throws Exception {
        mockMvc
                .perform(delete(CONTEXT_CUSTOMERS+"/3"))
                .andExpect(deletedStatus);
    }

}