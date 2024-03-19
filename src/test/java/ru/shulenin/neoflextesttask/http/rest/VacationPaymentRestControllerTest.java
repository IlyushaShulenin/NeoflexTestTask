package ru.shulenin.neoflextesttask.http.rest;

import ru.shulenin.neoflextesttask.dto.VacationPaymentResponse;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class VacationPaymentRestControllerTest {
    private final MockMvc mockMvc;
    private final Gson gson = new Gson();

    @Test
    void calculate() throws Exception {
        var response = new VacationPaymentResponse(20000D);
        var jsonResponse = gson.toJson(response);

        mockMvc.perform(get("/calculate")
                    .param("averageMonthlyPayment", "50000")
                    .param("daysAmount", "12"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonResponse));
    }

    @Test
    void calculateWrongCase() throws Exception {
        mockMvc.perform(get("/calculate")
                        .param("averageMonthlyPayment", "-50000")
                        .param("daysAmount", "12"))
                .andExpect(status().isBadRequest());

        mockMvc.perform(get("/calculate")
                        .param("averageMonthlyPayment", "50000")
                        .param("daysAmount", "-12"))
                .andExpect(status().isBadRequest());
    }
}