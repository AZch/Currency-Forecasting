package sample.XMLExport;

import com.sun.xml.internal.bind.v2.model.core.ID;
import sample.Data.Data;
import sample.Data.IData;
import sample.Data.ProxyData.CorrectData;
import sample.Methods.CompMethods.ApproachMethod;
import sample.Methods.CompMethods.Momentum;
import sample.Methods.Method;
import sample.Methods.OtherMethods.EconomicModel;
import sample.Methods.OtherMethods.PurchPowerParity;

public class XMLExportVisitor implements IVisitor {

    public String export(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        sb.append(method.visit(this));
        return sb.toString();
    }

    public String export(IData data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        sb.append(data.visit(this));
        return sb.toString();
    }

    @Override
    public String visitApproachMethod(ApproachMethod method) {
        return null;
    }

    @Override
    public String visitMomentum(Momentum method) {
        return null;
    }

    @Override
    public String visitPurchPowerParity(PurchPowerParity method) {
        String res = "<PurchPowerParity>" + "\n";

        res += "<WhatAfterPeriod>" + String.valueOf(method.getWhatAfterPeriod()) + "</WhatAfterPeriod>" + "\n";
        res += "<StartRates>" + String.valueOf(method.getStartRates()) + "</StartRates>" + "\n";

        res += "</PurchPowerParity>";

        return res;
    }

    @Override
    public String visitEconomicModel(EconomicModel method) {
        String res = "<EconomicModel>" + "\n";

        for (Double num : method.getParametrs())
            res += "<parametrs>" + String.valueOf(num) + "</parametrs>" + "\n";

        res += "</EconomicModel>";

        return res;
    }

    @Override
    public String visitData(Data data) {
        String res = "<Data>" + "\n";

        for (Double num : data.getData())
            res += "<num>" + String.valueOf(num) + "</num>" + "\n";

        res += "</Data>";

        return res;
    }

    @Override
    public String visitCorrectData(CorrectData correctData) {
        String res = "<CorrectData>" + "\n";

        for (Double num : correctData.getData())
            res += "<num>" + String.valueOf(num) + "</num>" + "\n";

        res += "</CorrectData>";

        return res;
    }
}
