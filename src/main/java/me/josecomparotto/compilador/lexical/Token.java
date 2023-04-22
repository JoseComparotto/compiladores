package me.josecomparotto.compilador.lexical;

import java_cup.runtime.Symbol;
import me.josecomparotto.compilador.Helpers;

public class Token extends Symbol{

    public final Dictionary symbol;
    public final String value;
    public final int start;
    public final int end;
    public final int length;

    public Token(Dictionary symbol, String value, int start, int end) {
        super(symbol.getId(), "<token value='"+Helpers.escape(value)+"'/>");

        this.symbol = symbol;
        this.value = value;
        this.start = start;
        this.end = end;
        this.length = value.length();
    }

    @Override
    public String toString() {
        if (this.symbol.keepValue)
            return "<" + this.symbol.name() + ", '" + Helpers.escape(this.value) + "'>";
        else
            return "<" + this.symbol.name() + ">";

    }

}
