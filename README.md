# Vaadin Chart.js [![Bintray](https://img.shields.io/bintray/v/moberwasserlechner/maven/vaadin-chartjs.svg)](https://bintray.com/moberwasserlechner/maven/vaadin-chartjs/_latestVersion) [![PayPal](https://img.shields.io/badge/%24-donate-0CB3EB.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=N8VS2P9233NJQ) [![License](https://img.shields.io/badge/license-MIT-B34ED4.svg)](https://github.com/moberwasserlechner/vaadin-chartjs/blob/master/LICENSE)

Vaadin 7 wrapper for the Chart.js charting library. https://github.com/chartjs/Chart.js

## Features

* Fluent api to configure the charts
* Supported chart types are
 * Horizontal bar chart
 * Vertical bar chart
 * Line chart
 * Donut chart
 * Pie chart
 * Polar area chart
 * Bubble chart
 * Radar chart
 * Scatter line chart
* Data point click listener

## Installation

### Download

[![Bintray](https://img.shields.io/bintray/v/moberwasserlechner/maven/vaadin-chartjs.svg)](https://bintray.com/moberwasserlechner/maven/vaadin-chartjs/_latestVersion)

### Vaadin Directory

Get the addon from 
https://vaadin.com/directory#!addon/chartjs-add-on.

You can download the addon there as well, but you will need to create a free vaadin account first. For Maven style dependencies please use below settings.

### Maven

Repository

    <repositories>
      <!-- ... other repository elements ... -->
      <repository>
        <snapshots>
          <enabled>false</enabled>
        </snapshots>
        <id>central</id>
        <name>bintray</name>
        <url>http://jcenter.bintray.com</url>
      </repository>
    </repositories>
    
Dependency

    <dependencies>
      <!-- ... other dependency elements ... -->
      <dependency>
        <groupId>com.byteowls</groupId>
        <artifactId>vaadin-chartjs</artifactId>
        <version>0.2.0</version>
      </dependency>
    </dependencies>


### Gradle

Repository

    repositories {
      jcenter()
    }
    // or 
    repositories {
      maven {
        url  "http://jcenter.bintray.com" 
      }
    }
     
Dependency

    dependencies {
      compile ("com.byteowls:vaadin-chartjs:0.2.0")
    }
## Usage

The basic usage is always the same. You need to create a new ChartJs() and configure it with a chart type specific config.

For more examples please see the demo app at http://moberwasserlechner.jelastic.servint.net/vaadin-chartjs/

```
        ChartJs myChart = new ChartJs(barConfig);
        // enable logging to the javascript console. You can see some interessenting things there ;). Please do not use this in production because it's only needed for debugging.
        myChart.setJsLoggingEnabled(true);
        myChart.setWidth(50, Unit.PERCENTAGE);
        // add a data point clicklistener
        myChart.addClickListener((datasetIdx, dataIdx) -> {
            BarDataset dataset = (BarDataset) barConfig.data().getDatasets().get(datasetIdx);
            Notification.show("BarDataset at idx:" + datasetIdx + "; Data: idx=" + dataIdx + "; Value=" + dataset.getData().get(dataIdx), Type.WARNING_MESSAGE);
        });
```

### Bar chart configuration

In this example we configure a horizontal bar chart with 3 dataset and add some random numbers to each of them.

```java
        
        BarChartConfig barConfig = new BarChartConfig();
        barConfig.horizontal();
        barConfig.
            data()
                .labels("January", "February", "March", "April", "May", "June", "July")
                .addDataset(new BarDataset().backgroundColor("rgba(220,220,220,0.5)").label("Dataset 1"))
                .addDataset(new BarDataset().backgroundColor("rgba(151,187,205,0.5)").label("Dataset 2").hidden(true))
                .addDataset(new BarDataset().backgroundColor("rgba(151,187,205,0.5)").label("Dataset 3"))
                .and()
            .options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Chart.js Horizontal Bar Chart")
                    .and()
                 .elements()
                     .rectangle()
                         .borderWidth(2)
                         .borderColor("rgb(0, 255, 0)")
                         .borderSkipped(RectangleEdge.LEFT)
                         .and()
                     .and()
                 .legend()
                     .fullWidth(false)
                     .position(Position.LEFT)
                     .and()
               .done();
            
            // add random data
            List<String> labels = barConfig.data().getLabels();
            for (Dataset<?> ds : barConfig.data().getDatasets()) {
                BarDataset lds = (BarDataset) ds;
                List<Double> data = new ArrayList<>();
                for (int i = 0; i < labels.size(); i++) {
                    data.add((double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100));
                }
                lds.dataAsList(data);
            }
```

### Chart Options

Please have a look at the great documentation at ChartJs. (http://www.chartjs.org/docs)

You will see that every fluent api method under `config.options()` has a counterpart in the javascript json config.  

## Prerequisite

### Addon
* JDK 7 or higher
* Vaadin 7.4 or higher

### Demo
* JDK 8
* Vaadin 7.7.0

## Usage


## Missing something?

The Vaadin-Chartjs is only a wrapper. So if you have any feature requests or found any bugs in the javascript lib please use Chart.js's issue tracker https://github.com/chartjs/Chart.js/issues

In all other cases please create a issue at https://github.com/moberwasserlechner/vaadin-chartjs/issues or contribute to the project yourself. For contribution see the next section.

## Contribute

1. Fork it
2. Create your feature branch (`git checkout -b my-feature-or-bug`)
3. Test your changes to the best of your ability.
5. Commit your changes (`git commit -m 'Describe feature or bug'`)
6. Push to the branch (`git push origin my-feature-or-bug`)
7. Create new Pull Request


### Eclipse

1. Build eclipse project configs for addon and demo with `./gradlew cleanEclipse eclipse`
2. In Eclipse open File->Import... and choose General->Existing Projects into Workspace for the root folder

### Code Style

Please use the sun coding convention. Please do not use tabs at all!

## Demo

### Chart.js

Afaik there are no online examples yet but you can download them along with the release distribution

* https://github.com/chartjs/Chart.js/releases/latest

### Vaadin Chart.js

**Run it yourself**

1. Clone the repository
2. Build eclipse project configs for addon and demo with `./gradlew cleanEclipse eclipse`
3. In Eclipse open File->Import... and choose General->Existing Projects into Workspace for the root folder
4. Create a run or debug configuration as a Java Application and use this "com.byteowls.vaadin.chartjs.demo.ChartJsDemoApplication" main class
3. It starts at `http://localhost:8080/`

**Live Demo**

http://moberwasserlechner.jelastic.servint.net/vaadin-chartjs/

## License

MIT. Please see [LICENSE](https://github.com/moberwasserlechner/vaadin-chartjs/blob/master/LICENSE).

## Change Log

Please see [CHANGELOG](https://github.com/moberwasserlechner/vaadin-chartjs/blob/master/CHANGELOG.md).