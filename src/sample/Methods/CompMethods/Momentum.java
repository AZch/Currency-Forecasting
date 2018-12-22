package sample.Methods.CompMethods;

import sample.Constants;
import sample.Data.IData;
import sample.Methods.Method;
import sample.XMLExport.IVisitor;

public class Momentum extends Method {
    private double courseN; // курс закрытия n дней назад
    private double whatAfterPeriod; // через сколько необходимо производить закупку

    public Momentum(IData data, String name, String desc) {
        super(data.clone(), name, desc);
        this.data = data.clone();
        courseN = this.data.getData().get(0);
        this.data.remove(0);
        whatAfterPeriod = this.data.getData().get(0);
        this.data.remove(0);
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
        String resultCalc = "";

        double periodStart = 0;

        clearGraphic();

        double momentum = 0;
        for (int i = 0; i < data.getData().size(); i++) {
            graphicXSeries.add(periodStart++);
            momentum = data.getData().get(i) - courseN;
            graphicYSeries.add(momentum);
            if (periodStart == whatAfterPeriod) {
                if (momentum > 0 && momentum > momentum + momentum * Constants.commission)
                    resultCalc = Constants.bay_res;
                else if (momentum > 0)
                    resultCalc = Constants.dont_know_bay_res;
                else
                    resultCalc = Constants.dont_bay_res;
            }
        }

        return resultCalc;
    }

    @Override
    public String visit(IVisitor visitor) {
        return visitor.visitMomentum(this);
    }

    public double getCourseN() {
        return courseN;
    }

    public double getWhatAfterPeriod() {
        return whatAfterPeriod;
    }
}
