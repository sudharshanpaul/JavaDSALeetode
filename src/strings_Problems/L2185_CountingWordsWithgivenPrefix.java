package strings_Problems;

public class L2185_CountingWordsWithgivenPrefix {

    public static void main(String[] args) {

        String[] words = {"pay","attention","practice","attend"};
        System.out.println(prefixCount(words,"at"));

    }

    // https://leetcode.com/problems/counting-words-with-a-given-prefix/?envType=daily-question&envId=2025-01-09
    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String str:words){
            if(str.startsWith(pref)){
                count++;
            }
        }
        return count;
    }

}
