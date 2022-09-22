package com.program;

import java.util.regex.Pattern;

public class ProgramClass {

    // the num to be modified
    int num = 0;

    public Object handleRequest(String url) {
        System.out.println(url);
        switch (url) {
            case "/":
                return String.format("Number: %d", num);
            case "/increment":
                num += 1;
                return String.format("Number incremented!");
            default:
                if (url.contains("/add?")) {
                    String[] parameter = url.split(Pattern.quote("?"))[1].split("=");
                    if (parameter[0].equals("count")) {
                        num += Integer.parseInt(parameter[1]);
                        return String.format("Number increased by %s!", parameter[1]);
                    }
                }
            return "<b>404 Not Found!</b>";
        }
    }
}
