package My_Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L210_CourseSchedule1_2 {

    static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[numCourses];
        int index = 0;
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge: prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        for(int i=0; i< numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans[index++] = node;

            for(Integer neighbour: graph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        return (index == numCourses)? ans : new int[0];
    }
}
