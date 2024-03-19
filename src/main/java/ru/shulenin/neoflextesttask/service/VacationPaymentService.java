package ru.shulenin.neoflextesttask.service;

import ru.shulenin.neoflextesttask.dto.VacationPaymentRequest;
import ru.shulenin.neoflextesttask.dto.VacationPaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class VacationPaymentService {
    private final static Integer AVERAGE_DAYS_NUMBER_IN_A_MONTH = 30;

    public VacationPaymentResponse calculate(VacationPaymentRequest request) {
        var vacationPaymentAmount = request.getAverageMonthlyPayment() / AVERAGE_DAYS_NUMBER_IN_A_MONTH
                * request.getDaysAmount();

        return new VacationPaymentResponse(vacationPaymentAmount);
    }
}
