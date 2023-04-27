package me.josecomparotto.compilador.semantic;

public class Program extends Semantic implements Runnable  {

    public Program(Context context) {
        super(context);
    }

    @Override
    public String toString() {
        return String.format("<Program>%s</Program>",
            this.context.toString()
        );
    }

    @Override
    public void run() {
        this.context.run();
    }

}
