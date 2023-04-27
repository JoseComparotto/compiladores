package me.josecomparotto.compilador.semantic;

import me.josecomparotto.compilador.Helpers;

public abstract class Semantic {

    protected Context context;

    protected Semantic(){

    }

    protected Semantic(Context context){
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return String.format("<%s/>", Helpers.className(this));
    }
    
}
