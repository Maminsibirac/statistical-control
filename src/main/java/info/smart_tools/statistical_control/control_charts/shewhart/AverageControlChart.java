package info.smart_tools.statistical_control.control_charts.shewhart;

import java.util.*;
import java.util.stream.Collectors;

public class AverageControlChart<DataType extends Number & Comparable>
        implements ControlChart<DataType, AverageControlGroup<DataType>> {
    /**  */
    private Coefficients coefficients;
    /**  */
    private Integer dimensionNumber;
    /**  */
    private Double centralLine;
    /**  */
    private Double upperCentralLine;
    /**  */
    private Double lowerCentralLine;

    public AverageControlChart(final Coefficients coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public ControlChart build(List<AverageControlGroup<DataType>> groups) {
        dimensionNumber = groups.get(0).size();
        centralLine = calculateCentralLine(groups);
        Double averageRange = calculateAverageRange(groups);
        upperCentralLine = calculateUpperCentralLine(averageRange);
        lowerCentralLine = calculateLowerCentralLine(averageRange);

        return this;
    }

    @Override
    public Double getLowerCentralLine() {
        return lowerCentralLine;
    }

    @Override
    public Double getUpperCentralLine() {
        return upperCentralLine;
    }

    @Override
    public Double getCentralLine() {
        return centralLine;
    }

    private Double calculateAverageRange(final List<AverageControlGroup<DataType>> groups) {
        List<Double> ranges = new ArrayList<>(groups.size());
        ranges.addAll(groups.stream().map(this::calculateRange).collect(Collectors.toList()));

        return calculateAverage(ranges);
    }

    private Double calculateRange(final AverageControlGroup<DataType> group) {
        Number max = Collections.max(group);
        Number min = Collections.min(group);

        return max.doubleValue() - min.doubleValue();
    }

    private Double calculateCentralLine(final List<AverageControlGroup<DataType>> groups) {
        List<Double> averageValues = new ArrayList<>(groups.size());
        for (AverageControlGroup<DataType> group : groups) {
            averageValues.add(calculateAverage(group));
        }

        return calculateAverage(averageValues);
    }

    private Double calculateAverage(final List<? extends Number> values) {
        Double sum = 0.0;
        for (Number value : values) {
            sum = sum + value.doubleValue();
        }

        return sum / values.size();
    }

    private Double calculateUpperCentralLine(final Double calculationCoefficient) {
        return centralLine + (calculationCoefficient * coefficients.get(dimensionNumber, "A2").doubleValue());
    }

    private Double calculateLowerCentralLine(final Double calculationCoefficient) {
        return centralLine - (calculationCoefficient * coefficients.get(dimensionNumber, "A2").doubleValue());
    }
}
