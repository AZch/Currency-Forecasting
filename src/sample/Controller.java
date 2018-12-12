package sample;

import javafx.event.ActionEvent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import sample.Data.Data;
import sample.Data.ProxyData.CorrectData;
import sample.Methods.Method;
import sample.XMLLoad.XMLLoad;

/**
 * Главный контроллер
 *
 * дополнительные методы:
 * 1) отправка сообщения для уведомления о работе окна
 */

public class Controller {
    public Text MsgText;
    public Label ResAnalysis;
    public Label MethodName;
    public SplitMenuButton ChooseMethodAdd;
    public AreaChart<String, Double> GraphicData;
    public TextArea DescMethodText;
    public MenuItem PPP;
    public MenuItem Economic;
    public MenuItem Approach;
    public MenuItem Momentum;

    private WorkWithData workWithData = new WorkWithData();
    private XMLLoad xmlLoad = new XMLLoad();

    private Data data = new Data();
    private Facade facade = new Facade(new CorrectData(workWithData.dataWithLoad(Constants.WAY_START_DATA, data)));
    private MakeGraphics makeGraphic = new MakeGraphics();

    // отправка сообщения для уведомления о работе окна
    private void setMsgText(String whatHappened) {
        if (whatHappened != null)
            MsgText.setText(whatHappened);
    }

    // обновление для метода
    private void updateForMethod() {
        GraphicData.getData().clear();
        MethodName.setText(facade.getMethod().getName());
        DescMethodText.setText(facade.getMethod().getDesc());
    }

    public void addNewMethodAction(ActionEvent actionEvent) {
        facade.createMethod();
        setMsgText(Constants.GOOD_CREATE);
        updateForMethod();
    }

    public void NextMethodAction(ActionEvent actionEvent) {
        facade.goNextMethod();
        updateForMethod();
    }

    public void ChangeMethodAction(ActionEvent actionEvent) {
        facade.goBackMethod();
        updateForMethod();
    }

    public void CalcToBayAction(ActionEvent actionEvent) {
        ResAnalysis.setText(facade.calcThisMethod());
        makeGraphic.makeGraphic(facade.getMethod(), GraphicData);
        setMsgText(Constants.GOOD_CALC);
    }

    public void addDataAction(ActionEvent actionEvent) {
        facade.loadData(workWithData.dataFromFile(Constants.OTHER_FILE_DATA));
        setMsgText(Constants.GOOD_LOAD_DATA);
    }

    public void clearDataAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удаление");
        alert.setTitle("Подтверждение");
        alert.setContentText("Вы точно хотите удлаить данные?");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                facade.clearData();
                setMsgText(Constants.DATA_CLEAR);
            }
        });

    }

    public void ExportDataAction(ActionEvent actionEvent) {
        if (workWithData.writeDataFile(Constants.FILE_TO_EXPORT, facade.exportData(), Constants.IS_APPEND_EXPORT) == Constants.NORNAL_WRITE) {
            setMsgText(Constants.WRITE_FILE);
        } else {
            setMsgText(Constants.ERROR_WRITE_FILE);
        }

    }

    public void ExportMethodAction(ActionEvent actionEvent) {
        if (workWithData.writeDataFile(Constants.FILE_TO_EXPORT, facade.exportMethod(), Constants.IS_APPEND_EXPORT) == Constants.NORNAL_WRITE) {
            setMsgText(Constants.WRITE_FILE);
        } else {
            setMsgText(Constants.ERROR_WRITE_FILE);
        }
    }

    public void DelMethodAction(ActionEvent actionEvent) {
        if (facade.getMethod() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Удаление");
            alert.setTitle("Подтверждение");
            alert.setContentText("Вы точно хотите удлаить метод?");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    setMsgText(facade.delMethod());
                    if (facade.getMethod() != null)
                        updateForMethod();
                    else {
                        GraphicData.getData().clear();
                        MethodName.setText("");
                        DescMethodText.setText("");
                    }
                }
            });
        }
    }

    public void SetPPPAction(ActionEvent actionEvent) {
        facade.setFactoryPPP();
        ChooseMethodAdd.setText(PPP.getText());
    }

    public void SetEconomicModelAction(ActionEvent actionEvent) {
        facade.setFactoryEconomic();
        ChooseMethodAdd.setText(Economic.getText());
    }

    public void SetApproachAction(ActionEvent actionEvent) {
        facade.setFactoryApproach();
        ChooseMethodAdd.setText(Approach.getText());
    }

    public void SetMomentumAction(ActionEvent actionEvent) {
        facade.setFactoryMomentum();
        ChooseMethodAdd.setText(Momentum.getText());
    }

    public void ExitButton(ActionEvent actionEvent) {
        if (facade.getMethod() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Выход");
            alert.setTitle("Выход");
            alert.setContentText("Выход?");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.exit(1);
                }
            });
        } else
            System.exit(1);
    }

    public void LoadXMLMethodAction(ActionEvent actionEvent) {
        setMsgText(facade.loadXMLMethod(workWithData.dataFromFile(Constants.FILE_TO_EXPORT)));
        updateForMethod();

    }

    public void LoadXMLDataAction(ActionEvent actionEvent) {
        setMsgText(facade.loadXMLData(workWithData.dataFromFile(Constants.FILE_TO_EXPORT)));
    }
}
