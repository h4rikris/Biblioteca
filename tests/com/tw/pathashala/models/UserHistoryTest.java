package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserHistoryTest {

    @Mock
    Authentication authentication;

    Map<User, ArrayList<RentableItem>> userHistory = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        userHistory.put(new User("hari", "pass"), new ArrayList<RentableItem>());

    }

    @Test
    public void shouldGetCurrentLoggedInUserFromAuthenticationInAddingItemToUserHistory() {
        UserHistory history = new UserHistory(authentication, userHistory);
        RentableItem availableBook = new AvailableBook("RISK", "Hari", 2015);

        when(authentication.getCurrentLoggedInUser()).thenReturn(new User("hari", "pass"));
        history.addItem(availableBook);

        verify(authentication).getCurrentLoggedInUser();
    }
}