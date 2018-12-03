package sample.Methods.OtherMethods;

import sample.Data.IData;
import sample.Methods.Method;
import sample.XMLExport.IVisitor;

import java.util.ArrayList;

/**
 * Построение экономической модели
 * Формат данных (элемент - значение):
 * 1 - Количество параметров
 * 2 .. n - перечисление этих параметров
 */
public class EconomicModel extends Method {
    /**
     * Первый элемент это неумножаемые коэффициенты
     * Второй элемент и т.д. - умножаемые
     */
    private ArrayList<Double> parametrs = new ArrayList<>();

    public EconomicModel(IData data, String name, String desc) {
        super(data, name, desc);

        double countParam = data.getData().get(0);
        data.getData().remove(0);
        while (countParam > 0) {
            countParam--;
            parametrs.add(data.getData().get(0));
            data.getData().remove(0);
        }
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
        String res = "";

        int countOfParametrs = parametrs.size() - 1;

        return res;
    }

    @Override
    public String visit(IVisitor visitor) {
        return visitor.visitEconomicModel(this);
    }

    public ArrayList<Double> getParametrs() {
        return parametrs;
    }
}
