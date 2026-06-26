package com.pacman.ghost;

import com.pacman.map.Gamemap;
import java.util.Random;

public class Ghost {

    private int x;
    private int y;
    private Gamemap map;
    private Random rand;

    public Ghost(int x, int y, Gamemap map) {
        this.x = x;
        this.y = y;
        this.map = map;
        this.rand = new Random();
    }

    public void update()
    {
        randomMove();
    }

    private void randomMove() {
        int direction = rand.nextInt(4);

        int newX = x;
        int newY = y;

        if (direction == 0)
            newX++;
        else if (direction == 1)
            newX--;
        else if (direction == 2)
            newY++;
        else if (direction == 3)
            newY--;

        if (map.isValid(newX, newY) && !map.iswall(newX, newY))
        {
            x = newX;
            y = newY;
        }
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}