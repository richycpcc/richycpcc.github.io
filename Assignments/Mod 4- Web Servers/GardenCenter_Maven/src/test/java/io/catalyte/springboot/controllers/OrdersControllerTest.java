package io.catalyte.springboot.controllers;

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

import static io.catalyte.springboot.constants.StringConstants.CONTEXT_ORDERS;
import static io.catalyte.springboot.constants.StringConstants.CONTEXT_PRODUCTS;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class OrdersControllerTest {
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
    public void getAllOrdersReturnsAtLeastThree() throws Exception {
        mockMvc
                .perform(get(CONTEXT_ORDERS))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$", hasSize(greaterThan(3))));
    }

    @Test
    public void getProductThatDoesExistById() throws Exception {
        mockMvc
                .perform(get(CONTEXT_ORDERS + "/1"))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.orderTotal", is(100.00)));
    }


    @Test
    public void saveNewProduct() throws Exception {
        String json = "{\"date\":\"2023-02-22\",\"item\":{\"quantity\":1,\"productId\":3},\"orderTotal\":15}";
        this.mockMvc
                .perform(post(CONTEXT_ORDERS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(createdStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.date", is("2023-02-22")));
    }


    @Test
    public void updateProductById() throws Exception {
        String json = "{\"id\":1,\"date\":\"3000-02-22\",\"item\":{\"quantity\":1,\"productId\":3},\"orderTotal\":15}";

        this.mockMvc
                .perform(put(CONTEXT_ORDERS+"/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.date", is("3000-02-22")));
    }


    @Test
    //@DirtiesContext
    public void deleteOrders() throws Exception {
        mockMvc
                .perform(delete(CONTEXT_ORDERS + "/5"))
                .andExpect(deletedStatus);
    }
}