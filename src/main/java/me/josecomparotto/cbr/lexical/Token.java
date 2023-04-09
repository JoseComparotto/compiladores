package me.josecomparotto.cbr.lexical;

import me.josecomparotto.cbr.Helpers;

public class Token {

    public final Dictionary symbol;
    public final String value;
    public final int start;
    public final int end;
    public final int length;
    public final String address;

    public Token(Dictionary symbol, String value, int start, int end, String address) {
        this.symbol = symbol;
        this.value = value;
        this.start = start;
        this.end = end;
        this.length = value.length();
        this.address = address;
    }

    @Override
    public String toString() {
        return "<token name='" + this.symbol.name() + "' value='" + Helpers.escape(this.value)
                + "' start='"
                + this.start
                + "' end='" + this.end + "' address='"+this.address+"'/>";
    }

}
