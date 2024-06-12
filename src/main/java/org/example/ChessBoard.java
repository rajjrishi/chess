package org.example;

import lombok.Data;
import org.apache.catalina.Lifecycle;
import org.example.pieces.*;

@Data
public class ChessBoard {

    Piece[][] positions;

    public ChessBoard(){
        positions = new Piece[8][8];
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                positions[i][j] = null;
            }
        }
    }

    public boolean putPieceOrReturnFalseIfNotPossible(Piece piece, String position){
        if(positions[Integer.parseInt(String.valueOf(position.charAt(1)))-1][(int) position.charAt(0) -97]==null){
            positions[Integer.parseInt(String.valueOf(position.charAt(1)))-1][(int) position.charAt(0) -97] = piece;
        }else{
            return false;
        }
        return true;
    }

    public void printBoard() {
        // Print the board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (positions[i][j] != null) {
                    // Print piece symbol based on type and color
                    System.out.print(positions[i][j].isWhite() ? "W" : "B");
                    System.out.print(positions[i][j] instanceof Pawn ? "Pawn" :
                            positions[i][j] instanceof Knight ? "Knight" :
                                    positions[i][j] instanceof Bishop ? "Bishop" :
                                            positions[i][j] instanceof Rook ? "Rook" :
                                                    positions[i][j] instanceof Queen ? "Queen" :
                                                            positions[i][j] instanceof King ? "King" : "");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
