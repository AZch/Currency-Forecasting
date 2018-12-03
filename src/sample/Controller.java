package sample;

import javafx.event.ActionEvent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import sample.Data.Data;
import sample.Data.ProxyData.CorrectData;
import sample.Methods.Method;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Главный контроллер
 *
 * дополнительные методы:
 * 1) загрузка данных из файла в данные
 * 2) загрузка данных из фалйа в строку
 * 3) рисование графиков по текущему методу фасада
 * 4) отправка сообщения для уведомления о работе окна
 */

public class Controller {
    public Text MsgText;
    public Label ResAnalysis;
    public Label MethodName;
    public SplitMenuButton ChooseMethodAdd;
    public AreaChart<String, Double> GraphicData;
    public TextArea DescMethodText;

    private Data data = new Data();
    private Facade facade = new Facade(new CorrectData(dataWithLoad(Constants.WAY_START_DATA, data)));

    // загрузка данных из файла в данные
    private Data dataWithLoad(String way, Data data) {
        try (FileReader reader = new FileReader(way)) {
            String resRead = "";
            int symbol;
            while ((symbol = reader.read()) != -1)
                resRead += (char) symbol;
            data.loadData(resRead);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    // загрузка данных из файла в строку
    private String dataFromFile(String way) {
        String resRead = "";
        try (FileReader reader = new FileReader(way)) {
            int symbol;
            while ((symbol = reader.read()) != -1)
                resRead += (char) symbol;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resRead;
    }

    // рисование графиков по текущему методу фасада
    private void makeGraphic(Method method) {
        XYChart.Series<String, Double> seriesGraph = new XYChart.Series<>();
        GraphicData.getData().clear();
        GraphicData.getData().add(seriesGraph);
        GraphicData.setCreateSymbols(false);
        for (int i = 0; i < method.getGraphicXSeries().size(); i++) {
            if (method.getGraphicYSeries().size() > i) {
                seriesGraph.getData().add(new XYChart.Data<String, Double>(String.valueOf(method.getGraphicXSeries().get(i)), method.getGraphicYSeries().get(i)));
            }
        }
    }

    // отправка сообщения для уведомления о работе окна
    private void setMsgText(String whatHappened) {
        if (whatHappened != null)
            MsgText.setText(whatHappened);
    }

    public void addNewMethodAction(ActionEvent actionEvent) {
        facade.createMethod();
        MethodName.setText(facade.getMethod().getName());
        DescMethodText.setText(facade.getMethod().getDesc());
        setMsgText(Constants.GOOD_CREATE);
    }

    public void NextMethodAction(ActionEvent actionEvent) {
        facade.goNextMethod();
        MethodName.setText(facade.getMethod().getName());
        DescMethodText.setText(facade.getMethod().getDesc());
    }

    public void ChangeMethodAction(ActionEvent actionEvent) {
        facade.goBackMethod();
        MethodName.setText(facade.getMethod().getName());
        DescMethodText.setText(facade.getMethod().getDesc());
    }

    public void CalcToBayAction(ActionEvent actionEvent) {
        ResAnalysis.setText(facade.calcThisMethod());
        makeGraphic(facade.getMethod());
        setMsgText(Constants.GOOD_CALC);
    }

    public void addDataAction(ActionEvent actionEvent) {
        facade.loadData(dataFromFile(Constants.OTHER_FILE_DATA));
        setMsgText(Constants.GOOD_LOAD_DATA);
    }

    public void clearDataAction(ActionEvent actionEvent) {
        facade.clearData();
        setMsgText(Constants.DATA_CLEAR);
    }

    public void ExportDataAction(ActionEvent actionEvent) {
        facade.exportData();
        setMsgText(Constants.EXPORT_DATA);
    }

    public void ExportMethodAction(ActionEvent actionEvent) {
        facade.exportMethod();
        setMsgText(Constants.EXPORT_METHOD);
    }

    public void EditMethodAction(ActionEvent actionEvent) {
    }

    public void DelMethodAction(ActionEvent actionEvent) {
    }

    public void SetPPPAction(ActionEvent actionEvent) {
        facade.setFactoryPPP();
    }

    public void SetEconomicModelAction(ActionEvent actionEvent) {
        facade.setFactoryEconomic();
    }

    public void SetApproachAction(ActionEvent actionEvent) {
        facade.setFactoryApproach();
    }

    public void SetMomentumAction(ActionEvent actionEvent) {
        facade.setFactoryMomentum();
    }
}
