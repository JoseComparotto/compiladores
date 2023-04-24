package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class GreaterThenExpression extends BinaryExpression {

    public GreaterThenExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }
    
}
