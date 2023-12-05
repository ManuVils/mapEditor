package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public class Grid {

    int totalSquares;
    int squareSize;
    int padding = 10;

    Rectangle individualSquares;

    ArrayList<Rectangle> squares = new ArrayList<>();

    public Grid (int totalSquares, int squareSize) {
        this.totalSquares = totalSquares;
        this.squareSize = squareSize;
    }


    public void createGrid() {

        int moveHorizontally = padding;
        int moveVertically = padding;

        for (int i = 1; i <= totalSquares; i++) {
            for (int j = 1; j <= totalSquares; j++) {
                individualSquares = new Rectangle(moveHorizontally, moveVertically, squareSize, squareSize);
                individualSquares.draw();
                moveHorizontally += squareSize;
                squares.add(individualSquares);
            }
            moveHorizontally = padding;
            moveVertically += squareSize;
        }
    }
}
