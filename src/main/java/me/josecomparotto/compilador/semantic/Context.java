package me.josecomparotto.compilador.semantic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import me.josecomparotto.compilador.semantic.instruction.Instruction;

public class Context extends SemanticObject {

    protected final Set<String> identifiers;
    protected final List<Instruction> instructions;

    public Context(Instruction... instructions) {
        this.identifiers = new HashSet<>();
        this.instructions = new ArrayList<>();

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

    public void addIdentifier(String identifier) {

        if (this.hasIdentifier(identifier))
            return; // TODO Lançar erro: variavel já declarada no contexto atual.

        this.identifiers.add(identifier);
    }

    public boolean hasIdentifier(String identifier) {
        return this.identifiers.contains(identifier) ||
                getContext() != null && getContext() != this &&
                        getContext().hasIdentifier(identifier);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public String toString() {

        return String.format("<Context>%s%s</Context>",
                String.format("<Identifiers>%s</Identifiers>",
                        this.identifiers.stream().map(v -> v.toString())
                                .collect(Collectors.joining(""))),

                String.format("<Instructions>%s</Instructions>",
                        this.instructions.stream().map(v -> v.toString())
                                .collect(Collectors.joining(""))));
    }

}
