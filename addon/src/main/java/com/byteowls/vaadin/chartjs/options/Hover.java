package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import java.util.HashMap;
import java.util.Map;

public class Hover<T> extends And<T> implements JsonBuilder {

    public enum Mode {
        SINGLE, LABEL, DATASET
    }

    private Mode mode;
    private Integer animationDuration;
    // TODO Callback onhover Called when any of the events fire. Called in the context of the chart and passed an array of active elements (bars, points, etc)

    public Hover(T parent) {
        super(parent);
    }

    /**
     * <p>Sets which elements hover.</p>
     * single highlights the closest element
     * label highlights elements in all datasets at the same X value.
     * dataset highlights the closest dataset
     */
    public Hover<T> mode(Mode mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Duration in milliseconds it takes to animate hover style changes
     */
    public Hover<T> animationDuration(int animationDuration) {
        this.animationDuration = animationDuration;
        return this;
    }

    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = new HashMap();
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
        JUtils.putNotNull(map, "animationDuration", animationDuration);
        return map;
    }
}
