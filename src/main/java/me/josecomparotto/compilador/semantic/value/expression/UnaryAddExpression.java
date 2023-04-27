package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class UnaryAddExpression extends UnaryExpression {

    public UnaryAddExpression(Context context, Value value) {
        super(context, value);
    }
    public UnaryAddExpression(Value value) {
        super(value);
    }

    @Override
    public Object getValue() {
        return + Double.parseDouble(value.getValue().toString());
    }

}