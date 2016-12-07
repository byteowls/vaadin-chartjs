package com.byteowls.vaadin.chartjs.options.types;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.AbstractOptions;
import com.byteowls.vaadin.chartjs.options.PieAnimation;
import com.byteowls.vaadin.chartjs.utils.JUtils;

import java.util.Map;

public class PieChartOptions extends AbstractOptions<PieChartOptions> {
    
    private Double cutoutPercentage;
    private Double rotation;
    private Double circumference;
    private PieAnimation<PieChartOptions> pieAnimation;

    public PieChartOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }
    
    /**
     * The percentage of the chart that is cut out of the middle.
     */
    public PieChartOptions cutoutPercentage(double cutoutPercentage) {
        this.cutoutPercentage = cutoutPercentage;
        return this;
    }
    
    /**
     * Starting angle to draw arcs from
     */
    public PieChartOptions rotation(double rotation) {
        this.rotation = rotation;
        return this;
    }
    
    /**
     * Step into the charts animation configuration
     */
    public PieAnimation<PieChartOptions> animation() {
        if (pieAnimation == null) {
            pieAnimation = new PieAnimation<>(getThis());
        }
        return pieAnimation;
    }
    
    /**
     * Sweep to allow arcs to cover
     */
    public PieChartOptions circumference(double circumference) {
        this.circumference = circumference;
        return this;
    }

    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = super.buildJson();
        JUtils.putNotNull(map, "animation", pieAnimation);
        JUtils.putNotNull(map, "cutoutPercentage", cutoutPercentage);
        JUtils.putNotNull(map, "rotation", rotation);
        JUtils.putNotNull(map, "circumference", circumference);
        return map;
    }

    @Override
    public PieChartOptions getThis() {
        return this;
    }

}
