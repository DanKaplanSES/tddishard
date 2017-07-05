package com.sleepeasysoftware.tddishard;

import java.util.HashMap;
import java.util.Map;

class MovePiece {
    Map<String, String> execute(Map<String, String> board, String source, String destination) {
        String piece = board.remove(source);
        board.put(destination, piece);
        return board;
    }
}
