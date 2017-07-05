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

    //DATA
    @Mock
    private Map<String, String> boardBeforePlayerMove;
    @Mock
    private Map<String, String> boardAfterPlayerMove;
    @Mock
    private Map<String, String> boardAfterServerMove;
    @Mock
    private Map<String, String> savedBoard;

    //DEPENDENCIES
    @Mock
    private BoardRepository boardRepository;
    @Mock
    private PlayerMove playerMove;
    @Mock
    private ServerMove serverMove;

    @Test
    public void callReturnsBoard() throws Exception {
        when(boardRepository.findById(1L)).thenReturn(boardBeforePlayerMove);
        when(playerMove.execute(boardBeforePlayerMove, "a2", "a3")).thenReturn(boardAfterPlayerMove);
        when(serverMove.execute(boardAfterPlayerMove)).thenReturn(boardAfterServerMove);
        when(boardRepository.save(boardAfterServerMove)).thenReturn(savedBoard);

        Map<String, String> response = subject.move(1L, "a2", "a3");

        assertThat(response, equalTo(savedBoard));
    }
}
