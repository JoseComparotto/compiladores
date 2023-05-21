package me.josecomparotto.compilador.lexical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.josecomparotto.compilador.syntax.JCupSymbols;

public enum Dictionary {

    // Tokens invisiveis
    COMMENT("//[\\s\\S]*?[\\n\\r]+|/\\*[\\s\\S]*?\\*/"), // Formato de comentário: // comentário
    BLANK("[\\s\\n]+"), // Delimitador de tokens: Caracteres invisíveis

    // Delimitador de instruções
    SEMICOLON(";"),

    // Delimitador de parametros
    COMMA(","),

    // Palavras reservadas
    KEYWORD_KAKU("kaku"),           // Comando de saída
    KEYWORD_MOSHI("moshi"),         // Estrutura condicional
    KEYWORD_SOREIGAI("soreigai"),   // Estrutura de negação da condição
    KEYWORD_TAMENI("tameni"),       // Estrutura de Repetição
    KEYWORD_KARA("kara"),           // "de"
    KEYWORD_MADE("made"),           // "até"
    KEYWORD_HO("ho"),               // "passo" 
    KEYWORD_NISE("nise"),           // Literal booleana falsa
    KEYWORD_SHIN("shin"),           // Literal booleana verdadeira
    KEYWORD_SHINAI("shinai"),       // Operadoe de negação
    KEYWORD_MO("mo"),               // Operador "e"
    KEYWORD_MATA("mata"),           // Operador "ou"

    // Chave de entrada
    QUESTION_MARK("\\?"),
    DOUBLE_QUESTION_MARK("\\?\\?"),

    // Operadores aritiméticos
    PERIOD("\\."),
    ASTERISK("\\*"),
    SLASH("/"),
    PLUS("\\+"),
    SUB_OPERATOR("-"),

    // Operadores relacionais
    EXCLAMATION_EQUALS("!="),
    DOUBLE_EQUALS("=="),
    LESS_THEN_EQUALS("<="),
    GREATER_THEN_EQUALS(">="),
    GREATER_THEN(">"),
    LESS_THEN("<"),

    // Operador de atribuição
    COLON_EQUALS(":="),

    // Delimitadores de parenteses
    OPEN_PARENTHESIS("\\("),
    CLOSE_PARENTHESIS("\\)"),

    // Delimitadores de escopo
    OPEN_BRACE("\\{"),
    CLOSE_BRACE("\\}"),

    // Literais
    NUMBER_LITERAL("\\d+(\\.\\d+)?(e[+-]?\\d+)?", Pattern.CASE_INSENSITIVE), // Literais numéricos
    TEXT_LITERAL("\"((?:(?:\\\\(?:u[0-9a-f]{4}|[0-7]{3}|x[0-9a-f]{2}|[abfnrtv'\"?\\\\]))|[^\\\"\\n\\\\])*)\"",
            Pattern.CASE_INSENSITIVE), // Literais de texto https://regexr.com/7a1k7

    // Identificador
    IDENTIFIER("[_A-Za-z][_A-Za-z0-9]*"), // Identificador universal

    // Final do arquivo
    EOF("$");

    public final Pattern pattern;

    private Dictionary(Pattern pattern) {
        this.pattern = pattern;
    }

    private Dictionary(String pattern, int flags) {
        this(Pattern.compile(pattern, flags));
    }

    private Dictionary(String pattern) {
        this(pattern, 0);
    }

    public Matcher matcher(CharSequence input) {
        return this.pattern.matcher(input);
    }

    public int getId(){
        try {
            return JCupSymbols.class.getField(this.name()).getInt(null);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            return -1;
        }
    }

}
