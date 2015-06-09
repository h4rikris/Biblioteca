package com.tw.pathashala.view;

public class ConsoleOutputTemplate {
    private String template = "%s%s%s%s\nChoose Option:";
    private Integer width = 100;
    private String header = String.format("%s| %-97s|\n%s", divider(width), "Biblioteca", divider(width));
    private String body = "";
    private String footer = "";

    public String divider(Integer length) {
        String output = "";
        for (int i = 0; i < length; i++) {
            output = output.concat("-");
        }
        return output + "\n";
    }

    public void addToBody(String bodyItem) {
        body = body.concat(bodyItem + "\n");
    }

    public void addToFooter(String footerItem) {
        footer = footer.concat(footerItem + "\n");
    }

    public void renderOutput() {
        System.out.print(String.format(template, header, body, divider(width), footer));
    }
}
