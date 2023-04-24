package me.josecomparotto.compilador.semantic;

public class Variable extends Value {

    private final String identifier;

    public Variable(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return String.format("<Variable identifier='%s'/>",
            this.identifier);
    }
}