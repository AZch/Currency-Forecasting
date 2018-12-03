package sample.CreateMethods.FactoryCompMethods;

import sample.Data.IData;
import sample.CreateMethods.FactoryMethods;
import sample.Methods.CompMethods.Momentum;
import sample.Methods.IMethod;
import sample.Methods.Method;

public class CreateMomentum extends FactoryMethods {
    @Override
    public Method createMethod(IData startData) {
        return new Momentum(startData);
    }
}
