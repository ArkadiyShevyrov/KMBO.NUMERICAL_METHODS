package ru.kmbo.numerical_methods.model.basic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Matrix {
    private List<List<Double>> data = new ArrayList<>();

    public Double get(int i, int j) {
        Double value = data.get(i).get(j);
        if (value == null) {
            return 0.0;
        }
        return value;
    }

    public void set(int i, int j, Double value) {
        if (i >= data.size() || data.get(i) == null) {
            data.add(new ArrayList<>());
        }
        data.get(i).add(j, value);
    }

    public void swapRow(int row1, int row2) {
        if (row1 < 0 || row2 < 0 || row1 >= data.size() || row2 >= data.size()) {
            throw new IllegalArgumentException("Row indices out of bounds");
        }

        List<Double> temp = data.get(row1);
        data.set(row1, data.get(row2));
        data.set(row2, temp);
    }
}