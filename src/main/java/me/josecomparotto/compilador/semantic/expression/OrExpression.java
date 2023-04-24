package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class OrExpression extends BinaryExpression {

    public OrExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

}