package ru.kmbo.numerical_methods.core.model.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Point {
    private Double x;
    private Double y;

    @Override
    public String toString() {
        return "{" + x + "," + y + "}";
    }
}
