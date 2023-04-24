package me.josecomparotto.compilador.semantic.literal;

import me.josecomparotto.compilador.semantic.Value;

public class BooleanLiteral extends Value {

    private final boolean value;

    public BooleanLiteral(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("<BooleanLiteral value='%s'/>",
                this.value);
    }
}
