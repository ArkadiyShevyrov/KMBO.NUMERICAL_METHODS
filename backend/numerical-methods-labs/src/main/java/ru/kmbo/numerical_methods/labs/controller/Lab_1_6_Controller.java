package ru.kmbo.numerical_methods.labs.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kmbo.numerical_methods.core.calculate.integration.numeral.one_dimensional.NumericalIntegration;
import ru.kmbo.numerical_methods.core.model.function.implementation.OperandFunction;
import ru.kmbo.numerical_methods.labs.service.Lab_1_6_Service;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/lab_1_6")
@CrossOrigin(origins = "http://localhost:3000")
public class Lab_1_6_Controller {
    @NonNull
    private final Lab_1_6_Service service;

    @PostMapping("/integrate")
    public ResponseEntity<String> integrate(
        @RequestParam NumericalIntegration.TypeMethod typeMethod,
        @RequestParam Double a,
        @RequestParam Double b,
        @RequestParam Double h,
        @RequestBody OperandFunction f
    ) {
        log.info("Integrate function: function:{}", f.toString());
        Double result = service.integrate(f, a, b, h, typeMethod);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @PostMapping("/integrate/tolerance")
    public ResponseEntity<String> integrateTolerance(
        @RequestParam NumericalIntegration.TypeMethod typeMethod,
        @RequestParam Double a,
        @RequestParam Double b,
        @RequestParam Double h,
        @RequestBody OperandFunction f
    ) {
        log.info("Integrate function tolerance: function:{}", f.toString());
        Double result = service.tolerance(f, a, b, h, typeMethod);
        return ResponseEntity.ok(String.valueOf(result));
    }
}
