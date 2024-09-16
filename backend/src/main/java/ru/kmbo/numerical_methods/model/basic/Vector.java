package ru.kmbo.numerical_methods.model.basic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Vector {
    private List<Double> data = new ArrayList<>();

    public Double get(int i) {
        return data.get(i);
    }

    public void set(int i, Double value) {
        data.add(i, value);
    }

    public Integer size() {
        return data.size();
    }

    public void swapRow(int row1, int row2) {
        if (row1 < 0 || row2 < 0 || row1 >= data.size() || row2 >= data.size()) {
            throw new IllegalArgumentException("Row indices out of bounds");
        }

        Double temp = data.get(row1);
        data.set(row1, data.get(row2));
        data.set(row2, temp);
    }
}
