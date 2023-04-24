package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class DivExpression extends BinaryExpression {

    public DivExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

}