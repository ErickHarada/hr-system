package com.example.payroll_api.services;

import com.example.payroll_api.domain.Payroll;
import com.example.payroll_api.domain.User;
import com.example.payroll_api.feignClients.UserFeign;
import com.example.payroll_api.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayrollService {

    private final Environment env;
    private final UserFeign userFeign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL_SERVICE ::: Get request on {} port", env.getProperty("local.server.port"));
        try {
            var user = userFeign.findById(workerId).getBody();
            if (Objects.nonNull(user)) {
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        user.getHourlyPrice() * payroll.getWorkedHours()
                );
            }
        } catch (FeignException.NotFound e) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception e) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}
