package org.example.pieces;

import org.example.ChessBoard;
import org.springframework.beans.factory.annotation.Autowired;

public class Pawn extends Piece {

    @Autowired
    ChessBoard chessBoard;

    // a = 97

    @Override
    public boolean canMove(String targetPosition){
        Piece piece = chessBoard.getPositions()[Integer.parseInt(String.valueOf(targetPosition.charAt(1)))][(int) targetPosition.charAt(0)-97];
        if(this.isWhite()){
            if(Integer.parseInt(String.valueOf(targetPosition.charAt(1)))==Integer.parseInt(String.valueOf(this.getCurrentPosition().charAt(1)))+1){
                if(((int) targetPosition.charAt(0)+1 == (int) this.getCurrentPosition().charAt(0)) ||
                        ((int) targetPosition.charAt(0)-1 == (int) this.getCurrentPosition().charAt(0))){
                    if(piece!=null){
                        if(piece.isWhite()){
                            return false;
                        }else{
                            return true;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else if(targetPosition.charAt(0)==this.getCurrentPosition().charAt(0)){
                if(piece!=null){
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else{
            if(Integer.parseInt(String.valueOf(targetPosition.charAt(1)))==Integer.parseInt(String.valueOf(this.getCurrentPosition().charAt(1)))-1){
                if(((int) targetPosition.charAt(0)+1 == (int) this.getCurrentPosition().charAt(0)) ||
                        ((int) targetPosition.charAt(0)-1 == (int) this.getCurrentPosition().charAt(0))){
                    if(piece!=null){
                        if(piece.isWhite()){
                            return false;
                        }else{
                            return true;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else if(targetPosition.charAt(0)==this.getCurrentPosition().charAt(0)){
                if(piece!=null){
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }
    }

}
