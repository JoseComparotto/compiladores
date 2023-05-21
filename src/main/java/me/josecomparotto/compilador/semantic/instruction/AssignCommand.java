package me.josecomparotto.compilador.semantic.instruction;

import me.josecomparotto.compilador.lexical.Token;
import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class AssignCommand extends Instruction {

    public final Token identifier;
    public final Value value;

    public AssignCommand(Token identifier, Value value) {
        this(null, identifier, value);
    }
    public AssignCommand(Context context, Token identifier, Value value) {
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
                .setVariable(this.identifier.value, this.value.getValue());
    }

}
