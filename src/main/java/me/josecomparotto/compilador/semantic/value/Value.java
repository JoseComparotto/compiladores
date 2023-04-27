package me.josecomparotto.compilador.semantic.value;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.Semantic;

public abstract class Value extends Semantic {
    
    public Value(Context context) {
        super(context);
    }

    public abstract Object getValue();

}
