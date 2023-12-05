package org.codeforall.ooptimus;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(20, 20);
        grid.createGrid();

        Cursor cursor = new Cursor(grid);
        cursor.createCursor();
        cursor.setup();


    }
}