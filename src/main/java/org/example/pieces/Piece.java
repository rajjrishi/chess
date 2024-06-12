package org.example.pieces;

import lombok.Data;

@Data
public abstract class Piece {

    private String currentPosition;

    private boolean isWhite;

    abstract public boolean canMove(String targetPosition);
}
