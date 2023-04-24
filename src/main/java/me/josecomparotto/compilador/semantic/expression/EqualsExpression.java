package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class EqualsExpression extends BinaryExpression {

    public EqualsExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }
    
}
