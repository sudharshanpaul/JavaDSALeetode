package back_Tracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Maze_AllPaths {
    public static void main(String[] args) {

        boolean[][] board = new boolean[][]{
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        System.out.println(allPathsRet("",board,0,0));
        System.out.println(allLengths(0,board,0,0));
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("",board,0,0,path,1);


    }
    //If we are given all possible directions to move if we try to implement this in this way
    //it is incorrect because we'll reach initial position infinite number of times so it
    //gives stack out of memory because of infinite number of loops
    public static void allPaths(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            allPaths(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            allPaths(p+'R',maze,r,c+1);
        }
        if(r>0){
            allPaths(p+'U',maze,r-1,c);
        }
        if(c>0){
            allPaths(p+'L',maze,r,c-1);
        }
    }

    //Here we are getting the problem because we are moving to the cells that we are came from in that path
    //So one possible approach is make the cells false that we are visited so that we won't go  back

    //This is called back tracking means while we are going back or returning "Change the changes that we did in that call"

    public static List<String> allPathsRet(String p, boolean[][] maze, int r, int c){

        List<String> list = new ArrayList<>();

        if(r==maze.length-1 && c==maze[0].length-1){
            list.add(p);
            return list;
        }

        if(!maze[r][c]){
            return new ArrayList<String>();
        }

        maze[r][c] = false; //marking the cell as visited
        //Marking the cell false means that cell is already in my path

        if(r<maze.length-1){
            list.addAll(allPathsRet(p+'D',maze,r+1,c));
        }
        if(c<maze[0].length-1){
            list.addAll(allPathsRet(p+'R',maze,r,c+1));
        }
        if(r>0){
            list.addAll(allPathsRet(p+'U',maze,r-1,c));
        }
        if(c>0){
            list.addAll(allPathsRet(p+'L',maze,r,c-1));
        }

        maze[r][c] = true;  //unmarking it because as the arrays are passes a object references original array if modified in function calls
        //Because original array is modified so it may cause problem for next recursive calls
        //While you are moving back we have to restore (or unmark it)that maze as before it...So remove the changes

        return list;
    }

    //Here the task is returning the list of all length of all possible paths
    public static List<Integer> allLengths(int count,boolean[][] maze,int r,int c){
        List<Integer> list = new ArrayList<>();
        if(r== maze.length-1 && c==maze[0].length-1){
            list.add(count);
            return list;
        }
        if(!maze[r][c]){
            return new ArrayList<>();
        }
        maze[r][c] = false;
        if(r<maze.length-1){
            list.addAll(allLengths(count+1,maze,r+1,c));
        }
        if(c<maze.length-1){
            list.addAll(allLengths(count+1,maze,r,c+1));
        }
        if(r>0){
            list.addAll(allLengths(count+1,maze,r-1,c));
        }
        if(c>0){
            list.addAll(allLengths(count+1,maze,r,c-1));
        }
        maze[r][c] = true;
        return list;
    }

    //Here the task is we are printing the array in which we took the steps to reach the target and the path we went
    //Better to run this code you'll understand the task properly
    public static void allPathPrint(String p,boolean[][] maze,int r,int c,int[][] path,int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c] = step;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            path[r][c] = 0;
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;

        if(r<maze.length-1){
            allPathPrint(p+'D',maze,r+1,c,path,step+1);
        }
        if(c<maze.length-1){
            allPathPrint(p+'R',maze,r,c+1,path,step+1);
        }
        if(r>0){
            allPathPrint(p+'U',maze,r-1,c,path,step+1);
        }
        if(c>0){
            allPathPrint(p+'L',maze,r,c-1,path,step+1);
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
