package My_Trees.leetcode_problems.BFS;

import java.util.*;

public class L127_WordLadder {

    static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        int ans = 1;
        queue.offer(beginWord);

        if(set.contains(beginWord)){
            set.remove(beginWord);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                String word = queue.poll();
                List<String> match = findShorterString(word, set);
                if(match.isEmpty()){
                    continue;
                }
                for(int j = 0; j<match.size(); j++){
                    if(match.get(j).equals(endWord)){
                        return ans+1;
                    }
                    queue.offer(match.get(j));
                    set.remove(match.get(j));
                }
            }
            ans++;
        }
        return 0;
    }

    public List<String> findShorterString(String str, Set<String> set) {
        List<String> ans = new ArrayList<>();

        char[] word = str.toCharArray();

        for (int i = 0; i < word.length; i++) {
            char original = word[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {

                if (ch == original) continue;

                word[i] = ch;

                String newWord = new String(word);

                if (set.contains(newWord)) {
                    ans.add(newWord);
                }
            }

            word[i] = original; // Restore original character
        }

        return ans;
    }

    // public List<String> findShorterString(String str, List<String> list){
    //     List<String> ans = new ArrayList<>();

    //     for(int i=0; i<list.size(); i++){
    //         int differ = 0;
    //         for(int j=0; j<list.get(i).length(); j++){
    //             if(str.charAt(j) != list.get(i).charAt(j)){
    //                 differ++;
    //             }
    //         }
    //         if(differ == 1){
    //             ans.add(list.get(i));
    //         }
    //     }

    //     return ans;
    // }
}
