package ru.kmbo.numerical_methods.core.model.basic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class Vector {
    private Map<Integer, Double> data = new HashMap<>();

    public Double get(int i) {
        if (data.get(i) == null) {
            return 0.0;
        }
        return data.get(i);
    }

    public void set(int i, Double value) {
        data.put(i, value);
    }

    public Integer size() {
        return data.size();
    }

    public void swapRow(int row1, int row2) {
        if (row1 < 0 || row2 < 0 || row1 >= data.size() || row2 >= data.size()) {
            throw new IllegalArgumentException("Row indices out of bounds");
        }

        Double temp = data.get(row1);
        data.put(row1, data.get(row2));
        data.put(row2, temp);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[\n");
        for (Map.Entry<Integer, Double> iE : data.entrySet()) {
            b.append("[").append(iE.getKey()).append(":").append(iE.getValue()).append("]");
            b.append("\n");
        }
        b.append("]");
        return b.toString();
    }
}
