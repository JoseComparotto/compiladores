package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class AndExpression extends BinaryExpression {
    public AndExpression(Context context, Value leftValue, Value rightValue) {
        super(context, leftValue, rightValue);
    }

    public AndExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public Object getValue() {
        return Boolean.parseBoolean(leftValue.getValue().toString()) &&
                Boolean.parseBoolean(rightValue.getValue().toString());
    }
}