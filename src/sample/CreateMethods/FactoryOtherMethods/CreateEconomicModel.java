package sample.CreateMethods.FactoryOtherMethods;

import sample.Data.IData;
import sample.CreateMethods.FactoryMethods;
import sample.Methods.Method;
import sample.Methods.OtherMethods.EconomicModel;

public class CreateEconomicModel extends FactoryMethods {
    @Override
    public Method createMethod(IData startData) {
        return new EconomicModel(startData);
    }
}
