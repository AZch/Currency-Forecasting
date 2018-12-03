package sample.Methods;

public class ContextMethod {
    private Method method;

    public void setMethod(Method method) {
        this.method = method;
    }

    public void culcMethod() {
        method.calc();
    }

    public void nextMethod() {
        if (method.next() != null)
            setMethod(method.next());
    }

    public void backMethod() {
        if (method.back() != null)
            setMethod(method.back());
    }
}
