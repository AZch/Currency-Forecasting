package sample;

import sample.CreateMethods.FactoryCompMethods.CreateApproachMethod;
import sample.CreateMethods.FactoryCompMethods.CreateMomentum;
import sample.CreateMethods.FactoryMethods;
import sample.CreateMethods.FactoryOtherMethods.CreatePurchPowerParity;
import sample.CreateMethods.FactoryOtherMethods.CreateEconomicModel;
import sample.Data.Data;
import sample.Data.IData;
import sample.Methods.Method;
import sample.XMLExport.IVisitor;
import sample.XMLExport.XMLExportVisitor;

public class Facade {
    private IData data;
    private IData startData;
    private Method method;
    private Method startMethod;
    private XMLExportVisitor XMLExport;
    private FactoryMethods factoryMethods;

    public Facade(IData startData) {
        this.startData = startData;
        XMLExport = new XMLExportVisitor();
    }

    // Работа с данными для анализа
    public void loadData(String way) {
        data = new Data();
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

    public void clearData() {
        data = null;
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

    public void setFactoryEconomic() {
        factoryMethods = new CreateEconomicModel();
    }

    // Создание метода анализа
    public void createMethod() {
        if (method == null) {
            if (data != null)
                startMethod = factoryMethods.createMethod(data);
            else
                startMethod = factoryMethods.createMethod(startData);
            method = startMethod;
        } else {
            if (data != null)
                method.setNext(factoryMethods.createMethod(data));
            else
                method.setNext(factoryMethods.createMethod(startData));
            method = method.next();
        }
    }

    public String calcThisMethod() {
        return method.calc();
    }

    public Method getMethod() {
        return method;
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
        if (method == null)
            return "";
        else
            return XMLExport.export(method);
    }

    public String exportData() {
        if (data == null)
            return XMLExport.export(startData);
        else
            return XMLExport.export(data);
    }
}
