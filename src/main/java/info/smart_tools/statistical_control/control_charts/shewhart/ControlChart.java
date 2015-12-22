package info.smart_tools.statistical_control.control_charts.shewhart;

import java.math.BigDecimal;
import java.util.List;

public interface ControlChart {
    ControlChart build(final List<ControlGroup> standardGroups);
    List<ControlGroup> check(final List<ControlGroup> controlGroups);

    BigDecimal getCentralLine();
    BigDecimal getUpperCentralLine();
    BigDecimal getLowerCentralLine();
}
