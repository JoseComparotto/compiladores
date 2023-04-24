package me.josecomparotto.compilador;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import me.josecomparotto.compilador.lexical.Dictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Helpers {

    public static String escape(String s) {
        s = s.replace("\\", "\\\\")
                .replace("\b", "\\b")
                .replace("\t", "\\t")
                .replace("\n", "\\n")
                .replace("\f", "\\f")
                .replace("\r", "\\r")
                .replace("\'", "\\'")
                .replace("\"", "\\\"");

        Matcher m = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u00A0\\u0100-\\uFFFF]").matcher(s);

        while (m.find()) {
            String value = m.group();
            int charCode = (int) value.charAt(0);

            String unicode = Integer.toHexString(charCode);

            while (unicode.length() < 4)
                unicode = "0" + unicode;

            s = s.replaceAll("\\u" + unicode, "\\\\u" + unicode);
        }

        return s;
    }

    public static String unquote(String s) {

        Matcher m = Dictionary.TEXT_LITERAL.matcher(s);

        if (m.find()) {
            s = m.group(1);
        }

        s = s.replace("\\\\", "\\")
                .replace("\\\b", "\b")
                .replace("\\\t", "\t")
                .replace("\\\n", "\n")
                .replace("\\\f", "\f")
                .replace("\\\r", "\r")
                .replace("\\\'", "\'")
                .replace("\\\"", "\"");

        m = Pattern.compile("\\\\u([0-9A-Fa-f]{4})").matcher(s);

        while (m.find()) {
            String unicode = m.group();
            String hexValue = m.group(1);

            int charCode = Integer.parseInt(hexValue, 16);

            s = s.replaceAll(unicode, Character.toString((char) charCode));
        }

        m = Pattern.compile("\\\\[0-7]{3}").matcher(s);

        while (m.find()) {
            String octcode = m.group();
            String octValue = m.group(1);

            int charCode = Integer.parseInt(octValue, 8);

            s = s.replaceAll(octcode, Character.toString((char) charCode));
        }

        return s;
    }

    public static String getString(InputStream in) {
        return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

    public static String toLineColumnAddress(int position, String text) {

        int line = 0;
        int column = 0;

        String[] lines = text.split("\n");

        int currPosition = 0;

        for (line = 0; line < lines.length; line++) {
            if (currPosition + lines[line].length() + 1 > position) {
                column = position - currPosition;
                break;
            }
            currPosition += lines[line].length() + 1;
        }

        return "linha " + (line + 1) + ", coluna " + (column + 1);
    }

}
