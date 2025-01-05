package ru.kmbo.numerical_methods.core.model.basic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class Matrix {
    private Map<Integer, Map<Integer, Double>> data = new HashMap<>();

    public Double get(int i, int j) {
        if (data.get(i) == null) {
            return 0.0;
        }
        if (data.get(i).get(j) == null) {
            return 0.0;
        }
        return data.get(i).get(j);
    }

    public void set(int i, int j, Double value) {
        data.computeIfAbsent(i, k -> new HashMap<>());
        data.get(i).put(j, value);
    }

    public void swapRow(int row1, int row2) {
        if (row1 < 0 || row2 < 0 || row1 >= data.size() || row2 >= data.size()) {
            throw new IllegalArgumentException("Row indices out of bounds");
        }

        Map<Integer, Double> temp = data.get(row1) == null ? new HashMap<>() : data.get(row1);
        data.put(row1, data.get(row2) == null ? new HashMap<>() : data.get(row2));
        data.put(row2, temp);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[\n");
        for (Map.Entry<Integer, Map<Integer, Double>> iE : data.entrySet()) {
            Map<Integer, Double> ie = iE.getValue();
            for (Map.Entry<Integer, Double> jE : ie.entrySet()) {
                b.append("[(").append(iE.getKey()).append(",").append(jE.getKey()).append("):").append(jE.getValue()).append("]");
            }
            b.append("\n");
        }
        b.append("]");
        return b.toString();
    }
}