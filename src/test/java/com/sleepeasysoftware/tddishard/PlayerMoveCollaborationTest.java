package com.sleepeasysoftware.tddishard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerMoveCollaborationTest {

    @InjectMocks
    private PlayerMove subject;

    // DATA
    @Mock
    private Map<String, String> boardBeforePlayerMove;
    @Mock
    private Map<String, String> boardWithPlayerMove;

    @Test
    public void validCallReturnsBoard() throws Exception {
        Map<String, String> response = subject.execute(boardBeforePlayerMove, "a2", "a3");

        assertThat(response, equalTo(boardWithPlayerMove));
    }
}