package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start){
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, adjacentDistance, distance;
        String current, adjacent;
        HashMap<String, Integer> distances = new HashMap<>();

        for(String key : graph.keySet()){
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(distances.get(start), start));

        while(priorityQueue.size() > 0){
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            current = edgeNode.vertex;

            if(distances.get(current) < currentDistance){
                continue;
            }

            nodeList = graph.get(current);
            for(int i=0; i<nodeList.size(); i++){
                adjacentNode = nodeList.get(i);
                adjacentDistance = adjacentNode.distance;
                adjacent = adjacentNode.vertex;
                distance = currentDistance + adjacentDistance;

                if(distance < distances.get(adjacent)){
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        DijkstraPath dObject = new DijkstraPath();

        // PriorityQueue 사용해보기
        // PriorityQueue는 맨 앞에 pop할 객체는 무조건 최소값으로 정렬
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(2, "A"));
        priorityQueue.add(new Edge(5, "B"));
        priorityQueue.offer(new Edge(1, "C"));
        priorityQueue.offer(new Edge(7 ,"D"));

        System.out.println(priorityQueue);
        priorityQueue.peek();               // peek은 priorityQueue 객체가 삭제는 되지 않음

        Edge edge1 = priorityQueue.poll();  // poll은 priorityQueue 객체 가져오면서 삭제됨
        System.out.println("poll 한 Edge => " + edge1);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.size());
        System.out.println("\n---------------------------\n");

        // HashMap 구현
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        for(String key : graph.keySet()){
            System.out.println(key);
            System.out.println(graph.get(key));
        }
        System.out.println("\n---------------------------\n");


        HashMap<String, Integer> distances = dObject.dijkstraFunc(graph, "A");
        System.out.println(distances);

    }


}
