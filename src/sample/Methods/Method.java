package sample.Methods;

import sample.Data.IData;

import java.util.ArrayList;

public abstract class Method implements IMethod {
    protected IData data;
    protected Method methodNext;
    protected Method methodBack;
    protected ArrayList<Double> graphic = new ArrayList<>();

    public Method(IData data) {
        this.data = data;
    }

    public void setNext(Method methodNext) {
        if (this.methodNext == null) {
            this.methodNext = methodNext;
            setBack(this);
        } else {
            Method bufMethod = methodNext;
            while (bufMethod.next() != null) {
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

    public ArrayList<Double> getGraphic() {
        return graphic;
    }

    public abstract Method next();

    public abstract Method back();
}
