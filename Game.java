package com.pacman.main;
import com.pacman.ghost.Ghost;
import com.pacman.map.Gamemap;
import com.pacman.person.Pacman;

import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
        Gamemap gm=new Gamemap();
        gm.printMap();
        System.out.println("Game started!(*_*)");
        Ghost ghost1 = new Ghost(2, 3, gm);
        Ghost ghost2 = new Ghost(1, 4, gm);
        Pacman p=new Pacman(1,1,gm);
        Scanner sc=new Scanner(System.in);

        while (true)
        {
            if (ghost1.getX() == p.getX() && ghost1.getY() == p.getY()
                    || ghost2.getX() == p.getX() && ghost2.getY() == p.getY())
            {
                System.out.println("Game Over!(ghost collides)");
                break;
            }
            ghost1.update();
            ghost2.update();
            System.out.println("Move (<,>,^,v) or q to quit:");
            char move = sc.next().charAt(0);
            if (move == 'q') {
                System.out.println("Game Over!");
                break;
            }
            p.Direction(move);
            if (ghost1.getX() == p.getX() && ghost1.getY() == p.getY()
                    || ghost2.getX() == p.getX() && ghost2.getY() == p.getY())
            {
                System.out.println("Game Over!(ghost collides)");
                break;
            }
            ghost1.update();
            ghost2.update();
            double distance1 = Math.sqrt(
                    Math.pow(ghost1.getX() - p.getX(), 2) +
                            Math.pow(ghost1.getY() - p.getY(), 2)
            );

            double distance2 = Math.sqrt(
                    Math.pow(ghost2.getX() - p.getX(), 2) +
                            Math.pow(ghost2.getY() - p.getY(), 2)
            );
            System.out.printf("Ghost1 Distance: %.2f\n", distance1);
            System.out.printf("Ghost2 Distance: %.2f\n", distance2);
        }
        System.out.println("Thanks for playing Pacman!");
    }
}
