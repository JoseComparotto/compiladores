package me.josecomparotto.compilador.semantic.literal;

import me.josecomparotto.compilador.Helpers;
import me.josecomparotto.compilador.semantic.Value;

public class TextLiteral extends Value {

    private final String value;

    public TextLiteral(String quotedString) {
        
        this.value = Helpers.unquote(quotedString);

    }

    @Override
    public String toString() {
        return String.format("<TextLiteral value='%s'/>",
                Helpers.escape(this.value));
    }
    
}
