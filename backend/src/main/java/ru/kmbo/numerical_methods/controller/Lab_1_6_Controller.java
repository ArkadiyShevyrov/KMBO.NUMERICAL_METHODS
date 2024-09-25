package ru.kmbo.numerical_methods.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.NumericalIntegration;
import ru.kmbo.numerical_methods.model.function.Function;
import ru.kmbo.numerical_methods.model.operand.Operand;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/lab_1_6")
@CrossOrigin(origins = "http://localhost:3000")
public class Lab_1_6_Controller {

    @PutMapping("/integrate")
    public ResponseEntity<String> firstDerivative(
            @RequestParam NumericalIntegration.TypeMethod typeMethod,
            @RequestParam Double a,
            @RequestParam Double b,
            @RequestParam Double h,
            @RequestBody Function f
    ) {
        Double result = NumericalIntegration.integrate(f, a, b, h, typeMethod);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestBody Operand operand) {
        Double result = operand.getResult();
        return ResponseEntity.ok(result);
    }
}
