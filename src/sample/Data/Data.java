package sample.Data;

import sample.XMLExport.IVisitor;

import java.util.ArrayList;

public class Data implements IData {
    private ArrayList<Double> data = new ArrayList();

    @Override
    public ArrayList<Double> loadData(String way) {
        String[] oneNum = way.split(" ");
        try {
            for (int i = 0; i < oneNum.length; i++) {
                data.add(Double.parseDouble(oneNum[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Проблема с парсингом чисел");
        }
        return null;
    }

    @Override
    public String saveData() {
        String retData = "";
        for (double num : data) {
            retData += String.valueOf(num) + " ";
        }
        return retData;
    }

    @Override
    public String visit(IVisitor visitor) {
        return visitor.visitData(this);
    }

    @Override
    public ArrayList<Double> getData() {
        return data;
    }
}
