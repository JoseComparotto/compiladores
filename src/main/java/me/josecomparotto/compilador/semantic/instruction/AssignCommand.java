package me.josecomparotto.compilador.semantic.instruction;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class AssignCommand extends Instruction {

    public final String identifier;
    public final Value value;

    public AssignCommand(String identifier, Value value) {
        this(null, identifier, value);
    }
    public AssignCommand(Context context, String identifier, Value value) {
        super(context);
        this.identifier = identifier;
        this.value = value;
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);

        this.value.setContext(context);
    }

    @Override
    public String toString() {
        return String.format("<AssignCommand identifier='%s'>%s</AssignCommand>",
                this.identifier.toString(),
                this.value.toString());
    }

    @Override
    public void run() {
        getContext()
                .setVariable(this.identifier, this.value.getValue());
    }

}
