package me.josecomparotto.compilador.semantic.instruction;

import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.Semantic;

public abstract class Instruction extends Semantic implements Runnable {

    public Instruction(Context context) {
        super(context);
    }

}
