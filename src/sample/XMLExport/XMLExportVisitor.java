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
        //sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        if (method != null)
            sb.append(method.visit(this));
        return sb.toString();
    }

    public String export(IData data) {
        StringBuilder sb = new StringBuilder();
        //sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        if (data != null)
            sb.append(data.visit(this));
        return sb.toString();
    }

    @Override
    public String visitApproachMethod(ApproachMethod method) {
        String res = "<ApproachMethod>" + "\n";

        res += "<name>" + method.getName() + "</name>\n";
        res += "<description>" + method.getDesc() + "</description>\n";

        res += export(method.getData());

        res += "</ApproachMethod>\n";

        return res;
    }

    @Override
    public String visitMomentum(Momentum method) {
        String res = "<Momentum>" + "\n";

        res += "<name>" + method.getName() + "</name>\n";
        res += "<description>" + method.getDesc() + "</description>\n";
        res += "<courseN>" + String.valueOf(method.getCourseN()) + "</courseN>" + "\n";
        res += "<WhatAfterPeriod>" + String.valueOf(method.getWhatAfterPeriod()) + "</WhatAfterPeriod>" + "\n";

        res += export(method.getData());

        res += "</Momentum>\n";

        return res;
    }

    @Override
    public String visitPurchPowerParity(PurchPowerParity method) {
        String res = "<PurchPowerParity>" + "\n";

        res += "<name>" + method.getName() + "</name>\n";
        res += "<description>" + method.getDesc() + "</description>\n";
        res += "<WhatAfterPeriod>" + String.valueOf(method.getWhatAfterPeriod()) + "</WhatAfterPeriod>" + "\n";
        res += "<StartRates>" + String.valueOf(method.getStartRates()) + "</StartRates>" + "\n";


        res += export(method.getData());

        res += "</PurchPowerParity>\n";

        return res;
    }

    @Override
    public String visitEconomicModel(EconomicModel method) {
        String res = "<EconomicModel>" + "\n";

        res += "<name>" + method.getName() + "</name>\n";
        res += "<description>" + method.getDesc() + "</description>\n";
        for (Double num : method.getParametrs())
            res += "<parametrs>" + String.valueOf(num) + "</parametrs>" + "\n";

        res += export(method.getData());

        res += "</EconomicModel>\n";

        return res;
    }

    @Override
    public String visitData(Data data) {
        String res = "<Data>" + "\n";

        for (Double num : data.getData())
            res += "<num>" + String.valueOf(num) + "</num>" + "\n";

        res += "</Data>\n";

        return res;
    }

    @Override
    public String visitCorrectData(CorrectData correctData) {
        String res = "<CorrectData>" + "\n";

        for (Double num : correctData.getData())
            res += "<num>" + String.valueOf(num) + "</num>" + "\n";

        res += "</CorrectData>\n";

        return res;
    }
}
