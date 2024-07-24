package back_Tracking;

import java.util.List;
import java.util.ArrayList;

public class My_MazeSolver {
    public static void main(String[] args) {

        System.out.println(mazeSolverPaths("",2,2));
        System.out.println(mazePathCount(2,2));
        System.out.println(mazeSolverPaths2("",2,2));
        System.out.println(mazeSolverDiagonalIncluded("",2,2));
        System.out.println(mazePathCountDiagonalIncluded(2,2));

    }

    public static List<String> mazeSolverPaths(String p,int down,int right){
        List<String> list = new ArrayList<>();

        if(down == 0 && right==0){
            list.add(p);
            return list;
        }

        if(down == 0){
            list.addAll(mazeSolverPaths(p+'R',down,right-1));
        } else if(right==0){
            list.addAll(mazeSolverPaths(p+'D',down-1,right));
        }else{
            list.addAll(mazeSolverPaths(p+'R',down,right-1));
            list.addAll(mazeSolverPaths(p+'D',down-1,right));
        }

        return list;
    }

    public static int mazePathCount(int down,int right){
        int count=0;
        if(down==0 && right==0){
            return 1;
        }
        if(down==0){
            count+=mazePathCount(down,right-1);
        }else if(right==0){
            count+=mazePathCount(down-1,right);
        }else{
            count+=mazePathCount(down-1,right);
            count+=mazePathCount(down,right-1);
        }
        return count;
    }
    //Counting Paths... some what easy one
    public static int mazePathCount2(int row,int col){
        if(row==0 || col==0){
            return 1;
        }
        int left = mazePathCount2(row-1,col);
        int right = mazePathCount2(row,col-1);

        return left+right;
    }
    //Possible paths for reaching (0,0) or the destination

    public static List<String> mazeSolverPaths2(String p,int row,int col){
        List<String> list = new ArrayList<>();
        if(row==0 && col==0){
            list.add(p);
            return list;
        }

        if(row>0){
            list.addAll(mazeSolverPaths2(p+'D',row-1,col));
        }
        if(col>0){
            list.addAll(mazeSolverPaths2(p+'R',row,col-1));
        }

        return list;
    }

    public static List<String> mazeSolverDiagonalIncluded(String p,int row,int col){
        List<String> list = new ArrayList<>();
        if(row==0 && col==0){
            list.add(p);
        }
        if(row>0 && col>0){ //Here I'm moving diagonally
            list.addAll(mazeSolverDiagonalIncluded(p+'X',row-1,col-1));
        }
        if(row>0){
            list.addAll(mazeSolverDiagonalIncluded(p+'D',row-1,col));
        }
        if(col>0){
            list.addAll(mazeSolverDiagonalIncluded(p+'R',row,col-1));
        }
        return list;
    }

    public static int mazePathCountDiagonalIncluded(int row,int col){
        int count = 0;
        if(row==0 && col==0){
            return 1;
        }
        if(row>0 && col>0){
            count+= mazePathCountDiagonalIncluded(row-1,col-1);
        }
        if(row>0){
            count+=mazePathCountDiagonalIncluded(row-1,col);
        }
        if(col>0){
            count+=mazePathCountDiagonalIncluded(row,col-1);
        }
        return count;
    }
}
