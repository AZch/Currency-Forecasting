package sample;

import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.text.Text;
import sample.Data.Data;
import sample.Data.ProxyData.CorrectData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    public Text MsgText;
    public Text DescMethodText;
    public Label ResAnalysis;
    public Label MethodName;
    public SplitMenuButton ChooseMethodAdd;
    public LineChart GraphicData;

    private Data data = new Data();
    private Facade facade = new Facade(new CorrectData(dataWithLoad(Constants.WAY_START_DATA, data)));

    //
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

    public void addNewMethodAction(ActionEvent actionEvent) {
        facade.createMethod();
    }

    public void NextMethodAction(ActionEvent actionEvent) {
        facade.goNextMethod();
    }

    public void ChangeMethodAction(ActionEvent actionEvent) {

    }

    public void CalcToBayAction(ActionEvent actionEvent) {
        ResAnalysis.setText(facade.calcThisMethod());
    }

    public void addDataAction(ActionEvent actionEvent) {
        facade.loadData(dataFromFile(Constants.OTHER_FILE_DATA));
    }

    public void clearDataAction(ActionEvent actionEvent) {
        facade.clearData();
    }

    public void ExportDataAction(ActionEvent actionEvent) {
        facade.exportData();
    }

    public void ExportMethodAction(ActionEvent actionEvent) {
        facade.exportMethod();
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
