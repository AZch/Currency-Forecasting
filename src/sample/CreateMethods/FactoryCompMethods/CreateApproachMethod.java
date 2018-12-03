package sample.CreateMethods.FactoryCompMethods;

import sample.Data.IData;
import sample.CreateMethods.FactoryMethods;
import sample.Methods.CompMethods.ApproachMethod;
import sample.Methods.IMethod;
import sample.Methods.Method;

public class CreateApproachMethod extends FactoryMethods {
    @Override
    public Method createMethod(IData startData) {
        return new ApproachMethod(startData);
    }
}
