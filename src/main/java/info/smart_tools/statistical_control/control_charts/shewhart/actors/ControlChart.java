package info.smart_tools.statistical_control.control_charts.shewhart.actors;

import info.smart_tools.statistical_control.control_charts.shewhart.messages.IBuildControlChartMessage;
import info.smart_tools.statistical_control.control_charts.shewhart.messages.ICheckControlChartMessage;

public interface ControlChart {
    void build(final IBuildControlChartMessage message);
//    void build(final List<Map<String, Number>> preliminaryData);
    void check(final ICheckControlChartMessage message);
}
