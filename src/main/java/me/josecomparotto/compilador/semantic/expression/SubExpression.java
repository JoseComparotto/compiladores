package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class SubExpression extends BinaryExpression {

    public SubExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

}