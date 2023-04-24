package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class NotEqualsExpression extends BinaryExpression {

    public NotEqualsExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }
    
}
