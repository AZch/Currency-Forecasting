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
import sample.XMLLoad.XMLLoad;

public class Facade {
    private IData data;
    private IData startData;
    private Method method;
    private Method startMethod;
    private XMLExportVisitor XMLExport;
    private FactoryMethods factoryMethods;

    private XMLLoad xmlLoad;

    public Facade(IData startData) {
        this.startData = startData;
        XMLExport = new XMLExportVisitor();
        xmlLoad = new XMLLoad();
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

    public String loadXMLData(String dataXML) {
        IData newData = xmlLoad.LoadData(dataXML);
        if (newData != null)
            data = newData;
        else
            return Constants.ERROR_LOAD_XML;
        return Constants.COMPLETE_XML_LOAD;
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

    // Создание метода анализа
    public String loadXMLMethod(String dataXML) {
        Method newMethod = xmlLoad.LoadMethod(dataXML);
        if (newMethod == null)
            return Constants.ERROR_LOAD_XML;

        if (method == null) {
            startMethod = newMethod;
            method = startMethod;
        } else {
            method.setNext(newMethod);
            method = method.next();
        }
        return Constants.COMPLETE_XML_LOAD;
    }

    public String calcThisMethod() {
        return method.calc();
    }

    public Method getMethod() {
        return method;
    }

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

    public String delMethod() {
        if (method == null) {
            return Constants.ERROR_DELETE;
        }

        boolean isStartMethod = false;
        if (method == startMethod)
            isStartMethod = true;

        if (method.back() != method && method.next() != method) {
            method.next().setSimpleBack(method.back());
            method.back().setSimpleNext(method.next());
            method = method.back();
        } else if (method.back() != method) {
            method.back().setSimpleNext(null);
            method = method.back();
        } else if (method.next() != method) {
            method.next().setSimpleBack(null);
            method = method.next();
        } else
            method = null;

        if (isStartMethod)
            startMethod = method;
        return Constants.COMPLETE_DELETE;
    }
}
