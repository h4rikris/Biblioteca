package com.tw.pathashala.view;

public class ConsoleOutputTemplate {
    private String template = "%s%s%s";
    private Integer width = 100;
    private String header = String.format("%s| %-97s|\n%s", divider(width), "Biblioteca", divider(width));
    private String body = "";

    public String divider(Integer length) {
        String output = "";
        for (int i = 0; i < length; i++) {
            output = output.concat("-");
        }
        return output + "\n";
    }

    public void addToBody(String bodyItem) {
        body = body.concat("\n" + bodyItem);
    }

    public void renderOutput() {
        System.out.print(String.format(template, header, body, divider(width)));
    }
}
