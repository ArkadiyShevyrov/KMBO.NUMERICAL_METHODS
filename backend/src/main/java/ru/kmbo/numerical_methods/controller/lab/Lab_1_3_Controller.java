package ru.kmbo.numerical_methods.controller.lab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kmbo.numerical_methods.calculate.InterpolationCalculate;
import ru.kmbo.numerical_methods.model.function.implementation.TabularFunction;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/lab_1_3")
@CrossOrigin(origins = "http://localhost:3000")
public class Lab_1_3_Controller {

    @PostMapping("/lagrange-interpolation")
    public ResponseEntity<String> lagrangeInterpolation(
            @RequestParam Double x,
            @RequestBody TabularFunction function
    ) {
        log.info("Получен запрос на вычисление интерполяционного полинома Лагранжа функции{} в точке {}",
                function, x);
        Double result = InterpolationCalculate.lagrangeInterpolate(function, x);
        log.info("Результат вычисления интерполяционного полинома Лагранжа функции {} в точке {}: {}",
                function, x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @PostMapping("/newton-interpolation")
    public ResponseEntity<String> newtonInterpolation(
            @RequestParam Double x,
            @RequestBody TabularFunction function
    ) {
        log.info("Получен запрос на вычисление интерполяционного полинома Ньютона функции{} в точке {}",
                function, x);
        Double result = InterpolationCalculate.newtonInterpolate(function, x);
        log.info("Результат вычисления интерполяционного полинома Ньютона функции {} в точке {}: {}",
                function, x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }
}
