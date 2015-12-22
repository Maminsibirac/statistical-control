package info.smart_tools.statistical_control.control_charts.shewhart.actors;

import java.math.BigDecimal;
import java.util.Map;

public class Coefficients {

    private Map<Integer, Map<String, BigDecimal>> values;

    public Coefficients() {}

    public Map<Integer, Map<String, BigDecimal>> getValues() {
        return values;
    }
}
