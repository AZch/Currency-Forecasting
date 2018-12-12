package sample.XMLLoad;

import sample.Constants;
import sample.Data.Data;
import sample.Data.IData;
import sample.Data.ProxyData.CorrectData;
import sample.Methods.CompMethods.ApproachMethod;
import sample.Methods.CompMethods.Momentum;
import sample.Methods.Method;
import sample.Methods.OtherMethods.EconomicModel;
import sample.Methods.OtherMethods.PurchPowerParity;
import sample.WorkWithData;

public class XMLLoad {
    public Method LoadMethod(String dataXML) {
        String[] dataSplit = dataXML.split("<|>|\n");
        for (int i = 0; i < dataSplit.length; i++) {
            switch (dataSplit[i]) {
                case Constants.NAME_XML_APPROACH:
                    return LoadApproach(dataSplit, i);
                case Constants.NAME_XML_ECONOMIC:
                    return LoadEconomic(dataSplit, i);
                case Constants.NAME_XML_MOMENTUM:
                    return LoadMomentum(dataSplit, i);
                case Constants.NAME_XML_PPP:
                    return LoadPPP(dataSplit, i);
                default:
                    break;
            }
        }
        return null;
    }

    public IData LoadData(String dataXML) {
        String[] dataSplit = dataXML.split("<|>|\n");
        for (int i = 0; i < dataSplit.length; i++) {
            switch (dataSplit[i]) {
                case Constants.DATA_CLASS:
                    return LoadSimpleData(dataSplit, i);
                case Constants.CORRECT_DATA_CLASS:
                    return LoadCorrectData(dataSplit, i);
                default:
                    break;
            }
        }
        return null;
    }

    private ApproachMethod LoadApproach (String[] dataSplit, int idStart) {
        String name = "", desc = "";
        Data data = new Data();
        for (int i = idStart + 1; !dataSplit[i].equals("/" + Constants.NAME_XML_APPROACH); i++) {
            switch (dataSplit[i]) {
                case Constants.NAME:
                    name = dataSplit[i + 1];
                    break;
                case Constants.DESC:
                    while (!dataSplit[i + 1].equals("/" + Constants.DESC)) {
                        desc += dataSplit[i + 1] + "\n";
                        i++;
                    }
                    break;
                case Constants.NUM_DATA:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                default:
                    break;
            }
        }
        return new ApproachMethod(new CorrectData(data), name, desc);
    }

    private EconomicModel LoadEconomic (String[] dataSplit, int idStart) {
        String name = "", desc = "";
        Data data = new Data();
        for (int i = idStart + 1; !dataSplit[i].equals("/" + Constants.NAME_XML_ECONOMIC); i++) {
            switch (dataSplit[i]) {
                case Constants.NAME:
                    name = dataSplit[i + 1];
                    break;
                case Constants.DESC:
                    while (!dataSplit[i + 1].equals("/" + Constants.DESC)) {
                        desc += dataSplit[i + 1] + "\n";
                        i++;
                    }
                    break;
                case Constants.PARAMETRS:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                case Constants.NUM_DATA:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                default:
                    break;
            }
        }
        return new EconomicModel(new CorrectData(data), name, desc);
    }

    private Momentum LoadMomentum (String[] dataSplit, int idStart) {
        String name = "", desc = "";
        Data data = new Data();
        for (int i = idStart + 1; !dataSplit[i].equals("/" + Constants.NAME_XML_MOMENTUM); i++) {
            switch (dataSplit[i]) {
                case Constants.NAME:
                    name = dataSplit[i + 1];
                    break;
                case Constants.DESC:
                    while (!dataSplit[i + 1].equals("/" + Constants.DESC)) {
                        desc += dataSplit[i + 1] + "\n";
                        i++;
                    }
                    break;
                case Constants.COURSE_N:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                case Constants.WHAT_AFTER_PERIOD:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                case Constants.NUM_DATA:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                default:
                    break;
            }
        }
        return new Momentum(new CorrectData(data), name, desc);
    }

    private PurchPowerParity LoadPPP (String[] dataSplit, int idStart) {
        String name = "", desc = "";
        Data data = new Data();
        for (int i = idStart + 1; !dataSplit[i].equals("/" + Constants.NAME_XML_PPP); i++) {
            switch (dataSplit[i]) {
                case Constants.NAME:
                    name = dataSplit[i + 1];
                    break;
                case Constants.DESC:
                    while (!dataSplit[i + 1].equals("/" + Constants.DESC)) {
                        desc += dataSplit[i + 1] + "\n";
                        i++;
                    }
                    break;
                case Constants.RATES:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                case Constants.WHAT_AFTER_PERIOD:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                case Constants.NUM_DATA:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                default:
                    break;
            }
        }
        return new PurchPowerParity(new CorrectData(data), name, desc);
    }

    private Data LoadSimpleData (String[] dataSplit, int idStart) {
        Data data = new Data();
        for (int i = idStart + 1; !dataSplit[i].equals("/" + Constants.DATA_CLASS); i++) {
            switch (dataSplit[i]) {
                case Constants.NUM_DATA:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                default:
                    break;
            }
        }
        return data;
    }

    private CorrectData LoadCorrectData (String[] dataSplit, int idStart) {
        Data data = new Data();
        for (int i = idStart + 1; !dataSplit[i].equals("/" + Constants.CORRECT_DATA_CLASS); i++) {
            switch (dataSplit[i]) {
                case Constants.NUM_DATA:
                    data.addNum(Double.parseDouble(dataSplit[i + 1]));
                    break;
                default:
                    break;
            }
        }
        return new CorrectData(data);
    }
}
