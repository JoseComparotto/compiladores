package me.josecomparotto.compilador;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CompileJCupGrammar {

    public static void main(String[] args) {

        final String JCUP_GRAMMAR_FILE = "docs/jcup/gramatica.cup";

        final String SYNTAX_JAVA_LOCATION = "src/main/java/me/josecomparotto/cbr/syntax";
        final String SYNTAX_PACKAGE = "me.josecomparotto.cbr.syntax";

        final String PARSER_CLASS = "SyntaxParser";
        final String SYMBOLS_CLASS = "JCupSymbols";

        try {

            final InputStream in = new FileInputStream(JCUP_GRAMMAR_FILE);

            System.setIn(in);

            java_cup.Main.main(new String[] {
                    "-package", SYNTAX_PACKAGE,
                    "-parser", PARSER_CLASS,
                    "-symbols", SYMBOLS_CLASS
            });

            Files.move(Path.of(".", PARSER_CLASS + ".java"), Path.of(".", SYNTAX_JAVA_LOCATION, PARSER_CLASS + ".java"),
                    StandardCopyOption.REPLACE_EXISTING);

            Files.move(Path.of(".", SYMBOLS_CLASS + ".java"),
                    Path.of(".", SYNTAX_JAVA_LOCATION, SYMBOLS_CLASS + ".java"),
                    StandardCopyOption.REPLACE_EXISTING);

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
