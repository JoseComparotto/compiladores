package me.josecomparotto.compilador.semantic.value;

import java.util.Scanner;

import me.josecomparotto.compilador.semantic.Context;

public class InputValue extends Value {

    public InputValue() {
        this(null);
    }

    public InputValue(Context context) {
        super(context);
    }


    @Override
    public Object getValue() {
        
        String value;
        
        Scanner scan = new Scanner(System.in);
        
        value = scan.next();

        scan.close();
        return value;
    }
}
