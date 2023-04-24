package me.josecomparotto.compilador.semantic.instruction;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.Value;

public class AssignCommand extends Instruction {
    
    public final String identifier;
    public final Value value;

    public AssignCommand(String identifier, Value value){
        this.identifier = identifier;
        this.value = value;
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);

        context.addIdentifier(identifier);
        value.setContext(context);
    }

}
