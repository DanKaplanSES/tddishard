package com.sleepeasysoftware.tddishard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoveControllerCollaborationTest {

    @InjectMocks
    private MoveController subject;

    @Mock
    private Map<String, String> savedBoard;

    @Test
    public void callReturnsBoard() throws Exception {
        Map<String, String> response = subject.move(1L, "a2", "a3");

        assertThat(response, equalTo(savedBoard));
    }
}
