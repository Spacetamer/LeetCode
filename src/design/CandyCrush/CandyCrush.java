package design.CandyCrush;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

enum direction
{
    RIGHT(0,1),
    LEFT(0,-1),
    TOP(-1,0),
    BOTTOM(1,0);


    int row ,col;
    direction(int row,int col)
    {
        this.row = row;
        this.col = col;
    }
}

public class CandyCrush {

    private static final direction[][] hops = {
            {direction.TOP,direction.RIGHT,direction.RIGHT},
            {direction.TOP,direction.LEFT,direction.LEFT},
            {direction.TOP,direction.TOP,direction.TOP},
            {direction.BOTTOM,direction.RIGHT,direction.RIGHT},
            {direction.BOTTOM,direction.LEFT,direction.LEFT},
            {direction.BOTTOM,direction.BOTTOM,direction.BOTTOM},
            {direction.RIGHT,direction.RIGHT,direction.RIGHT},
            {direction.RIGHT,direction.TOP,direction.TOP},
            {direction.RIGHT,direction.BOTTOM,direction.BOTTOM},
            {direction.LEFT,direction.LEFT,direction.LEFT},
            {direction.LEFT,direction.TOP,direction.TOP},
            {direction.LEFT,direction.BOTTOM,direction.BOTTOM},
    };

    private static final int count = 7;
    /* board */
    private static int [][] matrix = new int [count][count];

    /* candies */
    private static int []candies = {1,2,3,4,5,6,7,8,9};

    /* to pick random candy or random hop */
    private static Random rand = new Random();


    /*  check 2 adjacent elements */
    private static final int checkMatrix [][][] = {
            {{0,-1},{0,-2}},
            {{0,-1},{0,1}},
            {{0,1},{0,2}},
            {{-1,0},{-2,0}},
            {{-1,0},{1,0}},
            {{1,0},{2,0}}
    };




    public static void main(String []args)
    {

        Set<Integer> set = new HashSet<Integer>();

        /** No of possible candy crush swaps */
        int initCrushCount = 10;
        boolean flag = false;
        for(int i=0;i<initCrushCount;i++)
        {
            flag = false;
            while(!flag)
            {
                /* choose a random candy */
                int candy = candies[rand.nextInt(candies.length)];

                /* choose a random index */
                int index = rand.nextInt(count*count);

                int row = index/count;
                int col =  (index)%count;

                /* choose a random hop */
                for(int k=0;k<hops.length;k++)
                {
                    if(set.contains(row*count+col))
                        continue;

                    matrix[row][col] = candy;
                    int ra =rand.nextInt(hops.length);
                    direction []temp = hops[ra];
                    flag = setCrushable(set, row, col , candy, 0 ,temp,true,initCrushCount);
                    if(!flag)
                        matrix[row][col]=0;
                    else
                    {
                        set.add(index);
                        break;
                    }
                }
            }
        }


        printMatrix();

        System.out.println("\n");

        for(int i=0;i<count;i++)
        {

            for(int j=0;j<count;j++)
            {
                populateMatrix(candies,set,i,j);
            }
        }

        printMatrix();

    }

    private static void printMatrix()
    {
        /* print matrix */
        for(int i=0;i<count;i++)
        {
            System.out.println();
            for(int j=0;j<count;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
        }
    }


    private static boolean setCrushable(Set<Integer> set, int row, int col,
                                        int candy, int i, direction[] temp, boolean start, int crushCount) {

        if(i>=3)
        {
            return true;
        }
        row = row+temp[i].row;
        col = col+temp[i].col;
        if(bound(row,col) && !set.contains(row*count+col) && !candyCrush(candy,row,col) )
        {
            if(!start)
            {
                matrix[row][col] = candy;
            }
            if(!setCrushable(set, row, col , candy, i+1 ,temp,false,crushCount)){
                matrix[row][col]=0;}
            else
            {

                set.add(row*count+col);
                return true;
            }

        }

        return false;

    }




    private static boolean bound(int row, int col) {
        if(row<0 || row>=count || col<0 ||col>=count)
            return false;
		else
            return true;
    }

    public static void populateMatrix(int []candies,Set<Integer> set, int row, int col)
    {
        int index = row*count+col;
        if(!bound(row,col) || set.contains(index))
            return;

        for(int i=0;i<candies.length;i++)
        {
            int candy = candies[rand.nextInt(candies.length)];

            /* if candies dont matcf with adjacent candies fix candy position */
            if(!candyCrush(candy,row,col) )
            {
                matrix[row][col] = candy;
                set.add(index);
                break;
            }

        }


        //	populateMatrix(candies,set, row,col+1);
        populateMatrix(candies,set, row,col-1);
        populateMatrix(candies,set, row-1,col);
        //	populateMatrix(candies,set, row+1,col);

    }
    /* check if there is a 3 candy match */
    private static boolean candyCrush(int candy, int row, int col) {
        boolean candyCrush;

        for(int i=0;i<checkMatrix.length;i++)
        {
            candyCrush =true;

            for(int j =0;j<checkMatrix[0].length;j++)
            {
                candyCrush = candyCrush && equalCandy(candy , row+checkMatrix[i][j][0], col+checkMatrix[i][j][1]);
            }
            if(candyCrush)
                return true;
        }
        return false;
    }


    private static boolean equalCandy(int candy, int i, int j) {
        if(!bound(i,j) || matrix[i][j] != candy)
            return false;
        else
            return true;
    }
}