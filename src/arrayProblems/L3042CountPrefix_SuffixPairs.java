package arrayProblems;

public class L3042CountPrefix_SuffixPairs {

    public static void main(String[] args) {

        String[] words = {"pa","papa","ma","mama"};
        System.out.println(countPrefixSuffixPairs(words));

    }

    // https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/?envType=daily-question&envId=2025-01-08

    public static  int countPrefixSuffixPairs(String[] words) {

        int count = 0;
        for(int i=0; i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i],words[j])){
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPrefixAndSuffix(String i, String j){
        return (j.startsWith(i) && j.endsWith(i));

    }

}
