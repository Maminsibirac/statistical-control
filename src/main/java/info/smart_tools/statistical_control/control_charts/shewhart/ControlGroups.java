package info.smart_tools.statistical_control.control_charts.shewhart;

import java.util.ArrayList;
import java.util.List;

public class ControlGroups<T> {
    private int capacity;
    private List<ControlGroup<T>> groups;

    public ControlGroups(final int capacity) {
        if (capacity < 1)
            // ToDo : change exception.
            throw new IllegalArgumentException();
        this.capacity = capacity;
        this.groups = new ArrayList<>(capacity);
    }

    public int getSize() {
        return capacity;
    }

    public ControlGroups<T> add(final ControlGroup<T> group) {
        if (groups.size() >= capacity)
            // ToDo : change exception.
            throw new IllegalArgumentException();
        groups.add(group);

        return this;
    }

    public ControlGroups<T> add(final List<ControlGroup<T>> groups) {
        if (groups.size() > capacity || groups.size() + this.groups.size() > this.capacity) {
            // ToDo : change exception.
            throw new IllegalArgumentException();
        }
        this.groups.addAll(groups);

        return this;
    }

    public List<ControlGroup<T>> getAll() {
        return groups;
    }
}
