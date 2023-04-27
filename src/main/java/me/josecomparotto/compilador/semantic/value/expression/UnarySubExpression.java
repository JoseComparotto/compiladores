package me.josecomparotto.compilador.semantic.value.expression;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class UnarySubExpression extends UnaryExpression {

    public UnarySubExpression(Context context, Value value) {
        super(context, value);
    }
    public UnarySubExpression(Value value) {
        super(value);
    }
   
    @Override
    public Object getValue() {
        return - Double.parseDouble(value.getValue().toString());
    }

}