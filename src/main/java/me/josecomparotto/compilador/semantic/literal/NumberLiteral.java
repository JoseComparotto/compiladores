package me.josecomparotto.compilador.semantic.literal;

import me.josecomparotto.compilador.semantic.Value;

public class NumberLiteral extends Value {

    private final Number value;

    public NumberLiteral(String string) {
        this(Double.parseDouble(string));
    }

    public NumberLiteral(Number value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("<NumberLiteral value='%s'/>",
                this.value);
    }
}
