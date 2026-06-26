package com.pacman.person;
import com.pacman.map.Gamemap;
public class Pacman
{
    private int x;
    private int y;
    private Gamemap map;
    private int score=0;
    public Pacman(int x,int y,Gamemap map)
    {
        this.x=x;
        this.y=y;
        this.map=map;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void Direction(char direction)
    {
        int y2=y;
        int x2=x;
        switch(direction)
        {
            case '^':
                y2++;
                break;
            case 'v':
                y2--;
                break;
            case '>':
                x2++;
                break;
            case '<':
                x2--;
                break;
            default:
                System.out.println("Invalid choice.");
        }
        if (map.isValid(x2, y2) && !map.iswall(x2, y2))
        {
            x = x2;
            y = y2;
            if (map.isfood(x, y)) {
                score++; // increase point
                System.out.println("Food eaten! Score = " + score);
                map.removeFood(x,y);
            } else {
                System.out.println("Moved to (" + x + "," + y + ")");
            }
        }
        else
        {
            System.out.println("Wall! Can't move.");
        }


    }
}
