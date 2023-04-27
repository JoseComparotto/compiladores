package me.josecomparotto.compilador;

import java.io.FileInputStream;
import java.io.InputStream;

import me.josecomparotto.compilador.lexical.LexicalScanner;
import me.josecomparotto.compilador.syntax.SyntaxParser;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        try {

            final InputStream in = new FileInputStream(args[0]);

            String source = Helpers.getString(in);

            LexicalScanner scanner = new LexicalScanner(source);

            SyntaxParser parser = new SyntaxParser(scanner);

            // System.setOut(out);

            parser.parse();

            in.close();
            // out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
