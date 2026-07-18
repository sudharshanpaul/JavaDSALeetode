package My_Graphs;

public class L733_FloodFill {

    static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int element = image[sr][sc];
        dfs(image, sr, sc, color, visited, element);

        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, boolean[][] visited, int element){
        if(sr <0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != element || visited[sr][sc]){
            return;
        }

        image[sr][sc] = color;
        visited[sr][sc] = true;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};

        for(int i= 0; i< 4; i++){
            int nsr = sr + dRow[i];
            int nsc = sc + dCol[i];
            dfs(image, nsr, nsc, color, visited, element);
        }
    }
}
