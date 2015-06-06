package com.tw.pathashala.view;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConsoleOutputTemplateTest {

    @Test
    public void testForDivider() {
        ConsoleOutputTemplate template = new ConsoleOutputTemplate();
        String divider = template.divider(100);
        String expectdDivider = "------------------------------------------------------------------------------------" +
                "----------------";

        assertThat(divider, is(expectdDivider));
    }

}