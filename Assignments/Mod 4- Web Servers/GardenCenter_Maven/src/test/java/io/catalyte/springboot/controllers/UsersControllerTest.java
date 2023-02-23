package io.catalyte.springboot.controllers;
import static io.catalyte.springboot.constants.StringConstants.CONTEXT_USERS;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import io.catalyte.springboot.entities.Users;
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


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UsersControllerTest {

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
    public void setUp() {

        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void getAllUsersReturnsAtLeastThree() throws Exception {
        mockMvc
                .perform(get(CONTEXT_USERS))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$", hasSize(greaterThan(3))));
    }

    @Test
    public void getUserThatDoesExistById() throws Exception {
        mockMvc
                .perform(get(CONTEXT_USERS + "/1"))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.name", is("Harry Potter")));
    }


    @Test
    public void saveNewUser() throws Exception {
       String json = "{\"name\":\"Ginny Weasley\",\"title\":\"Manager\", \"roles\":[\"Employee\"],\"email\":\"gw2@test.com\",\"password\": \"Password1!\"}";

        this.mockMvc
                .perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(createdStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.name", is("Ginny Weasley")));
    }


    @Test
    public void updateUserById() throws Exception {
        String json = "{\"id\":1,\"name\":\"Harry Potter\",\"title\":\"The Boy Who Lived\",\"roles\":[\"Admin\"],\"email\":\"hp1@test.com\",\"password\":\"abc12345\"}";
        this.mockMvc
                .perform(put(CONTEXT_USERS+"/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.title", is("The Boy Who Lived")));
    }


    @Test
    //@DirtiesContext
    public void deleteUser() throws Exception {
        mockMvc
                .perform(delete("/users/3"))
                .andExpect(deletedStatus);
    }
} //end class
