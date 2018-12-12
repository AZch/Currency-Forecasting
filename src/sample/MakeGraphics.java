package sample;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import sample.Methods.Method;

public class MakeGraphics {
    // рисование графиков по текущему методу фасада
    public void makeGraphic(Method method, AreaChart<String, Double> GraphicData) {
        XYChart.Series<String, Double> seriesGraphNormal = new XYChart.Series<>();
        XYChart.Series<String, Double> seriesGraphGood = new XYChart.Series<>();
        XYChart.Series<String, Double> seriesGraphBad = new XYChart.Series<>();
        XYChart.Series<String, Double> seriesGraph = new XYChart.Series<>();

        XYChart.Series<String, Double> seriesMax = new XYChart.Series<>();
        XYChart.Series<String, Double> seriesMin = new XYChart.Series<>();

        GraphicData.getData().clear();
        GraphicData.getData().add(seriesGraph);
        GraphicData.getData().add(seriesGraphNormal);
        GraphicData.getData().add(seriesGraphGood);
        GraphicData.getData().add(seriesGraphBad);

        GraphicData.getData().add(seriesMax);
        GraphicData.getData().add(seriesMin);

        GraphicData.setCreateSymbols(false);
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        int indexMin = 0, indexMax = 0;
        for (int i = 0; i < method.getGraphicXSeries().size(); i++) {
            if (method.getGraphicYSeries().size() > i) {
                seriesGraph.getData().add(new XYChart.Data<String, Double>(String.valueOf(method.getGraphicXSeries().get(i)), method.getGraphicYSeries().get(i)));
                if (method.getGraphicYSeries().get(i) < 0)
                    seriesGraphBad.getData().add(new XYChart.Data<String, Double>(String.valueOf(method.getGraphicXSeries().get(i)), method.getGraphicYSeries().get(i)));
                else {
                    if ((method.getGraphicYSeries().get(i) - (method.getGraphicYSeries().get(i) * Constants.commission)) - method.getGraphicYSeries().get(0) > 0)
                        seriesGraphGood.getData().add(new XYChart.Data<String, Double>(String.valueOf(method.getGraphicXSeries().get(i)), method.getGraphicYSeries().get(i)));
                    else
                        seriesGraphNormal.getData().add(new XYChart.Data<String, Double>(String.valueOf(method.getGraphicXSeries().get(i)), method.getGraphicYSeries().get(i)));
                }
            }
            if (min > method.getGraphicYSeries().get(i)) {
                min = method.getGraphicYSeries().get(i);
                indexMin = i;
            }
            if (max < method.getGraphicYSeries().get(i)) {
                max = method.getGraphicYSeries().get(i);
                indexMax = i;
            }
        }
        seriesMax.getData().add(new XYChart.Data<String, Double>(String.valueOf(method.getGraphicXSeries().get(indexMax)), max));
        seriesMin.getData().add(new XYChart.Data<String, Double>(String.valueOf(method.getGraphicXSeries().get(indexMin)), min));
    }
}
