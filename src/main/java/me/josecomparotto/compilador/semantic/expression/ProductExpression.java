package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class ProductExpression extends BinaryExpression {

    public ProductExpression(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

}