package ru.shulenin.neoflextesttask.service;

import lombok.extern.slf4j.Slf4j;
import ru.shulenin.neoflextesttask.dto.VacationPaymentRequest;
import ru.shulenin.neoflextesttask.dto.VacationPaymentResponse;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VacationPaymentService {
    private final static Integer AVERAGE_DAYS_NUMBER_IN_A_MONTH = 30;

    public VacationPaymentResponse calculate(VacationPaymentRequest request) {
        var vacationPaymentAmount = request.getAverageMonthlyPayment() / AVERAGE_DAYS_NUMBER_IN_A_MONTH
                * request.getDaysAmount();

        log.info(String.format("VacationPaymentService.calculate(%s): vacationPaymentAmount " +
                "has been calculated %s", request, vacationPaymentAmount));

        return new VacationPaymentResponse(vacationPaymentAmount);
    }
}
