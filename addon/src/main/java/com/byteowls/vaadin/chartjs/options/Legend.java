package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class Legend<T> extends And<T> implements JsonBuilder {
    
    private Boolean display;
    private Position position;
    private Boolean fullWidth;
    private LegendLabel<T> labels;

    public Legend(T parent) {
        super(parent);
    }
    
    /**
     * Is the legend displayed. Default: true
     */
    public Legend<T> display(boolean display) {
        this.display = display;
        return this;
    }
    
    /**
     * Position of the legend. Options are 'top' or 'bottom'. Default: top
     */
    public Legend<T> position(Position position) {
        this.position = position;
        return this;
    }
    
    /**
     * Marks that this box should take the full width of the canvas (pushing down other boxes). Default: true
     */
    public Legend<T> fullWidth(boolean fullWidth) {
        this.fullWidth = fullWidth;
        return this;
    }
    
    public LegendLabel<T> labels() {
        if (labels == null) {
            labels = new LegendLabel<>(this);
        }
        return labels;
    }

    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = new HashMap();
        JUtils.putNotNull(map, "display", display);
        if (position != null) {
            JUtils.putNotNull(map, "position", position.name().toLowerCase());
        }
        JUtils.putNotNull(map, "fullWidth", fullWidth);
        JUtils.putNotNull(map, "labels", labels);
        return map;
    }

}
