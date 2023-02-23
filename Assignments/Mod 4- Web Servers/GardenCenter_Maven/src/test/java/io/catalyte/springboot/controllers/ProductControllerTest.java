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

import static io.catalyte.springboot.constants.StringConstants.CONTEXT_PRODUCTS;
import static io.catalyte.springboot.constants.StringConstants.CONTEXT_USERS;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
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
    public void getAllProductsReturnsAtLeastTwo() throws Exception {
        mockMvc
                .perform(get(CONTEXT_PRODUCTS))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$", hasSize(greaterThan(2))));
    }

    @Test
    public void getProductThatDoesExistById() throws Exception {
        mockMvc
                .perform(get(CONTEXT_PRODUCTS + "/1"))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.type", is("Plant")));
    }


    @Test
    public void saveNewProduct() throws Exception {
        String json = "{\"sku\":\"93447P\",\"type\":\"Plant\",\"name\":\"Fig Tree\",\"description\":\"mature fig tree\",\"manufacturer\":\"YMH Gardens\",\"price\":59.99}";
        this.mockMvc
                .perform(post(CONTEXT_PRODUCTS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(createdStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.name", is("Fig Tree")));
    }


    @Test
    public void updateProductById() throws Exception {
        String json = "{\"id\":3,\"sku\":\"53213D\",\"type\":\"Beverage\",\"name\":\"Diet Sir Plant\",\"description\":\"12 oz Soda\",\"manufacturer\":\"Drink Up\",\"price\":5.00}";
        this.mockMvc
                .perform(put(CONTEXT_PRODUCTS+"/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(okStatus)
                .andExpect(expectedType)
                .andExpect(jsonPath("$.name", is("Diet Sir Plant")));
    }


    @Test
    //@DirtiesContext
    public void deleteProduct() throws Exception {
        mockMvc
                .perform(delete(CONTEXT_PRODUCTS + "/1"))
                .andExpect(deletedStatus);
    }

}