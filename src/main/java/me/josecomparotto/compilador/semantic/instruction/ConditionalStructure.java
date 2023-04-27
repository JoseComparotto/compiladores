package me.josecomparotto.compilador.semantic.instruction;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class ConditionalStructure extends Instruction {

    private final Value condition;
    private final Context thenContext;
    private final Context elseContext;

    public ConditionalStructure(Value condition, Context thenContext, Context elseContext) {
        this(null, condition, thenContext, elseContext);
    }
    public ConditionalStructure(Context context, Value condition, Context thenContext, Context elseContext) {
        super(context);
        this.condition = condition;
        this.thenContext = thenContext;
        this.elseContext = elseContext;

    }

    public ConditionalStructure(Value condition, Context thenContext) {
        this(
                condition,
                thenContext,
                null);
    }

    public void setContext(Context context) {
        super.setContext(context);

        this.condition.setContext(context);

        context.addopt(thenContext);
        if (elseContext != null)
            context.addopt(elseContext);
    }

    @Override
    public String toString() {
        return String.format("<ConditionalStructure>%s%s%s</ConditionalStructure>",
                String.format("<Condition>%s</Condition>",
                        this.condition.toString()),
                String.format("<Then>%s</Then>",
                        this.thenContext.toString()),
                String.format("<Else>%s</Else>",
                        this.elseContext.toString()));
    }

    @Override
    public void run() {

        if (Boolean.valueOf(this.condition.getValue().toString())) {
            this.thenContext.run();
        } else {
            this.elseContext.run();
        }

    }
}
