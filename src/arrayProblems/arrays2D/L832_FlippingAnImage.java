package arrayProblems.arrays2D;

import java.util.Arrays;

public class L832_FlippingAnImage {

    public static void main(String[] args) {
        int[][] image = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        int[][] ans = flipAndInvertImage1(image);
        for(int[] arr:ans){
            System.out.println(Arrays.toString(arr));
        }
    }

    // https://leetcode.com/problems/flipping-an-image/?envType=problem-list-v2&envId=matrix
    public static int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length/2;j++){
                swap(image,i,j,image[0].length-1-j);
            }
        }
        for(int i=0;i< image.length;i++){
            for(int j=0;j<image[0].length;j++){
                image[i][j] = (image[i][j] == 0)?1:0;
            }
        }
        return image;
    }

    public static int[][] flipAndInvertImage1(int[][] image){
        for(int i=0;i<image.length;i++){
            for(int j=0;j<(image[0].length+1)/2;j++){
                int temp = image[i][j];
                image[i][j] = (image[i][image.length-1-j] + 1)%2;
                image[i][image.length-1-j] = (temp + 1)%2;
            }
        }
        return image;
    }

    public static void swap(int[][] image, int row, int col1, int col2){
        int temp = image[row][col1];
        image[row][col1] = image[row][col2];
        image[row][col2] = temp;
    }

}
