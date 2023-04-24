package me.josecomparotto.compilador.semantic.instruction;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.Value;
import me.josecomparotto.compilador.semantic.literal.NumberLiteral;

public class RepeatStructure extends Instruction {
    
    private final String iterator;
    private final Value from;
    private final Value to;
    private final Value step;
    private final Context loopContext;

    public RepeatStructure(String iterator, Value from, Value to, Value step, Context loopContext){
        this.iterator = iterator;
        this.from = from;
        this.to = to;
        this.step = step;
        this.loopContext = loopContext;
    }

    public RepeatStructure(String iterator, Value from, Value to, Context loopContext){
        this(
            iterator,
            from,
            to,
            new NumberLiteral(1),
            loopContext
        );
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);

        context.addIdentifier(iterator);   
        from.setContext(context);   
        to.setContext(context);   
        step.setContext(context);   
        loopContext.setContext(context); 

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
                    this.loopContext.toString())
        );
    }
}
