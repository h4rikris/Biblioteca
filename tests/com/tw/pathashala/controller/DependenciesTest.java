package com.tw.pathashala.controller;

import com.tw.pathashala.models.InputParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DependenciesTest {
    @Mock
    Dependencies dependencies;

    @Mock
    InputParser inputParser;

    @Test
    public void testToGetInputParserInstance() {

    }

    @Test
    public void testGetLibraryInstance() {

    }

    @Test
    public void testGetConsoleInputInstance() {

    }

    @Test
    public void testGetConsoleOutputInstance() {

    }
}