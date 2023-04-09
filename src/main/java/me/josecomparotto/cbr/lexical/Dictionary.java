package me.josecomparotto.cbr.lexical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Dictionary {

    // Tokens invisiveis
    COMMENT("//[\\s\\S]*?[\\n\\r]+|/\\*[\\s\\S]*?\\*/"), // Formato de comentário: // comentário
    WHITE_SPACES("[\\s\\n]+"), // Delimitador de tokens: Caracteres invisíveis

    // Delimitador de instruções
    SEMICOLON(";"),

    // Delimitador de parametros
    COMMA(","),

    // Palavras reservadas
    KEYWORD_ESCREVA("escreva"),
    KEYWORD_LEIA("leia"),
    KEYWORD_INTEIRO("inteiro"),
    KEYWORD_REAL("real"),
    KEYWORD_TEXTO("texto"),
    KEYWORD_LOGICO("logico"),
    KEYWORD_SE("se"),
    KEYWORD_SENAO("senao"),
    KEYWORD_PARA("para"),
    KEYWORD_DE("de"),
    KEYWORD_ATE("ate"),
    KEYWORD_PASSO("passo"),
    KEYWORD_FALSO("falso"),
    KEYWORD_VERDADEIRO("verdadeiro"),
    KEYWORD_NAO("nao"),
    KEYWORD_E("e"),
    KEYWORD_OU("ou"),

    // Operadores aritiméticos
    PRODUCT_OPERATOR("\\*"),
    DIV_OPERATOR("/"),
    SUM_OPERATOR("\\+"),
    SUB_OPERATOR("-"),

    // Operadores relacionais
    EQUALS_OPERATOR("=="),
    LESS_THEN_OR_EQUALS_OPERATOR("<="),
    GREATER_THEN_OR_EQUALS_OPERATOR(">="),
    GREATER_THEN_OPERATOR(">"),
    LESS_THEN_OPERATOR("<"),

    // Operador de atribuição
    ASSIGNMENT_OPERATOR("="),

    // Delimitadores de parenteses
    PARENTHESIS_OPENING("\\("),
    PARENTHESIS_CLOSURE("\\)"),

    // Delimitadores de escopo
    BLOCK_OPENING("\\{"),
    BLOCK_CLOSURE("\\}"),

    // Literais
    INTEGER_LITERAL("\\d+", Pattern.CASE_INSENSITIVE), // Literais Inteiros
    FLOAT_LITERAL("\\d+\\.\\d+", Pattern.CASE_INSENSITIVE), // Literais Reais
    TEXT_LITERAL("\"(?:(\\\\(u[0-9a-f]{4}|[0-7]{3}|x[0-9a-f]{2}|[abfnrtv'\"?\\\\]))|[^\\\"\\n\\\\])*\"",
            Pattern.CASE_INSENSITIVE), // Literais de texto https://regexr.com/7a1k7

    // Identificador
    IDENTIFIER("[_a-z][_a-z0-9]*"), // Identificador universal

    // Final do arquivo
    EOF("$");

    private final Pattern pattern;

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

}
