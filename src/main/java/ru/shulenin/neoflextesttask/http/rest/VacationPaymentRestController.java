package ru.shulenin.neoflextesttask.http.rest;

import lombok.extern.slf4j.Slf4j;
import ru.shulenin.neoflextesttask.dto.VacationPaymentRequest;
import ru.shulenin.neoflextesttask.dto.VacationPaymentResponse;
import ru.shulenin.neoflextesttask.service.VacationPaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class VacationPaymentRestController {
    private final VacationPaymentService vacationPaymentService;

    @GetMapping("/calculate")
    @ResponseStatus(HttpStatus.OK)
    public VacationPaymentResponse calculate(@Valid VacationPaymentRequest request) {
        log.info(String.format("GET /calculate: the request with the parameters %s " +
                "was received by the server", request));
        return vacationPaymentService.calculate(request);
    }

}
