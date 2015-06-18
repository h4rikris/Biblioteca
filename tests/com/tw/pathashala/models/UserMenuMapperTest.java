package com.tw.pathashala.models;

import com.tw.pathashala.controller.Dependencies;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class UserMenuMapperTest {
    @Mock
    Authentication authentication;

    Map<User, InputParser> mapper;

    @Mock
    InputParser inputParser;

    @Before
    public void setUp() throws Exception {
        Dependencies dependencies = new Dependencies();
        mapper = dependencies.getUserMenuMapperList();
    }

    @Test
    public void shouldGetLoggedInUserFromAuthentication() {
        UserMenuMapper menuMapper = new UserMenuMapper(authentication, mapper);

        menuMapper.getMenu();

        Mockito.verify(authentication).getCurrentLoggedInUser();
    }
}