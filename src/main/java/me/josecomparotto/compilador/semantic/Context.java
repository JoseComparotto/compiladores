package me.josecomparotto.compilador.semantic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import me.josecomparotto.compilador.semantic.instruction.Instruction;

public class Context extends Semantic implements Runnable {

    protected final List<Instruction> instructions;
    protected final List<Context> children;
    protected final Map<String, Object> variablesMap;

    public Context(Instruction... instructions) {
        this(null, instructions);
    }

    public Context(Context context, Instruction... instructions) {
        super(context);
        this.instructions = new ArrayList<>();
        this.children = new ArrayList<>();
        this.variablesMap = new HashMap<>();

        for (Instruction instruction : instructions) {
            this.addInstruction(instruction);
        }
    }

    public Instruction[] getInstructions() {
        return this.instructions.toArray(new Instruction[0]);
    }

    public void addInstruction(Instruction instruction) {
        instruction.setContext(this);

        this.instructions.add(instruction);
    }

    public void addopt(Context child) {
        child.setContext(this);
        this.children.add(child);
    }

    @Override
    public String toString() {
        return String.format("<Context>%s</Context>",
                this.instructions.stream().map(v -> v.toString())
                        .collect(Collectors.joining("")));
    }

    public void setVariable(String identifier, Object value) {
        if(getContext() != null && getContext().hasVariable(identifier)){
            getContext().setVariable(identifier, value);
            return;
        }

        this.variablesMap.put(identifier, value);
    }

    public Object getVariable(String identifier) {
        if(!this.hasVariable(identifier)){
            return null;
        }

        if (!variablesMap.keySet().contains(identifier))
            return getContext().getVariable(identifier);

        return this.variablesMap.get(identifier);
    }

    public boolean hasVariable(String identifier) {
        return variablesMap.keySet().contains(identifier) || 
            getContext() != null && getContext().hasVariable(identifier);
    }

    @Override
    public void run() {
        variablesMap.clear();

        for (Instruction instruction : this.instructions) {
            instruction.run();
        }
    }

}
