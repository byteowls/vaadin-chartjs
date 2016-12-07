package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.data.Data;
import com.byteowls.vaadin.chartjs.options.types.PieChartOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Pie and doughnut charts are probably the most commonly used chart there are. 
 * They are divided into segments, the arc of each segment shows the proportional value of each piece of data.
 * 
 * They are excellent at showing the relational proportions between data.
 * 
 * Pie and doughnut charts are effectively the same class in Chart.js, but have one different default value - their cutoutPercentage. This equates what percentage of the inner should be cut out. This defaults to 0 for pie charts, and 50 for doughnuts.
 * 
 * They are also registered under two aliases in the Chart core. Other than their different default value, and different alias, they are exactly the same.
 *
 * Often, it is used to show trend data, and the comparison of two data sets.
 *
 * @author michael@byteowls.com
 */
public class DonutChartConfig implements ChartConfig {

    private Data<DonutChartConfig> data;
    private PieChartOptions options;

    public Data<DonutChartConfig> data() {
        if (this.data == null) {
            this.data = new Data<>(this);
        }
        return this.data;
    }

    public PieChartOptions options() {
        if (options == null) {
            options = new PieChartOptions(this);
        }
        return options;
    }
    
    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = new HashMap();
        JUtils.putNotNull(map, "type", "doughnut");
        // data
        if (data != null) {
            JUtils.putNotNull(map, "data", data.buildJson());
        }
        // options
        if (options != null) {
            JUtils.putNotNull(map, "options", options.buildJson());
        }
        return map;
    }
}
