package me.josecomparotto.compilador.semantic.value.literal;

import me.josecomparotto.compilador.lexical.Token;
import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class NumberLiteral extends Value {

    private final Number value;

    public NumberLiteral(Context context, Token string) {
        this(context, Double.parseDouble(string.value));
    }

    public NumberLiteral(Token value) {
        this(null, value);
    }

    public NumberLiteral(Context context, Number value) {
        super(context);
        this.value = value;
    }
    
    public NumberLiteral(Number value) {
        this(null, value);
    }


    @Override
    public String toString() {
        return String.format("<NumberLiteral value='%s'/>",
                this.value);
    }

    @Override
    public Object getValue() {
        return value;
    }
}
