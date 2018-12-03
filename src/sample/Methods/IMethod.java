package sample.Methods;

import sample.XMLExport.IVisitor;

public interface IMethod {
    String calc();
    String visit(IVisitor visitor);
}
