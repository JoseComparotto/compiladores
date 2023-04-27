package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class NotExpression extends UnaryExpression {

    public NotExpression(Context context, Value value) {
        super(context, value);
    }
    public NotExpression(Value value) {
        super(value);
    }

    @Override
    public Object getValue() {
        return ! Boolean.parseBoolean(value.getValue().toString());
    }

}