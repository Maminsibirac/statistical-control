package info.smart_tools.statistical_control.control_charts.shewhart.messages;

import info.smart_tools.smartactors.core.IMessageWrapper;
import info.smart_tools.smartactors.core.IObject;

public interface IBuildControlChartMessage extends IMessageWrapper {
    IObject getBuildParams();
}
