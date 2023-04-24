package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.Value;

public class UnaryExpression extends Value {

    private final Value value;

    public UnaryExpression(Value value) {
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