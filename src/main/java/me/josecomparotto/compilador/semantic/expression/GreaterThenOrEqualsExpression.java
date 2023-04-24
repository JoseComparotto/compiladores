package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class GreaterThenOrEqualsExpression extends BinaryExpression {

    public GreaterThenOrEqualsExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }
    
}
