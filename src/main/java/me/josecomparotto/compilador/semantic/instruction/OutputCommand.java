package me.josecomparotto.compilador.semantic.instruction;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class OutputCommand extends Instruction {

    private final Value value;

    public OutputCommand(Value value) {
        this(null, value);
    }

    public OutputCommand(Context context, Value value) {
        super(context);
        this.value = value;
    }

    public Value getValue() {
        return this.value;
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);
        this.value.setContext(context);
    }

    @Override
    public String toString() {
        return String.format("<OutputCommand>%s</OutputCommand>",
            this.value
        );
    }

    @Override
    public void run() {
        System.out.println(value.getValue());
    }
}
