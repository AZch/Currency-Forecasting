package sample.Data;

import sample.XMLExport.IVisitor;

import java.util.ArrayList;

public interface IData {
    public ArrayList<Double> loadData(String way);
    public String saveData();
    String visit(IVisitor visitor);
    ArrayList<Double> getData();
}
