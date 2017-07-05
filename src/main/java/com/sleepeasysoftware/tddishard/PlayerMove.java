package com.sleepeasysoftware.tddishard;

import java.util.Map;

class PlayerMove {

    private MovePiece movePiece;
    private ValidateMove validateMove;

    public PlayerMove(MovePiece movePiece, ValidateMove validateMove) {
        this.movePiece = movePiece;
        this.validateMove = validateMove;
    }

    Map<String, String> execute(Map<String, String> board, String source, String destination) {
        validateMove.execute(board, source, destination);
        return movePiece.execute(board, source, destination);
    }
}
