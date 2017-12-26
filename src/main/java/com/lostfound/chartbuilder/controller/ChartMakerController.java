package com.lostfound.chartbuilder.controller;

import com.lostfound.chartbuilder.model.DataModel;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ChartMakerController {

    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);

    @FXML
    private VBox chartBox;
    @FXML
    private TextField x0;
    @FXML
    private TextField y0;
    @FXML
    private TextField x1;
    @FXML
    private TextField y1;

    @FXML
    public void initialize() {
        chartBox.getChildren().add(chart);

        x0.setOnKeyReleased(event -> buildChart());
        y0.setOnKeyReleased(event -> buildChart());
        x1.setOnKeyReleased(event -> buildChart());
        y1.setOnKeyReleased(event -> buildChart());
    }

    public void buildChart() {
        chart.getData().clear();
        try {
            DataModel dataModel = getInputData();
            chart.getData().add(buildFirstSeries(dataModel));
            chart.getData().add(buildSecondSeries(dataModel));
        } catch (NumberFormatException e) {
            // ignore
        }
    }

    private Series<Number, Number> buildFirstSeries(DataModel dataModel) {
        Series<Number, Number> series = new Series<>();
        series.setName("Line 1");

        series.getData().add(new Data<>(dataModel.getX0(), dataModel.getY0()));
        series.getData().add(new Data<>(dataModel.getX1(), dataModel.getY1()));

        return series;
    }

    private Series<Number, Number> buildSecondSeries(DataModel dataModel) {
        Series<Number, Number> series = new Series<>();
        series.setName("Line 2");

        series.getData().add(new Data<>(dataModel.getX1() + 10, dataModel.getY1()));
        series.getData().add(new Data<>(dataModel.getX0() + 10, dataModel.getY0()));

        return series;
    }

    private DataModel getInputData() {
        return new DataModel(getDoubleValue(x0), getDoubleValue(y0), getDoubleValue(x1), getDoubleValue(y1));
    }

    private Double getDoubleValue(TextField textField) {
        return Double.parseDouble(textField.getText());
    }
}

