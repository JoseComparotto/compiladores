package me.josecomparotto.compilador.semantic.value;

import java.util.Scanner;

import me.josecomparotto.compilador.semantic.Context;

public class InputLine extends Value {

    public InputLine() {
        this(null);
    }

    public InputLine(Context context) {
        super(context);
    }


    @Override
    public Object getValue() {

        String value;

        Scanner scan = new Scanner(System.in);

        value = scan.nextLine();

        scan.close();
        return value;
    }
}
