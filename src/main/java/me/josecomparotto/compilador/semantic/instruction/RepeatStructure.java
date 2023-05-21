package me.josecomparotto.compilador.semantic.instruction;

import me.josecomparotto.compilador.lexical.Token;
import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.literal.NumberLiteral;
import me.josecomparotto.compilador.semantic.value.Value;
import me.josecomparotto.compilador.semantic.value.VariableValue;
import me.josecomparotto.compilador.semantic.value.expression.AddExpression;
import me.josecomparotto.compilador.semantic.value.expression.GreaterThenOrEqualsExpression;
import me.josecomparotto.compilador.semantic.value.expression.LessThenExpression;
import me.josecomparotto.compilador.semantic.value.expression.LessThenOrEqualsExpression;

public class RepeatStructure extends Instruction {

    private final Token iterator;
    private final Value from;
    private final Value to;
    private final Value step;
    private final Context loopContext;

    public RepeatStructure(Context context, Token iterator, Value from, Value to, Value step, Context loopContext) {
        super(loopContext);
        this.iterator = iterator;
        this.from = from;
        this.to = to;
        this.step = step;
        this.loopContext = loopContext;
    }

    public RepeatStructure(Token iterator, Value from, Value to, Value step, Context loopContext) {
        this(null, iterator, from, to, step, loopContext);
    }

    public RepeatStructure(Context context, Token iterator, Value from, Value to, Context loopContext) {
        this(
                context,
                iterator,
                from,
                to,
                new NumberLiteral(1),
                loopContext);
    }

    public RepeatStructure(Token iterator, Value from, Value to, Context loopContext) {
        this(null, iterator, from, to, loopContext);
    }

    public void setContext(Context context) {
        super.setContext(context);

        this.from.setContext(context);
        this.to.setContext(context);

        if (this.step != null)
            this.step.setContext(context);

        context.addopt(loopContext);

    }

    @Override
    public String toString() {
        return String.format("<RepeatStructure>%s%s%s%s%s</RepeatStructure>",
                String.format("<Iterator identifier='%s'/>",
                        this.iterator.toString()),
                String.format("<From>%s</From>",
                        this.from.toString()),
                String.format("<To>%s</To>",
                        this.to.toString()),
                String.format("<Step>%s</Step>",
                        this.step.toString()),
                String.format("<Loop>%s</Loop>",
                        this.loopContext.toString()));
    }

    @Override
    public void run() {

        boolean asc = Boolean.valueOf(new LessThenExpression(getContext(), from, to).getValue().toString());
        double step = (asc ? 1 : -1) * Math.abs(Double.parseDouble(this.step.getValue().toString()));

        new AssignCommand(getContext(), iterator, from).run();

        if (step == 0)
            return; // TODO Erro loop infinito

        while (asc
                ? Boolean.valueOf(new LessThenOrEqualsExpression(getContext(), new VariableValue(getContext(), iterator), to).getValue().toString())
                : Boolean.valueOf(
                        new GreaterThenOrEqualsExpression(getContext(), new VariableValue(getContext(), iterator), to).getValue().toString())) {

            loopContext.run();

            new AssignCommand(getContext(), iterator, new AddExpression(getContext(), new VariableValue(getContext(), iterator), new NumberLiteral(getContext(), step))).run();
        }

    }
}
