package sample.XMLExport;

import com.sun.xml.internal.bind.v2.model.core.ID;
import sample.Constants;
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
        String res = "<" + Constants.NAME_XML_APPROACH + ">" + "\n";

        res += "<" + Constants.NAME + ">" + method.getName() + "</" + Constants.NAME + ">\n";
        res += "<" + Constants.DESC + ">" + method.getDesc() + "</" + Constants.DESC + ">\n";

        res += export(method.getData());

        res += "</" + Constants.NAME_XML_APPROACH + ">\n";

        return res;
    }

    @Override
    public String visitMomentum(Momentum method) {
        String res = "<" + Constants.NAME_XML_MOMENTUM  + ">" + "\n";

        res += "<" + Constants.NAME + ">" + method.getName() + "</" + Constants.NAME + ">\n";
        res += "<" + Constants.DESC + ">" + method.getDesc() + "</" + Constants.DESC + ">\n";
        res += "<" + Constants.COURSE_N + ">" + String.valueOf(method.getCourseN()) + "</" + Constants.COURSE_N + ">" + "\n";
        res += "<" + Constants.WHAT_AFTER_PERIOD + ">" + String.valueOf(method.getWhatAfterPeriod()) + "</" + Constants.WHAT_AFTER_PERIOD + ">" + "\n";

        res += export(method.getData());

        res += "</" + Constants.NAME_XML_MOMENTUM  + ">\n";

        return res;
    }

    @Override
    public String visitPurchPowerParity(PurchPowerParity method) {
        String res = "<" + Constants.NAME_XML_PPP + ">" + "\n";

        res += "<" + Constants.NAME + ">" + method.getName() + "</" + Constants.NAME + ">\n";
        res += "<" + Constants.DESC + ">" + method.getDesc() + "</" + Constants.DESC + ">\n";
        res += "<" + Constants.RATES + ">" + String.valueOf(method.getStartRates()) + "</" + Constants.RATES + ">" + "\n";
        res += "<" + Constants.WHAT_AFTER_PERIOD + ">" + String.valueOf(method.getWhatAfterPeriod()) + "</" + Constants.WHAT_AFTER_PERIOD + ">" + "\n";


        res += export(method.getData());

        res += "</" + Constants.NAME_XML_PPP + ">\n";

        return res;
    }

    @Override
    public String visitEconomicModel(EconomicModel method) {
        String res = "<" + Constants.NAME_XML_ECONOMIC + ">" + "\n";

        res += "<" + Constants.DESC + ">" + method.getName() + "</" + Constants.DESC + ">\n";
        res += "<" + Constants.DESC + ">" + method.getDesc() + "</" + Constants.DESC + ">\n";
        for (Double num : method.getParametrs())
            res += "<" + Constants.PARAMETRS + ">" + String.valueOf(num) + "</" + Constants.PARAMETRS + ">" + "\n";

        res += export(method.getData());

        res += "</" + Constants.NAME_XML_ECONOMIC + ">\n";

        return res;
    }

    @Override
    public String visitData(Data data) {
        String res = "<" + Constants.DATA_CLASS + ">" + "\n";

        for (Double num : data.getData())
            res += "<" + Constants.NUM_DATA + ">" + String.valueOf(num) + "</" + Constants.NUM_DATA + ">" + "\n";

        res += "</" + Constants.DATA_CLASS + ">\n";

        return res;
    }

    @Override
    public String visitCorrectData(CorrectData correctData) {
        String res = "<" + Constants.CORRECT_DATA_CLASS + ">" + "\n";

        for (Double num : correctData.getData())
            res += "<" + Constants.NUM_DATA + ">" + String.valueOf(num) + "</" + Constants.NUM_DATA + ">" + "\n";

        res += "</" + Constants.CORRECT_DATA_CLASS + ">\n";

        return res;
    }
}
