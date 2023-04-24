package me.josecomparotto.compilador.semantic;

public class Program extends SemanticObject {

    public Program(Context context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return String.format("<Program>%s</Program>",
            this.context.toString()
        );
    }

}
