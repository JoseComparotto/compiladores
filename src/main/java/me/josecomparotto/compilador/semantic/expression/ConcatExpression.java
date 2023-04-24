package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class ConcatExpression extends BinaryExpression {

    public ConcatExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

}