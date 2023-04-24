package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class AddExpression extends BinaryExpression {

    public AddExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

}