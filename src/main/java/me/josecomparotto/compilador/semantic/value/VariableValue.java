package me.josecomparotto.compilador.semantic.value;

import me.josecomparotto.compilador.semantic.Context;

public class VariableValue extends Value {

    private final String identifier;

    public VariableValue(Context context, String identifier) {
        super(context);
        this.identifier = identifier;
    }

    public VariableValue(String identifier) {
        this(null, identifier);
    }

    @Override
    public String toString() {
        return String.format("<Variable identifier='%s'/>",
                this.identifier);
    }


    @Override
    public Object getValue() {
        return getContext()
                .getVariable(this.identifier);
    }
}