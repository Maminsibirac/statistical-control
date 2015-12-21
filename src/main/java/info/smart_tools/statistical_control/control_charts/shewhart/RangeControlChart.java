package info.smart_tools.statistical_control.control_charts.shewhart;

import info.smart_tools.smartactors.core.IObject;
import info.smart_tools.smartactors.core.actors.Actor;
import info.smart_tools.smartactors.core.actors.annotations.Handler;

import java.util.List;

public class RangeControlChart extends Actor implements ControlChart {

    public RangeControlChart(final IObject params) {}

    @Handler("check")
    public ControlResult check(final List<ControlGroup> groups) {

    }
}
