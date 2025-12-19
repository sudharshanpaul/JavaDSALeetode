package bitManipulation;

public class XOR_in_Range {

    public static void main(String[] args) {
        System.out.println(xor1toN(11));

        System.out.println(xor_Range(4, 8));
    }


    public static int xor_Range(int start, int end){
        return xor1toN(start - 1) ^ xor1toN(end);
    }

    // XOR from 1 to N
    public static int xor1toN(int num){
        if(num % 4 == 0){
            return num;
        }else if(num % 4 == 1){
            return 1;
        }else if(num % 4 == 2){
            return num+1;
        }
        return 0;
    }
}
