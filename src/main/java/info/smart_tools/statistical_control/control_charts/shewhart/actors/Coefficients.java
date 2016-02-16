package info.smart_tools.statistical_control.control_charts.shewhart.actors;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Coefficients {

    private Map<Integer, Map<String, Number>> values;

    public Coefficients() {
        this.values = new HashMap<>();
    }

    public Coefficients(final Map<Integer, Map<String, Number>> values) {
        this.values = values;
    }

    public Coefficients add(final int dimension, final String key, Number value) {
        if (!values.containsKey(dimension)) {
            Map<String, Number> param = new HashMap<>();
            param.put(key, value);
            values.put(dimension, param);
        } else {
            values.get(dimension).put(key, value);
        }

        return this;
    }

    public Number get(final int combinationCount, final String key) {
        return values.get(combinationCount).get(key);
    }
}
