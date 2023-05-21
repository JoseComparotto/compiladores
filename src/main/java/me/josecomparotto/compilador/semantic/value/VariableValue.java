package me.josecomparotto.compilador.semantic.value;

import me.josecomparotto.compilador.lexical.Token;
import me.josecomparotto.compilador.semantic.Context;

public class VariableValue extends Value {

    private final Token identifier;

    public VariableValue(Context context, Token identifier) {
        super(context);
        this.identifier = identifier;
    }

    public VariableValue(Token identifier) {
        this(null, identifier);
    }

    @Override
    public String toString() {
        return String.format("<Variable identifier='%s'/>",
                this.identifier.value);
    }


    @Override
    public Object getValue() {
        return getContext()
                .getVariable(this.identifier.value);
    }
}