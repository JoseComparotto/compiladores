package me.josecomparotto.compilador.lexical;

import java_cup.runtime.Symbol;
import me.josecomparotto.compilador.Helpers;

public class Token {

    public final Dictionary symbol;
    public final String value;
    public final int start;
    public final int end;
    public final int length;

    public Token(Dictionary symbol, String value, int start, int end) {
        this.symbol = symbol;
        this.value = value;
        this.start = start;
        this.end = end;
        this.length = value.length();
    }

    @Override
    public String toString() {
        return "<" + this.symbol.name() + ", '" + Helpers.escape(this.value) + "'>";
    }

    public Symbol getSymbol() {
        return new Symbol(symbol.getId(), start, end, this);
    }

}
