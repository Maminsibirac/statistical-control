package info.smart_tools.statistical_control.control_charts.shewhart.actors;

import info.smart_tools.smartactors.core.*;
import info.smart_tools.smartactors.core.actors.Actor;
import info.smart_tools.smartactors.core.actors.annotations.Handler;
import info.smart_tools.statistical_control.control_charts.shewhart.messages.IBuildControlChartMessage;
import info.smart_tools.statistical_control.control_charts.shewhart.messages.ICheckControlChartMessage;

import java.math.BigDecimal;

public class AverageControlChart extends Actor implements ControlChart {
    /**  */
    private final Coefficients COEFFICIENTS = new Coefficients();
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

    /**  */
    private final Field<IObject> PARAMETERS = new Field<IObject>(new FieldName("parameters"));
    /**  */
    private final Field<Integer> DIMENSION_NUMBER = new Field<>(new FieldName("dimensionField"));
    private final Field<BigDecimal> STANDARD_DEVIATION = new Field<>(new FieldName("standardDeviation"));
    private final Field<BigDecimal> CENTRAL_LINE = new Field<>(new FieldName("centralLine"));

    /**
     *
     * @param params
     */
    public AverageControlChart(final IObject params) {
        try {
            IObject parameters = PARAMETERS.from(params, IObject.class);
            if (parameters == null) {
                return;
            }

            dimensionNumber = DIMENSION_NUMBER.from(parameters, Integer.class);
            centralLine = CENTRAL_LINE.from(parameters, BigDecimal.class);
            standardDeviation = STANDARD_DEVIATION.from(parameters, BigDecimal.class);
            upperCentralLine = calculateUpperCentralLine();
            lowerCentralLine = calculateLowerCentralLine();
        } catch (ReadValueException | ChangeValueException e) {
            //ToDO : handle.
        }
    }

    /**
     *
     * @param message
     */
    @Override
    @Handler("build")
    public void build(final IBuildControlChartMessage message) {
        if (message.getBuildParams() == null) {
            //ToDO : handle exception.
        }

    }

    /**
     *
     * @param message
     */
    @Override
    @Handler("check")
    public void check(final ICheckControlChartMessage message) {

    }

    private BigDecimal calculateUpperCentralLine() {
        return centralLine.add(
                standardDeviation.multiply(COEFFICIENTS.getValues().get(dimensionNumber).get("A1"))
        );
    }

    private BigDecimal calculateLowerCentralLine() {
        return centralLine.subtract(
                standardDeviation.multiply(COEFFICIENTS.getValues().get(dimensionNumber).get("A1"))
        );
    }
}
