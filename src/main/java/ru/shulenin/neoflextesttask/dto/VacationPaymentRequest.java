package ru.shulenin.neoflextesttask.dto;

import jakarta.validation.constraints.Positive;
import lombok.Value;

@Value
public class VacationPaymentRequest {
    @Positive
    Double averageMonthlyPayment;

    @Positive
    Integer daysAmount;
}
