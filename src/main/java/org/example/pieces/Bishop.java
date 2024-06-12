package org.example.pieces;

import org.example.ChessBoard;
import org.springframework.beans.factory.annotation.Autowired;

public class Bishop extends Piece{

    @Autowired
    ChessBoard chessBoard;

    @Override
    public boolean canMove(String targetPosition){
        return false;
    }
}
