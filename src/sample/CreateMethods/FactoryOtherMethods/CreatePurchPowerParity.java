package sample.CreateMethods.FactoryOtherMethods;

import sample.Constants;
import sample.Data.IData;
import sample.CreateMethods.FactoryMethods;
import sample.Methods.IMethod;
import sample.Methods.Method;
import sample.Methods.OtherMethods.PurchPowerParity;

public class CreatePurchPowerParity extends FactoryMethods {
    @Override
    public Method createMethod(IData startData) {
        return new PurchPowerParity(startData, Constants.NAME_PPP, Constants.DESC_PPP);
    }
}
