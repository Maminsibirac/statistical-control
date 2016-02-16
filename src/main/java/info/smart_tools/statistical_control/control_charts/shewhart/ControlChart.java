package info.smart_tools.statistical_control.control_charts.shewhart;

import java.util.List;

public interface ControlChart<DataType extends Number, Group extends ControlGroup<DataType>> {
    /**
     *
     * @param groups
     * @return
     */
    ControlChart build(final List<Group> groups);

    /**
     *
     * @return
     */
    Number getCentralLine();

    /**
     *
     * @return
     */
    Number getUpperCentralLine();

    /**
     *
     * @return
     */
    Number getLowerCentralLine();
}
