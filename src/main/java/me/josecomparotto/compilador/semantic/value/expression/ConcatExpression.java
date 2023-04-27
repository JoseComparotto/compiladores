package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class ConcatExpression extends BinaryExpression {
    
    public ConcatExpression(Context context, Value leftValue, Value rightValue) {
        super(context, leftValue, rightValue);
    }

    public ConcatExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public Object getValue() {
        return String.format("%s%s",
                this.leftValue.getValue(),
                this.rightValue.getValue());
    }
}