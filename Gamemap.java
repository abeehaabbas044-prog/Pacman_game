package com.pacman.map;

public class Gamemap
{
    private int[][] grid;
    public Gamemap()
    {
        grid=new int[][]{
                {1,1,1,1,1},
                {1,0,0,2,1},
                {1,0,1,2,1},
                {1,0,2,0,1},
                {1,1,1,1,1}
        };
    }
    public boolean iswall(int x,int y)
    {
        return grid[y][x]==1;
    }
    public boolean isfood(int x,int y)
    {
        return grid[y][x]==2;
    }
    public void removeFood(int x, int y)
    {
        grid[y][x] = 0;
    }
    public boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 &&
                y < grid.length &&
                x < grid[0].length;
    }

    public void printMap() {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


}
