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
    KEYWORD_YOMU("yomu"),           // Comando de entrada
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

    // Operadores aritiméticos
    PRODUCT_OPERATOR("\\*"),
    DIV_OPERATOR("/"),
    SUM_OPERATOR("\\+"),
    SUB_OPERATOR("-"),

    // Operadores relacionais
    NOT_EQUALS_OPERATOR("!="),
    EQUALS_OPERATOR("=="),
    LESS_THEN_OR_EQUALS_OPERATOR("<="),
    GREATER_THEN_OR_EQUALS_OPERATOR(">="),
    GREATER_THEN_OPERATOR(">"),
    LESS_THEN_OPERATOR("<"),

    // Operador de atribuição
    ASSIGNMENT_OPERATOR(":="),

    // Delimitadores de parenteses
    PARENTHESIS_OPENING("\\("),
    PARENTHESIS_CLOSURE("\\)"),

    // Delimitadores de escopo
    BLOCK_OPENING("\\{"),
    BLOCK_CLOSURE("\\}"),

    // Literais
    NUMBER_LITERAL("\\d+(\\.\\d+)?(e[+-]?\\d+)?", Pattern.CASE_INSENSITIVE, true), // Literais numéricos
    TEXT_LITERAL("\"((?:(?:\\\\(?:u[0-9a-f]{4}|[0-7]{3}|x[0-9a-f]{2}|[abfnrtv'\"?\\\\]))|[^\\\"\\n\\\\])*)\"",
            Pattern.CASE_INSENSITIVE, true), // Literais de texto https://regexr.com/7a1k7

    // Identificador
    IDENTIFIER("([_a-z][_a-z0-9]*)", true), // Identificador universal

    // Final do arquivo
    EOF("$");

    public final Pattern pattern;
    public final boolean keepValue;

    private Dictionary(Pattern pattern, boolean keepValue) {
        this.pattern = pattern;
        this.keepValue = keepValue;
    }

    private Dictionary(String pattern, int flags, boolean keepValue) {
        this(Pattern.compile(pattern, flags), keepValue);
    }

    private Dictionary(String pattern, boolean keepValue) {
        this(pattern, 0, keepValue);
    }

    private Dictionary(String pattern, int flags) {
        this(pattern, flags, false);
    }
    private Dictionary(String pattern) {
        this(pattern, 0, false);
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
