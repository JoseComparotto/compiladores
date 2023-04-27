package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.value.Value;
import me.josecomparotto.compilador.semantic.Context;

public class NotEqualsExpression extends BinaryExpression {

    public NotEqualsExpression(Context context, Value leftValue, Value rightValue) {
        super(context, leftValue, rightValue);
    }
    public NotEqualsExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public Object getValue() {
        return ! leftValue.getValue().equals(rightValue.getValue());
    }

}
