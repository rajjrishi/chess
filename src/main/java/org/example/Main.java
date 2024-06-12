package org.example;

import org.example.pieces.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);
        ChessBoard chessBoard = new ChessBoard();

        int t = scanner.nextInt();
        scanner.nextLine();
        while(t>0){
            String pos = scanner.nextLine();
            String piece = scanner.nextLine();
            String color = scanner.nextLine();

            Piece piece1 = null;
            pos.trim();
            piece.trim();
            color.trim();
            if(piece.equalsIgnoreCase("Pawn")){
                piece1 = new Pawn();
            }else if(piece.equalsIgnoreCase("Queen")){
                piece1 = new Queen();
            }else if(piece.equalsIgnoreCase("King")){
                piece1 = new King();
            }else if(piece.equalsIgnoreCase("Bishop")){
                piece1 = new Bishop();
            }else if(piece.equalsIgnoreCase("Knight")){
                piece1 = new Knight();
            }else if(piece.equalsIgnoreCase("Rook")){
                piece1 = new Rook();
            }else{
                System.out.println("Invalid Input");
                continue;
            }

            if(color!=null && color.equalsIgnoreCase("white")){
                piece1.setWhite(true);
            }else{
                piece1.setWhite(false);
            }

            piece1.setCurrentPosition(pos);

            if(!chessBoard.putPieceOrReturnFalseIfNotPossible(piece1,pos)){
                System.out.println("Place already occupied");
                continue;
            }
            t--;
        }

        int tt = scanner.nextInt();
        scanner.nextLine();
        while (tt>0){
            chessBoard.printBoard();
            String move = scanner.nextLine();
            int initialPos = Integer.parseInt(String.valueOf(move.charAt(1)));
            int finalPos = Integer.parseInt(String.valueOf(move.charAt(4)));
            if(initialPos<0 || initialPos>7 || finalPos<0 || finalPos>7 || move.charAt(0)<'a' || move.charAt(0)>'h'
            || move.charAt(3)<'a' || move.charAt(3)>'h'){
                System.out.println("Invalid move. Please enter valid move");
                continue;
            }else{
                Piece piece = chessBoard.positions[Integer.parseInt(String.valueOf(move.charAt(1)))-1][(int) move.charAt(0) -97];
                Piece piece1 = chessBoard.positions[Integer.parseInt(String.valueOf(move.charAt(4)))-1][(int) move.charAt(3) -97];
                if(piece!=null){
                    if(piece1!=null){
                        if(piece1.isWhite()== piece.isWhite()){
                            System.out.println("Invalid move. Please enter valid move");
                            continue;
                        }else{
                            piece.setCurrentPosition(piece1.getCurrentPosition());
                            chessBoard.positions[Integer.parseInt(String.valueOf(move.charAt(4)))-1][(int) move.charAt(3) -97] = piece;
                            chessBoard.positions[Integer.parseInt(String.valueOf(move.charAt(1)))-1][(int) move.charAt(0) -97] = null;
                        }
                    }else{
                        piece.setCurrentPosition(move.substring(3,4));
                        chessBoard.positions[Integer.parseInt(String.valueOf(move.charAt(4)))-1][(int) move.charAt(3) -97] = piece;
                        chessBoard.positions[Integer.parseInt(String.valueOf(move.charAt(1)))-1][(int) move.charAt(0) -97] = null;
                    }
                }else{
                    System.out.println("Invalid move. Please enter valid move");
                    continue;
                }
            }
            tt--;
        }
        chessBoard.printBoard();

    }
}