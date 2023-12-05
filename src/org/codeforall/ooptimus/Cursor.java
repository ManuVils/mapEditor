package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.HashMap;

public class Cursor implements KeyboardHandler {

    private Grid grid;

    Rectangle cursor;

    HashMap<Rectangle, Boolean> paintedSquares;


    boolean isFilled;



    public Cursor(Grid grid) {
        this.grid = grid;
    }

    public void createCursor() {

        cursor = new Rectangle(10, 10, grid.squareSize, grid.squareSize);
        cursor.setColor(Color.BLUE);
        cursor.fill();
    }

    public void addPaintedSquareAndBoolean (Rectangle i) {
        paintedSquares = new HashMap<>();
        paintedSquares.put(i, !isFilled);
    }

    public void removePaintedSquareAndBoolean (Rectangle i) {
        paintedSquares = new HashMap<>();
        paintedSquares.remove(i, isFilled);
    }


    public void setup() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(space);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (cursor.getY() <= 10) {
                    cursor.translate(0, 0);
                } else {
                    cursor.translate(0, -grid.squareSize);
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (cursor.getY() >= (grid.squareSize * grid.totalSquares) - grid.squareSize) {
                    cursor.translate(0, 0);
                } else {
                    cursor.translate(0, grid.squareSize);

                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (cursor.getX() <= 10) {
                    cursor.translate(0, 0);
                } else {
                    cursor.translate(-grid.squareSize, 0);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (cursor.getX() >= (grid.squareSize * grid.totalSquares) - grid.squareSize) {
                    cursor.translate(0, 0);
                } else {
                    cursor.translate(grid.squareSize, 0);
                }
                break;
            case KeyboardEvent.KEY_SPACE:


                for (int i = 0; i < grid.squares.size(); i++) {
                    if (cursor.getX() == grid.squares.get(i).getX() && cursor.getY() == grid.squares.get(i).getY()) {

                        if (!grid.squares.get(i).isFilled()) {

                            grid.squares.get(i).setColor(Color.RED);
                            grid.squares.get(i).fill();


                        } else {

                            grid.squares.get(i).setColor(Color.BLACK);
                            grid.squares.get(i).draw();


                        }
                    }
                }

                break;

                        }
                    }





    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
