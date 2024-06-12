package org.example.pieces;

import org.example.ChessBoard;
import org.springframework.beans.factory.annotation.Autowired;

public class King extends Piece{

    @Autowired
    ChessBoard chessBoard;

    private boolean isCastlingAllowed = true;

    @Override
    public boolean canMove(String targetPosition){
        if(((int) targetPosition.charAt(0) == (int) targetPosition.charAt(0) + 1) || ((int) targetPosition.charAt(0) == (int) targetPosition.charAt(0) -1)
            || ((int) targetPosition.charAt(0) == (int) targetPosition.charAt(0))){
            if(((int) targetPosition.charAt(1) == (int) targetPosition.charAt(1) + 1) || ((int) targetPosition.charAt(1) == (int) targetPosition.charAt(1) -1)
                    || ((int) targetPosition.charAt(1) == (int) targetPosition.charAt(1))){
                if(this.getCurrentPosition()!=targetPosition){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            if(isCastlingAllowed){
                return false;
            }else{
                return false;
            }
        }
    }
}
