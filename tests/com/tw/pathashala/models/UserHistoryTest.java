package com.tw.pathashala.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.tw.pathashala.constants.Constants.LIBRARIAN;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserHistoryTest {

    @Mock
    Authentication authentication;

    Map<User, ArrayList<RentableItem>> userHistory = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        userHistory.put(new User("hari", "pass", LIBRARIAN), new ArrayList<RentableItem>());

    }

    @Test
    public void shouldGetCurrentLoggedInUserFromAuthenticationInAddingItemToUserHistory() {
        UserHistory history = new UserHistory(authentication, userHistory);
        RentableItem availableBook = new AvailableBook("RISK", "Hari", 2015);

        when(authentication.getCurrentLoggedInUser()).thenReturn(new User("hari", "pass", LIBRARIAN));
        history.addItem(availableBook);

        verify(authentication).getCurrentLoggedInUser();
    }

    @Test
    public void shouldGetCurrentLoggedInUserFromAuthenticationInRemovingItemToUserHistory() {
        UserHistory history = new UserHistory(authentication, userHistory);
        RentableItem availableBook = new AvailableBook("RISK", "Hari", 2015);

        when(authentication.getCurrentLoggedInUser()).thenReturn(new User("hari", "pass", LIBRARIAN));
        history.removeItem(availableBook);

        verify(authentication).getCurrentLoggedInUser();
    }

    @Test
    public void shouldListOutAllCheckOutItemsAndCorrespondingUser() {
        UserHistory history = new UserHistory(authentication, userHistory);
        RentableItem availableBook = new AvailableBook("RISK", "Hari", 2015);

        when(authentication.getCurrentLoggedInUser()).thenReturn(new User("hari", "pass", LIBRARIAN));
        history.addItem(availableBook);
        String actualResult = history.toString();
        String expected = "| hari:                                                                                            |\n" +
                "| RISK                                      | Hari                                      | 2015     |\n";

        assertEquals(expected, actualResult);
    }
}