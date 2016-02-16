package info.smart_tools.statistical_control.control_charts.shewhart;

import java.util.ArrayList;
import java.util.Collection;

public class AverageControlGroup<DataType>
        extends ArrayList<DataType> implements ControlGroup<DataType> {

    public AverageControlGroup(int initialCapacity) {
        super(initialCapacity);
    }

    public AverageControlGroup(Collection<? extends DataType> c) {
        super(c);
    }
}
