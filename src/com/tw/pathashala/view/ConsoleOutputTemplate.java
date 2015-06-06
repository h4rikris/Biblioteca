package com.tw.pathashala.view;

public class ConsoleOutputTemplate {
    private String template = "";

    public String divider(Integer length) {
        String output = "";
        for (int i = 0; i < length; i++) {
            output = output.concat("-");
        }
        return output + "\n";
    }
}
