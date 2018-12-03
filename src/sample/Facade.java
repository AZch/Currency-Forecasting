package sample;

import sample.CreateMethods.FactoryCompMethods.CreateApproachMethod;
import sample.CreateMethods.FactoryCompMethods.CreateMomentum;
import sample.CreateMethods.FactoryMethods;
import sample.CreateMethods.FactoryOtherMethods.CreatePurchPowerParity;
import sample.CreateMethods.FactoryOtherMethods.CreateEconomicModel;
import sample.Data.IData;
import sample.Methods.Method;
import sample.XMLExport.IVisitor;
import sample.XMLExport.XMLExportVisitor;

public class Facade {
    private IData data;
    private IData startData;
    private Method method;
    private Method startMethod;
    private IVisitor XMLExport;
    private FactoryMethods factoryMethods;

    public Facade(IData startData) {
        this.startData = startData;
        XMLExport = new XMLExportVisitor();
    }

    // Работа с данными для анализа
    public void loadData(String way) {
        try {
            data.loadData(way);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("При загрузке данных произошла ошибка");
        }
    }

    public void saveData() {
        data.saveData();
    }

    // Переход между методами
    public void goStartMethod() {
        method = startMethod;
    }

    public void goNextMethod() {
        method = method.next();
    }

    public void goBackMethod() {
        method = method.back();
    }

    // Задание фабрик по производству методов
    public void setFactoryApproach() {
        factoryMethods = new CreateApproachMethod();
    }

    public void setFactoryMomentum() {
        factoryMethods = new CreateMomentum();
    }

    public void setFactoryPPP() {
        factoryMethods = new CreatePurchPowerParity();
    }

    public void setFactoryTimeSeries() {
        factoryMethods = new CreateEconomicModel();
    }

    // Создание метода анализа
    public void createMethod() {
        if (method == null) {
            startMethod = factoryMethods.createMethod(startData);
            method = startMethod;
        } else {
            method.setNext(factoryMethods.createMethod(startData));
        }
    }

    // на данный момент не нужно, так как подобные действия выполняет предыдущий метод
//    public void setNextMethod(Method method) {
//        if (startMethod == null) {
//            startMethod = method;
//            this.method = method;
//        } else {
//            this.method.setNext(method);
//        }
//    }

    // Экспорт методов и данных
    public String exportMethod() {
        return method.visit(XMLExport);
    }

    public String exportData() {
        return data.visit(XMLExport);
    }
}
