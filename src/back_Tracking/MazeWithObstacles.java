package back_Tracking;

import java.util.ArrayList;
import java.util.List;

public class MazeWithObstacles {
    public static void main(String[] args) {

        System.out.println(mazePathObstacle("",0,0,1,1));
        boolean[][] board = new boolean[][]{
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
        System.out.println(pathObstacles("",board,0,0));
        System.out.println(pathObstacles2("",board,0,0));
    }

    // When there is any obstacle in the cell
    //Here the logic is I'm going to the which are only true i.e not obstacles
    public static List<String> mazePathObstacle(String p,int row,int col,int orow,int ocol){ //orow and ocol are the col and row of the obstacle
        List<String> list = new ArrayList<>();
        if(row==2 && col==2){
            list.add(p);
            return list;
        }
        if(row<2 && !(col == ocol && row+1 == orow)){  // Checking we are not entering into the obstacle
            list.addAll(mazePathObstacle(p+'D',row+1,col,orow,ocol));
        }
        if(col<2 && !(col+1 == ocol && row==orow)){    // Checking we are not entering into the obstacle
            list.addAll(mazePathObstacle(p+'R',row,col+1,orow,ocol));
        }
        return list;
    }

    // If boolean maze is given i.e. in maze "false" means obstacle //Lets write the code
    public static List<String> pathObstacles(String p,boolean[][] maze,int row,int col){
        List<String> list = new ArrayList<>();

        if(row==maze.length-1 && col==maze[0].length-1){
            list.add(p);
            return list;
        }

        if(row<maze.length-1 && maze[row+1][col]){
            list.addAll(pathObstacles(p+'D',maze,row+1,col));
        }
        if(col<maze[0].length-1 && maze[row][col+1]){
            list.addAll(pathObstacles(p+'R',maze,row,col+1));
        }

        return list;
    }

    //Another possible code
    //Here I'm going to all possible cells and returning no path when it is obstacle cell
    public static List<String> pathObstacles2(String p,boolean[][] maze,int row,int col){
        List<String> list = new ArrayList<>();

        if(row==maze.length-1 && col==maze[0].length-1){
            list.add(p);
            return list;
        }
        if(!maze[row][col]){
           return null;
        }
        if(row<maze.length-1 ){
            list.addAll(pathObstacles(p+'D',maze,row+1,col));
        }
        if(col<maze[0].length-1){
            list.addAll(pathObstacles(p+'R',maze,row,col+1));
        }

        return list;
    }
}
