package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class OrExpression extends BinaryExpression {

    public OrExpression(Context context, Value leftValue, Value rightValue) {
        super(context, leftValue, rightValue);
    }
    public OrExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public Object getValue() {
        return Boolean.parseBoolean(leftValue.getValue().toString()) ||
                Boolean.parseBoolean(rightValue.getValue().toString());
    }
}