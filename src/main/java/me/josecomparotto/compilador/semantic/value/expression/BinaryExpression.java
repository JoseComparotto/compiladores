package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.Helpers;
import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public abstract class BinaryExpression extends Value {

    protected final Value leftValue;
    protected final Value rightValue;

    public BinaryExpression(Value leftValue, Value rightValue) {
        this(null, leftValue, rightValue);
    }

    public BinaryExpression(Context context, Value leftValue, Value rightValue) {
        super(context);
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);

        this.leftValue.setContext(context);
        this.rightValue.setContext(context);
    }

    @Override
    public String toString() {
        return String.format("<%s>%s%s</%s>",
                Helpers.className(this),
                this.leftValue.toString(),
                this.rightValue.toString(),
                Helpers.className(this));
    }

}