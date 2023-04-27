package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public abstract class UnaryExpression extends Value {

    protected final Value value;

    public UnaryExpression(Value value) {
        this(null, value);
    }
    public UnaryExpression(Context context, Value value) {
        super(context);
        this.value = value;
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);

        this.value.setContext(context);
    }
    
    @Override
    public String toString() {
        return String.format("<%s>%s</%s>",
                getClass().getName(),
                this.value.toString(),
                getClass().getName());
    }

}