package sample.Methods.OtherMethods;

import sample.Constants;
import sample.Data.IData;
import sample.Methods.Method;
import sample.XMLExport.IVisitor;

/**
 * Паритет покупательной способности
 * Формат данных (элемент - значение):
 * 1 - стартовый курс
 * 2 - через какое время произойдет закупка
 * 3 - период
 * 4 - инфляция за первой период  страны
 * 5 - инфляция за второй период  страны
 * ...
 */
public class PurchPowerParity extends Method {
    private double whatAfterPeriod = 0;
    private double startRates = 0;

    public PurchPowerParity(IData data, String nameMethod, String descMethod) {
        super(data, nameMethod, descMethod);

        startRates = data.getData().get(0);
        data.getData().remove(0);
        whatAfterPeriod = data.getData().get(0);
        data.getData().remove(0);
    }

    @Override
    public Method next() {
        if (methodNext != null)
            return methodNext;
        else {
            System.out.println("Следующего метода не обнаружено");
            return null;
        }
    }

    @Override
    public Method back() {
        if (methodBack != null)
            return methodBack;
        else {
            System.out.println("Предыдущего метода не обнаружено");
            return null;
        }
    }

    @Override
    public String calc() {
        String resultCalc = "";

        double periodStart = 0;
        double rates = startRates;

        clearGraphic();
        for (int i = 0; i < data.getData().size() && i + 1 < data.getData().size(); i++) {
            graphicXSeries.add(periodStart);
            graphicYSeries.add(rates);
            rates = (1 + (data.getData().get(i) - data.getData().get(i + 1)) / 100) * rates;
            periodStart++;
            if (periodStart == whatAfterPeriod) {
                if (rates > startRates + startRates * Constants.commission)
                    resultCalc = Constants.bay_res;
                else if (rates > startRates)
                    resultCalc = Constants.dont_know_bay_res;
                else
                    resultCalc = Constants.dont_bay_res;
            }
        }

        return resultCalc;
    }

    @Override
    public String visit(IVisitor visitor) {
        return visitor.visitPurchPowerParity(this);
    }

    public double getWhatAfterPeriod() {
        return whatAfterPeriod;
    }

    public double getStartRates() {
        return startRates;
    }
}
