package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class LessThenExpression extends BinaryExpression {

    public LessThenExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }
    
}
