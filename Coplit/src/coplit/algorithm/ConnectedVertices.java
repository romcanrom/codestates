package coplit.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedVertices {
    public static void main(String[] args) {

    }

    public int connectedVertices(int[][] edges){

        //입력받은 배열 중 요소의 최댓값 구하기
        final int[] bigger = {0};

        Arrays.stream(edges).forEach(data -> {
            int currentBigger = Arrays.stream(data)
                    .boxed()
                    .max(Comparator.comparing(i->i))
                    .orElse(0);
            if(bigger[0]<currentBigger) bigger[0] = currentBigger;
        });

        //요소의 최댓값만한 크기로 인접행렬을 만든다
        int[][] adjArray = new int [bigger[0]+1][bigger[0]+1];

        for(int i=0; i<edges.length; i++){
            adjArray[edges[i][0]][edges[i][1]] = 1;
            adjArray[edges[i][1]][edges[i][0]] = 1;
        }

        //방문 여부를 검증할 boolean 배열 생성
        //연결이 이미 되어있다면 visited=true
        boolean[] visited = new boolean[bigger[0]+1];
        //그룹 수 체크할 count 변수
        int count = 0;

        //visited 배열만 체크함
        for(int vertex = 0; vertex < visited.length; vertex++){
            if(!visited[vertex]){
                count++;
                visited = bfs_array(adjArray, vertex, visited);
            }
        }
        return count;
    }

    //bfs - 너비 우선
    public boolean[] bfs_array(int[][] adjArray, int vertex, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();

        //큐에 현재 정점을 넣어주고
        queue.add(vertex);
        //임의로 값을 ture로 준다
        visited[vertex] = true;

        //큐가 빌때까지 계속
        while(!queue.isEmpty()){
            //큐에 있던 현재 정점을 cur에 할당
            int cur = queue.poll();
            //인접 행렬의 길이만큼 반복
            for(int i=0; i<adjArray.length; i++){
                //현재 정점이 정점 i와 연결되어 있고 방문한 적이 없다면
                if(adjArray[cur][i]==1 && !visited[i]){
                    //큐에 i를 더해주고 방문했다고 표시하기
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return visited;
    }

    //dfs - 깊이 우선
    public boolean[] dfs_array(int[][] adjArray, int vertex, boolean[] visited){
        visited[vertex] = true;

        for(int i=0; i<adjArray.length; i++){
            //정점 vertex가 정점 i와 연결되었고 방문하지 않았다면
            if(adjArray[vertex][i]==1 && !visited[i]){
                //재귀
                dfs_array(adjArray, i, visited);
            }
        }
        return visited;
    }
}
