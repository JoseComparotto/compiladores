package me.josecomparotto.cbr.syntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rule {

    public final String name;
    private List<Object> children;

    public Rule(String name, Object... children) {
        this.name = name;
        this.children = new ArrayList<>(Arrays.asList(children));
    }

    public Rule(Rule rule, Object... children) {
        this(rule.name);

        this.children.addAll(rule.children);

        this.children.addAll(Arrays.asList(children));
    }

    public Object[] getChildren() {
        return children.toArray(new Rule[0]);
    }

    public void add(Object child) {
        this.children.add(child);
    }

    @Override
    public String toString() {

        if (this.children.size() == 0)
            return "<" + this.name + "/>";

        String s = "<" + this.name + ">";

        for (Object child : this.children) {
            if (child == null)
                s += "<null/>";
            else
                s += child.toString();
        }

        s += "</" + this.name + ">";

        return s;
    }

}
