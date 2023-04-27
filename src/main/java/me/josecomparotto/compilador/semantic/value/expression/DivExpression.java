package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class DivExpression extends BinaryExpression {
    
    public DivExpression(Context context, Value leftValue, Value rightValue) {
        super(context, leftValue, rightValue);
    }

    public DivExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public Object getValue() {
        return Double.parseDouble(leftValue.getValue().toString()) /
                Double.parseDouble(rightValue.getValue().toString());
    }
}