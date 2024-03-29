package sample.Methods;

import sample.Data.IData;

import java.util.ArrayList;

public abstract class Method implements IMethod {
    protected IData data;
    protected Method methodNext;
    protected Method methodBack;
    protected ArrayList<Double> graphicXSeries = new ArrayList<>();
    protected ArrayList<Double> graphicYSeries = new ArrayList<>();
    protected String name;
    protected String desc;

    public Method(IData data, String name, String desc) {
        this.data = data;
        this.name = name;
        this.desc = desc;
    }

    public void setNext(Method methodNext) {
        if (this.methodNext == null) {
            this.methodNext = methodNext;
            setBack(this);
        } else {
            Method bufMethod = methodNext;
            while (bufMethod.next() != bufMethod) {
                bufMethod = bufMethod.next();
            }
            bufMethod.setNext(methodNext);
            bufMethod.setBack(bufMethod);
        }
    }

    public void setBack(Method methodBack) {
        if (methodNext != null)
            methodNext.methodBack = methodBack;
    }

    public void setSimpleNext(Method method) {
        this.methodNext = method;
    }

    public void setSimpleBack(Method method) {
        this.methodBack = method;
    }

    public ArrayList<Double> getGraphicXSeries() {
        return graphicXSeries;
    }

    public ArrayList<Double> getGraphicYSeries() {
        return graphicYSeries;
    }

    protected void clearGraphic() {
        graphicXSeries.clear();
        graphicYSeries.clear();
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public IData getData() {
        return data;
    }

    public abstract Method next();

    public abstract Method back();
}
