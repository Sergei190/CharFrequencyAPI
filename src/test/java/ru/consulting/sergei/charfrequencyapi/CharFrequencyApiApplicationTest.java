package ru.consulting.sergei.charfrequencyapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * This class contains test cases for the Char Frequency API application.
 */
@SpringBootTest
@AutoConfigureMockMvc
class CharFrequencyApiApplicationTest {

    MockMvc mockMvc;

    @Autowired
    CharFrequencyApiApplicationTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    /**
     * Test method to ensure that the application context loads successfully.
     */
    @Test
    void contextLoads() {
    }

    /**
     * Test method to verify the functionality of your controller by performing a GET request to "/swagger-ui/".
     *
     * @throws Exception if an error occurs during the test.
     */
    @Test
    public void testYourController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/swagger-ui/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
