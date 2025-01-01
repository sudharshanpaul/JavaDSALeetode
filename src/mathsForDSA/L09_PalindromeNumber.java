package mathsForDSA;

public class L09_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome1(121));
    }
    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        StringBuilder str1 = new StringBuilder(str);
        str1.reverse();
        if(str.contentEquals(str1)){
            return true;
        }
        return false;
    }
    public static boolean isPalindrome1(int x) {
        int num = 0;
        int dup = x;
        if(x<0){
            return false;
        }
        while(x != 0){
            num = num*10 + x%10;
            x/=10;
        }

        if(num == dup){
            return true;
        }
        return false;

    }
}
