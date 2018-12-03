package sample.Methods.CompMethods;

import sample.Data.IData;
import sample.Methods.Method;
import sample.XMLExport.IVisitor;

public class Momentum extends Method {
    public Momentum(IData data, String name, String desc) {
        super(data, name, desc);
    }

    @Override
    public Method next() {
        if (methodNext != null)
            return methodNext;
        else {
            System.out.println("Следующего метода не обнаружено");
            return this;
        }
    }

    @Override
    public Method back() {
        if (methodBack != null)
            return methodBack;
        else {
            System.out.println("Предыдущего метода не обнаружено");
            return this;
        }
    }

    @Override
    public String calc() {
        return null;
    }

    @Override
    public String visit(IVisitor visitor) {
        return visitor.visitMomentum(this);
    }
}
