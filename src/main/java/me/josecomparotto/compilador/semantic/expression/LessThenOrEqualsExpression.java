package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class LessThenOrEqualsExpression extends BinaryExpression {

    public LessThenOrEqualsExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }
    
}
