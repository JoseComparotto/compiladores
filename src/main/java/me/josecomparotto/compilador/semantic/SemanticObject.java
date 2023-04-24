package me.josecomparotto.compilador.semantic;

public abstract class SemanticObject {

    protected Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return String.format("<%s/>", this.getClass().getName());
    }
}
