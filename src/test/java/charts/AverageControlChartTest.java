package charts;

import info.smart_tools.statistical_control.control_charts.shewhart.*;
import info.smart_tools.statistical_control.control_charts.shewhart.Coefficients;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AverageControlChartTest {
    private AverageControlChart<Double> controlChart;
    private List<AverageControlGroup<Double>> controlGroups;

    @Before
    public void before() {
        Coefficients coefficients = new Coefficients()
                .add(4, "A2", BigDecimal.valueOf(0.729));
        controlChart = new AverageControlChart<>(coefficients);

        controlGroups = new ArrayList<>();
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.1898, 0.1729, 0.2067, 0.1898)));
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.2012, 0.1913, 0.1878, 0.1921)));
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.2217, 0.2192, 0.2078, 0.1980)));
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.1832, 0.1812, 0.1963, 0.1800)));
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.1692, 0.2263, 0.2066, 0.2091)));
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.1621, 0.1832, 0.1914, 0.1783)));
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.2001, 0.1937, 0.2169, 0.2082)));
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.2401, 0.1825, 0.1910, 0.2264)));
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.1996, 0.1980, 0.2076, 0.2023)));
        controlGroups.add(new AverageControlGroup<>(Arrays.asList(0.1783, 0.1715, 0.1829, 0.1961)));
    }

    @Test
    public void buildTest() {
        assertEquals(controlChart.build(controlGroups).getCentralLine(), BigDecimal.valueOf(0.19605));
    }
}
