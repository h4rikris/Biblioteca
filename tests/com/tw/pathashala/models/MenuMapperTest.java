package com.tw.pathashala.models;

import com.tw.pathashala.controller.Dependencies;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static com.tw.pathashala.constants.Constants.LIBRARIAN;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuMapperTest {
    @Mock
    Authentication authentication;

    Map<Integer, InputParser> mapper;

    @Mock
    InputParser inputParser;

    @Mock
    User user;

    @Before
    public void setUp() throws Exception {
        Dependencies dependencies = new Dependencies();
        mapper = dependencies.getUserMenuMapperList();
    }

    @Test
    public void shouldGetLoggedInUserFromAuthentication() {
        MenuMapper menuMapper = new MenuMapper(authentication, mapper);

        when(authentication.getCurrentLoggedInUser()).thenReturn(user);
        when(user.getRole()).thenReturn(LIBRARIAN);
        menuMapper.getMenu();

        Mockito.verify(authentication).getCurrentLoggedInUser();
    }

    @Test
    public void shouldGetRoleFromUser() {
        MenuMapper menuMapper = new MenuMapper(authentication, mapper);

        when(authentication.getCurrentLoggedInUser()).thenReturn(user);
        menuMapper.getMenu();

        Mockito.verify(user).getRole();
    }
}