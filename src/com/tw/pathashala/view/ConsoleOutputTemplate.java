package com.tw.pathashala.view;

public class ConsoleOutputTemplate {
    private String template = "%s%s%s%s";
    private Integer width = 100;
    private String header = String.format("%s| %-97s|\n%s", divider(width), "BiBlioteca", divider(width));
    private String body = "";
    private String footer = "";

    public String divider(Integer length) {
        String output = "";
        for (int i = 0; i < length; i++) {
            output = output.concat("-");
        }
        return output + "\n";
    }

    private void addToBody(String bodyItem) {
        body = body.concat(bodyItem + "\n");
    }

    private void addToFooter(String footerItem) {
        footer = footer.concat(footerItem);
    }

    public void renderOutput(String bodyItem, String footerItem) {
        addToBody(bodyItem);
        addToFooter(footerItem);
        centrifyBody();
        System.out.print(String.format(template, header, body, divider(width), footer));
        body = "";
        footer = "";
    }

    public void prompt(String prompt) {
        System.out.print(prompt);
    }

    private void centrifyBody() {
        String spaces = "";
        for (int i = 0; i < 3; i++) {
            spaces = spaces.concat(String.format("| %-97s|\n", " "));
        }
        String newBody = spaces.concat(body);
        newBody = newBody.concat(spaces);
        body = newBody;
    }
}
