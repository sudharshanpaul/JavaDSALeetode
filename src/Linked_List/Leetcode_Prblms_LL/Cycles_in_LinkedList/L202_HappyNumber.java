package Linked_List.Leetcode_Prblms_LL.Cycles_in_LinkedList;

public class L202_HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = findDigitsSquare(slow);
            fast = findDigitsSquare(findDigitsSquare(fast));
            if(fast == slow && fast!=1){
                return false;
            }
        }while (slow != 1 && fast != 1);
        return true;
    }

    public static int findDigitsSquare(int n){
        int num = 0;
        while(n != 0){
            num += (n%10)*(n%10);
            n /= 10;
        }
        return num;
    }
}
