package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class AndExpression extends BinaryExpression {

    public AndExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

}