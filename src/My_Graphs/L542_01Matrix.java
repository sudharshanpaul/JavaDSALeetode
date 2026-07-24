package My_Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class L542_01Matrix {

    static void main(String[] args) {

    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    // ans[i][j] = 0;
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int dist = node[2];


            for(int i=0; i<4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >=0 && nCol >=0 && nRow < mat.length && nCol < mat[0].length && !visited[nRow][nCol]){
                    queue.offer(new int[]{nRow, nCol, dist+1});
                    visited[nRow][nCol] = true;
                    ans[nRow][nCol] = dist+1;
                }
            }
        }

        return ans;

    }
}
