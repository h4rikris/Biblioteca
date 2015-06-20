package com.tw.pathashala.menu;

import com.tw.pathashala.controller.Dependencies;
import com.tw.pathashala.models.UserHistory;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutHistoryTest {
    @Mock
    ConsoleOutputTemplate outputTemplate;

    Dependencies dependencies = new Dependencies();
    UserHistory userHistory = dependencies.getUserHistory();

    @Test
    public void shouldGiveOutputWithUserHistory() {
        CheckOutHistory historyAction = new CheckOutHistory(userHistory, outputTemplate);

        historyAction.execute();

        verify(outputTemplate).addToBody(userHistory.toString());
    }

}