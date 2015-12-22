package info.smart_tools.statistical_control.control_charts.shewhart;

import info.smart_tools.statistical_control.control_charts.shewhart.actors.Coefficients;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageControlChart implements ControlChart {
    /**  */
    private Coefficients coefficients;
    /**  */
    private Integer dimensionNumber;
    /**  */
    private BigDecimal centralLine;
    /**  */
    private BigDecimal upperCentralLine;
    /**  */
    private BigDecimal lowerCentralLine;
    /**  */
    private BigDecimal standardDeviation;

    private AverageControlChart(final Coefficients coefficients) {
        this.coefficients = coefficients;
    }

    public static AverageControlChart create(final Coefficients coefficients) {
        return new AverageControlChart(coefficients);
    }

    @Override
    public ControlChart build(final List<ControlGroup> standardGroups) {
        Map<String, BigDecimal> average = new HashMap<>(standardGroups.size());
        for (ControlGroup controlGroup : standardGroups) {
            average.put("X", );
            average.put("R", );
        }
    }

    @Override
    public List<ControlGroup> check(final List<ControlGroup> controlGroups) {
        return null;
    }

    @Override
    public BigDecimal getLowerCentralLine() {
        return lowerCentralLine;
    }

    @Override
    public BigDecimal getUpperCentralLine() {
        return upperCentralLine;
    }

    @Override
    public BigDecimal getCentralLine() {
        return centralLine;
    }
}
