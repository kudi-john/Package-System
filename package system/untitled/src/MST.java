import java.util.*;

public class MST {
    public static class Connection{
        char firstTown;
        char secondTown;
        int cost;

        public Connection(char firstTown, char secondTown, int cost) {
            this.firstTown = firstTown;
            this.secondTown = secondTown;
            this.cost = cost;
        }
    }
    public static class Node{
        char town;
        int cost;
        Connection connection;
        public Node(char next, int cost, Connection connection) {
            this.town = next;
            this.cost = cost;
            this.connection = connection;
        }
    }
    public  static void  main(String[] args){
        List<Connection> connections = new ArrayList<>();
        connections.add(new Connection('A','B',1));
        connections.add(new Connection('B','C',4));
        connections.add(new Connection('B','D',6));

        connections.add(new Connection('D','E',5));
        connections.add(new Connection('C','E',1));
        connections.add(new Connection('D','F',7));
        List<Connection> res = findMinimumConnection(6,connections);
        for(int i=0;i<res.size();i++){
            Connection c = res.get(i);
            System.out.println(c.firstTown+" , " + c.secondTown+" , " + c.cost);
        }
    }
    public static List<Connection> findMinimumConnection(int num,  List<Connection> connections){
        List<Connection> res = new ArrayList<>();
        Map<Character,List<Node>> map = new HashMap<>();
        for(Connection connection  : connections){
            char first  =  connection.firstTown;
            char second = connection.secondTown;
            int cost = connection.cost;
            map.putIfAbsent(first,new ArrayList<>());
            map.get(first).add(new Node(second,cost,connection));
            map.putIfAbsent(second,new ArrayList<>());
            map.get(second).add(new Node(first,cost,connection));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        Set<Character> visited = new HashSet<>();
        int numOfServers = 0;
        char startTown  = connections.get(0).firstTown;
        pq.offer(new Node(startTown,0,new Connection(startTown,startTown,0)));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            char curTown = cur.town;
            if(visited.contains(curTown)) continue;
            visited.add(curTown);
            numOfServers++;

            if(cur.town != startTown)res.add(cur.connection);
            for(Node next : map.get(curTown)){
                pq.offer(next);
            }
            if(numOfServers == num){
                return res;
            }
        }
        return new ArrayList<>();
    }
}
