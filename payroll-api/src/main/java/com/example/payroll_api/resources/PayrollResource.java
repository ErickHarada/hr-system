package com.example.payroll_api.resources;

import com.example.payroll_api.domain.Payroll;
import com.example.payroll_api.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PayrollResource {

    private final PayrollService payrollService;

    @GetMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return ResponseEntity.ok(payrollService.getPayment(workerId, payment));
    }
}
