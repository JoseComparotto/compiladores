package me.josecomparotto.compilador.semantic.instruction;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.Value;

public class ConditionalStructure extends Instruction {

    private final Value condition;
    private final Context thenContext;
    private final Context elseContext;

    public ConditionalStructure(Value condition, Context thenContext, Context elseContext) {
        this.condition = condition;
        this.thenContext = thenContext;
        this.elseContext = elseContext;
    }

    public ConditionalStructure(Value condition, Context thenContext) {
        this(
                condition,
                thenContext,
                new Context());
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);

        condition.setContext(context);
        thenContext.setContext(context);
        elseContext.setContext(context);
    }

    @Override
    public String toString() {
        return String.format("<ConditionalStructure>%s%s%s</ConditionalStructure>",
                String.format("<Condition>%s</Condition>",
                    this.condition.toString()),
                String.format("<Then>%s</Then>",
                    this.thenContext.toString()),
                String.format("<Else>%s</Else>",
                    this.elseContext.toString())
        );
    }
}
