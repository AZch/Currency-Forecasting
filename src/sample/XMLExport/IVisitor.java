package sample.XMLExport;

import sample.Data.Data;
import sample.Data.ProxyData.CorrectData;
import sample.Methods.CompMethods.ApproachMethod;
import sample.Methods.CompMethods.Momentum;
import sample.Methods.Method;
import sample.Methods.OtherMethods.EconomicModel;
import sample.Methods.OtherMethods.PurchPowerParity;

public interface IVisitor {
    public String visitApproachMethod(ApproachMethod method);
    public String visitMomentum(Momentum method);

    public String visitPurchPowerParity(PurchPowerParity method);
    public String visitEconomicModel(EconomicModel method);

    public String visitData(Data data);
    public String visitCorrectData(CorrectData correctData);
}
