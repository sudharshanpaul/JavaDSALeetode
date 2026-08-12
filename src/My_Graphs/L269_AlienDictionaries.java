package My_Graphs;

import java.util.*;

public class L269_AlienDictionaries {

    static void main(String[] args) {

    }

    public String findOrder(String[] words) {
        // code here
        List<List<Character>> graph = new ArrayList<>();
        for(int i=0; i< 26; i++){
            graph.add(new ArrayList<Character>());
        }
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);

        int totalCharacters = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (indegree[ch - 'a'] == -1) {
                    indegree[ch - 'a'] = 0;
                    totalCharacters++;
                }
            }
        }

        // abc comes first than ab -> this is invalid
        if(createEdges(words, graph, indegree)){
            return "";
        }

        StringBuffer ans = new StringBuffer();
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i< 26; i++){
            if(indegree[i] == 0){
                Character ch = (char)('a' + i);
                queue.offer(ch);
            }
        }

        while(!queue.isEmpty()){
            char node = queue.poll();
            ans.append(node);
            for(char nei: graph.get(node - 'a')){
                if(--indegree[nei - 'a'] == 0){
                    queue.offer(nei);
                }
            }
        }

        return (totalCharacters == ans.length())?ans.toString():"";
    }

    public boolean createEdges(String[] words, List<List<Character>> graph, int[] indegree){
        for(int i=0; i<words.length-1; i++){

            int minLength = Math.min(words[i].length(), words[i+1].length());
            boolean check = true;

            for(int j=0; j<minLength; j++){
                char u = words[i].charAt(j);
                char v = words[i+1].charAt(j);

                if(u != v){
                    graph.get(u - 'a').add(v);
                    indegree[v - 'a']++;
                    check = false;
                    break;
                }
            }
            if (check && words[i].length() > words[i + 1].length()) {
                return true;
            }
        }

        return false;
    }
}
