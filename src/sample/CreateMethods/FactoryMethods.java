package sample.CreateMethods;

import sample.Data.IData;
import sample.Methods.IMethod;
import sample.Methods.Method;

public abstract class FactoryMethods {
    public abstract Method createMethod(IData startData);
}
