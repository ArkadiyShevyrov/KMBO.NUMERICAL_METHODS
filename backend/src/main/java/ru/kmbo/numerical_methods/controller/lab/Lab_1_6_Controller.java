package ru.kmbo.numerical_methods.controller.lab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.NumericalIntegration;
import ru.kmbo.numerical_methods.model.function.implementation.OperandFunction;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/lab_1_6")
@CrossOrigin(origins = "http://localhost:3000")
public class Lab_1_6_Controller {

    @PostMapping("/integrate")
    public ResponseEntity<String> integrate(
            @RequestParam NumericalIntegration.TypeMethod typeMethod,
            @RequestParam Double a,
            @RequestParam Double b,
            @RequestParam Double h,
            @RequestBody OperandFunction f
    ) {
        Double result = NumericalIntegration.integrate(f, a, b, h, typeMethod);
        return ResponseEntity.ok(String.valueOf(result));
    }
}
