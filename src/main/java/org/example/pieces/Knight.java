package org.example.pieces;

import org.example.ChessBoard;
import org.springframework.beans.factory.annotation.Autowired;

public class Knight extends Piece{

    @Autowired
    ChessBoard chessBoard;

    @Override
    public boolean canMove(String targetPosition){
        int deltaX = Math.abs((int) targetPosition.charAt(0) - (int) this.getCurrentPosition().charAt(0));
        int deltaY = Math.abs(Integer.parseInt(String.valueOf(targetPosition.charAt(1))) - Integer.parseInt(String.valueOf(this.getCurrentPosition().charAt(1))));

        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }
}
