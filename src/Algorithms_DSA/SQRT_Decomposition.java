package Algorithms_DSA;

import java.util.Arrays;

public class SQRT_Decomposition {

    static void main(String[] args) {
        int[] arr = new int[]{1, 3,5, 2, 7, 6, 3, 1, 4, 8};
        int sqrt = (int) Math.sqrt(arr.length);
        int[] blocks = new int[sqrt + 1];

        int block_id = -1;

        for(int i=0; i< arr.length; i++){
            if(i % sqrt == 0){
                block_id++;
            }
            blocks[block_id] += arr[i];
        }

        System.out.println(Arrays.toString(blocks));
        System.out.println(query(arr, blocks, 2, 8, sqrt));

    }

    public static int query(int[] arr, int[] blocks, int left, int right, int sqrt){
        int ans = 0;

        while(left % sqrt != 0 && left <= right){
            // left portion
            ans += arr[left++];
        }

        while(left + sqrt <= right){
            ans += blocks[left / sqrt];
            left += sqrt;
        }

        //Right portions
        while(left <= right){
            ans += arr[left++];
        }

        return ans;
    }

    public static void update(int[] arr, int[] blocks, int position, int element, int sqrt){
        int block_id = position / sqrt;
        blocks[block_id] = blocks[block_id] - arr[position] + element;
        arr[position] = element;
    }
}
