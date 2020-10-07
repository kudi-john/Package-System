import java.util.*;

public class CitadelUnallottedUsers {
    public  static void  main(String[] args){
        List<List<Integer>> bids = new ArrayList<>();
        bids.add(new ArrayList<>(Arrays.asList(1,3,1,9866)));
        bids.add(new ArrayList<>(Arrays.asList(2,1,2,5258)));
        bids.add(new ArrayList<>(Arrays.asList(3,2,4,5788)));
        bids.add(new ArrayList<>(Arrays.asList(4,2,4,6536)));
        List<Integer> res = counter(bids,2);
        for(int r : res){
            System.out.println(r);
        }

    }
    public static List<Integer> counter(List<List<Integer>> bids, int totalShares) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->b.get(2) == a.get(2) ? a.get(3)-b.get(3) : b.get(2) - a.get(2));
        for(List<Integer> bid : bids){
            pq.offer(bid);
        }
        List<List<Integer>> temp =  new ArrayList<>();
        while(!pq.isEmpty() && totalShares > 0){
            List<Integer> cur = pq.poll();
            int shares = cur.get(1);

            temp.add(cur);
            while(!pq.isEmpty() && pq.peek().get(1) == shares){
                temp.add(pq.poll());
            }
            for(List<Integer> t : temp){
                t.set(1,shares-1);
                if(t.get(1) > 0){
                    pq.offer(t);
                }
            }
            totalShares--;
            temp = new ArrayList<>();
        }
        while(!pq.isEmpty()){
            res.add(pq.poll().get(0));
        }
        Collections.sort(res);
        return res;
    }

}
