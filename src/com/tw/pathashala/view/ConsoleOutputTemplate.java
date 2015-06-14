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

    public void addToBody(String bodyItem) {
        body = body.concat(bodyItem + "\n");
    }

    public void addToFooter(String footerItem) {
        footer = footer.concat(footerItem);
    }

    public void renderOutput() {
        centrifyBody();
        System.out.print(String.format(template, header, body, divider(width), footer));
        body = "";
        footer = "";
    }

    private void centrifyBody() {
        String spaces = "";
        for(int i=0; i<3; i++){
            spaces = spaces.concat(String.format("| %-97s|\n"," "));
        }
        String newBody = spaces.concat(body);
        newBody = newBody.concat(spaces);
        body = newBody;
    }
}
