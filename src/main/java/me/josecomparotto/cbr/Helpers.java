package me.josecomparotto.cbr;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Helpers {

    public static String escape(String s) {
        s = s
                .replace("\\", "\\\\")
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

            s= s.replaceAll("\\u" + unicode, "\\\\u" + unicode);
        }

        return s;
    }

    public static String getString(InputStream in) {
        return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

}
