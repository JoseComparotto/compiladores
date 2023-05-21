package me.josecomparotto.compilador.semantic.value.literal;

import me.josecomparotto.compilador.Helpers;
import me.josecomparotto.compilador.lexical.Token;
import me.josecomparotto.compilador.semantic.Context;
import me.josecomparotto.compilador.semantic.value.Value;

public class TextLiteral extends Value {

    private final String value;

    public TextLiteral(Token quotedString) {
        this(null, quotedString);
    }
    public TextLiteral(Context context, Token quotedString) {
        super(context);
        this.value = Helpers.unquote(quotedString.value);
    }

    @Override
    public String toString() {
        return String.format("<TextLiteral value='%s'/>",
                Helpers.escape(this.value));
    }

    @Override
    public Object getValue() {
        return value;
    }
}
