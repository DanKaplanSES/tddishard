package com.sleepeasysoftware.tddishard;

import java.util.Map;

class MoveController {

    private BoardRepository boardRepository;
    private PlayerMove playerMove;
    private ServerMove serverMove;

    public MoveController(BoardRepository boardRepository, PlayerMove playerMove, ServerMove serverMove) {
        this.boardRepository = boardRepository;
        this.playerMove = playerMove;
        this.serverMove = serverMove;
    }

    Map<String, String> move(long boardId, String sourcePosition, String destinationPosition) {
        Map<String, String> boardBeforePlayerMove = boardRepository.findById(boardId);
        Map<String, String> boardAfterPlayerMove = playerMove.execute(boardBeforePlayerMove, sourcePosition, destinationPosition);
        Map<String, String> boardAfterServerMove = serverMove.execute(boardAfterPlayerMove);
        return boardRepository.save(boardAfterServerMove);
    }
}
