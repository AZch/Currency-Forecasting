package sample.Data.ProxyData;

import sample.Data.Data;
import sample.Data.IData;
import sample.XMLExport.IVisitor;

import java.util.ArrayList;

public class CorrectData implements IData {
    private Data data;

    public CorrectData(Data data) {
        this.data = data;
    }

    @Override
    public ArrayList<Double> loadData(String way) {
        if (way != null)
            return data.loadData(way);
        else
            return null;
    }

    @Override
    public String saveData() {
        return data.saveData();
    }

    @Override
    public String visit(IVisitor visitor) {
        return visitor.visitCorrectData(this);
    }


    @Override
    public ArrayList<Double> getData() {
        return data.getData();
    }
}
