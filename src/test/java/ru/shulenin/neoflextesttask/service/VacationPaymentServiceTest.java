package ru.shulenin.neoflextesttask.service;

import ru.shulenin.neoflextesttask.dto.VacationPaymentRequest;
import ru.shulenin.neoflextesttask.service.VacationPaymentService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class VacationPaymentServiceTest {
    private final static Integer AVERAGE_DAYS_NUMBER_IN_A_MONTH = 30;
    private final VacationPaymentService vacationPaymentService;

    @Test
    void calculate() {
        var random = new Random();

        var randomAveragePayment = random.nextDouble();
        var randomDaysNumber = random.nextInt();

        var request = new VacationPaymentRequest(
                randomAveragePayment,
                randomDaysNumber
        );

        var response = vacationPaymentService.calculate(request);

        assertThat(response.getVacationPaymentAmount())
                .isEqualTo(calculate(randomAveragePayment, randomDaysNumber));
    }

    public Double calculate(Double averagePayment, Integer daysNumber) {
        return averagePayment / AVERAGE_DAYS_NUMBER_IN_A_MONTH
                * daysNumber;
    }
}