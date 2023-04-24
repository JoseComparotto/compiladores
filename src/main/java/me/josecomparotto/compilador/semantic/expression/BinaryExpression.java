package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.Value;

public abstract class BinaryExpression extends Value {

    protected final Value leftValue;
    protected final Value rightValue;

    public BinaryExpression(Value leftValue, Value rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);

        leftValue.setContext(context);
        rightValue.setContext(context);
    }

    @Override
    public String toString() {
        return String.format("<%s>%s%s</%s>",
                getClass().getName(),
                this.leftValue.toString(),
                this.rightValue.toString(),
                getClass().getName());
    }
}