package com.sleepeasysoftware.tddishard;

import java.util.HashMap;
import java.util.Map;

class MovePiece {
    Map<String, String> execute(Map<String, String> board, String source, String destination) {
        Map<String, String> output = new HashMap<String, String>(board);
        String piece = output.remove(source);
        output.put(destination, piece);
        return output;
    }
}
