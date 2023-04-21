package me.josecomparotto.cbr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import me.josecomparotto.cbr.lexical.LexicalScanner;
import me.josecomparotto.cbr.syntax.SyntaxParser;

public class ExempleSyntaxTest {

    public static void main(String[] args) {

        final String TEST_INPUT_FILE = "exemples/exemple1.jpp";
        final String TEST_OUTPUT_FILE = "exemples/exemple1.txt";

        try {

            final InputStream in = new FileInputStream(TEST_INPUT_FILE);
            final PrintStream out = new PrintStream(new FileOutputStream(TEST_OUTPUT_FILE));

            String source = Helpers.getString(in);

            LexicalScanner scanner = new LexicalScanner(source);

            SyntaxParser parser = new SyntaxParser(scanner);

            parser.parse();

            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
