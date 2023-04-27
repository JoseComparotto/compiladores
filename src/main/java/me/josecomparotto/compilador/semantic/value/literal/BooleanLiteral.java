package me.josecomparotto.compilador.semantic.value.literal;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class BooleanLiteral extends Value {

    private final boolean value;

    public BooleanLiteral(boolean value) {
        this(null, value);
    }
    
    public BooleanLiteral(Context context, boolean value) {
        super(context);
        this.value = value;
    }
    
    @Override
    public Object getValue() {
        return Boolean.valueOf(value);
    }
}
