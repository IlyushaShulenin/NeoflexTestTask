package ru.shulenin.neoflextesttask.http.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "ru.shulenin.neoflextesttask.http")
@Slf4j
public class VacationPaymentRestControllerAdvice {
    private final static String AVG_PAYMENT = "averageMonthlyPayment";
    private final static String DAYS_AMOUNT = "daysAmount";


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(MethodArgumentNotValidException e, HttpServletRequest request) {
        var averageMonthlyPayment = Double.parseDouble(request.getParameter(AVG_PAYMENT));
        var daysAmount = Double.parseDouble(request.getParameter(DAYS_AMOUNT));

        log.warn(String.format("GET %s: invalid parameters detected %s, %s",
                request.getServletPath(), averageMonthlyPayment, daysAmount));

        var message = e.getBody().getDetail();

        if (averageMonthlyPayment < 0)
            message = message +  " " + AVG_PAYMENT + "=" + averageMonthlyPayment;
        if (daysAmount < 0)
            message = message + " " + DAYS_AMOUNT + "=" + daysAmount;

        return message;
    }

}
