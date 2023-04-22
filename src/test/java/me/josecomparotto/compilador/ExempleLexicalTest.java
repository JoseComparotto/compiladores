package me.josecomparotto.compilador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import me.josecomparotto.compilador.lexical.LexicalScanner;
import me.josecomparotto.compilador.lexical.Token;

public class ExempleLexicalTest {

    public static void main(String[] args) {

        final String TEST_INPUT_FILE = "docs/txt/exemplo.txt";
        final String TEST_OUTPUT_FILE = "exemples/exemple1.tokens.txt";

        try {

            final InputStream in = new FileInputStream(TEST_INPUT_FILE);
            final PrintStream out = new PrintStream(new FileOutputStream(TEST_OUTPUT_FILE));

            String source = Helpers.getString(in);

            LexicalScanner scanner = new LexicalScanner(source);

            out.println(replaceIn(source, scanner.getTokens()));

            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String replaceIn(String text, Token[] tokens) {

        String result = "";

        int pos = 0;

        for (Token token : tokens) {
            result += text.substring(pos, token.start);
            result += token.toString();

            pos = token.end;
        }

        if (pos < text.length())
            result += text.substring(pos, text.length() - 1);

        return result;
    }
}
