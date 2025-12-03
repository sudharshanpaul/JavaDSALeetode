package bitManipulation.leecodeProblems;

public class L2220_MinBitFlip   {

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
    }

    public static int minBitFlips(int start, int goal) {
        return findNoOs1(start ^ goal);
    }

    public static int findNoOs1(int num){
        int ans = 0;
        while(num != 0){
            ans++;
            num = num & (num-1);
        }
        return ans;
    }

    // Brute Force Algorithm

    public int bruteForce(int start, int goal) {
        int ans = 0;
        String large = "";
        String small = "";
        if(start > goal){
            large = findBinary(start);
            small = findBinary(goal);
        }else{
            small = findBinary(start);
            large = findBinary(goal);
        }
        int i;
        for(i=0; i<small.length(); i++){
            if(large.charAt(large.length()-i-1) != small.charAt(small.length()-i-1)){
                ans++;
            }
        }
        for(i=small.length(); i<large.length(); i++){
            if(large.charAt(large.length()-i-1)=='1'){
                ans++;
            }
        }

        return ans;

    }

    public String findBinary(int num){
        if(num == 0){
            return new String("0");
        }
        StringBuilder str = new StringBuilder();
        while(num > 1){
            if((num & 1) == 0){
                str.append('0');
            }else{
                str.append('1');
            }
            num = num >> 1;
        }
        str.append(1);
        return str.reverse().toString();
    }
}
