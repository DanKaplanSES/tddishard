package com.sleepeasysoftware.tddishard;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class MovePieceLogicTest {

    private MovePiece movePiece;

    @Before
    public void setUp() throws Exception {
        movePiece = new MovePiece();
    }

    @Test
    public void outputHasPieceMoved() throws Exception {
        Map<String, String> input = new HashMap<String, String>();
        input.put("a2", "fooPiece");

        Map<String, String> output = movePiece.execute(input, "a2", "a3");

        assertThat(output.get("a2"), nullValue());
        assertThat(output.get("a3"), equalTo("fooPiece"));
    }

    @Test
    public void inputIsUnchanged() throws Exception {
        Map<String, String> input = new HashMap<String, String>();
        input.put("a2", "fooPiece");

        movePiece.execute(input, "a2", "a3");

        assertThat(input.get("a2"), equalTo("fooPiece"));
        assertThat(input.get("a3"), nullValue());
    }
}