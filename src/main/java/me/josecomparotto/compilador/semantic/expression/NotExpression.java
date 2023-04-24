package me.josecomparotto.compilador.semantic.expression;

import me.josecomparotto.compilador.semantic.Value;

public class NotExpression extends UnaryExpression {

    public NotExpression(Value value) {
        super(value);
    }

}