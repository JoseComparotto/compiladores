package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.value.Value;
import me.josecomparotto.compilador.semantic.Context;

public class LessThenOrEqualsExpression extends BinaryExpression {

    public LessThenOrEqualsExpression(Context context, Value leftValue, Value rightValue) {
        super(context, leftValue, rightValue);
    }
    public LessThenOrEqualsExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public Object getValue() {
        return Double.parseDouble(leftValue.getValue().toString()) <= Double
                .parseDouble(rightValue.getValue().toString());
    }

}
