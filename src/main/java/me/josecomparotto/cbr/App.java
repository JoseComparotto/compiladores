package me.josecomparotto.cbr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import me.josecomparotto.cbr.lexical.LexicalScanner;
import me.josecomparotto.cbr.lexical.Token;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        final String TEST_INPUT_FILE = "exemples/exemple1.cbr";
        final String TEST_OUTPUT_FILE = "exemples/exemple1-tokens.xml";

        try {

            final InputStream in = new FileInputStream(args.length > 0 ? args[0] : TEST_INPUT_FILE);
            final PrintStream out = new PrintStream(new FileOutputStream(TEST_OUTPUT_FILE));

            LexicalScanner scanner = new LexicalScanner(in);

            out.println("<tokens>");
            for (Token t : scanner) {
                out.println("\t" + t.toString());
            }
            out.println("</tokens>");

            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
