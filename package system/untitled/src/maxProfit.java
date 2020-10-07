import java.util.*;

public class maxProfit {
    public  static void  main(String[] args){
        List<Integer> inventory  = new ArrayList<>(Arrays.asList(3,5));
        System.out.println(getMaxProfit(2,inventory,6));
    }
    public static int getMaxProfit(int numSuppliers, List<Integer> inventory, int order){
        Map<Integer,Integer> map = new HashMap<>();
        int maxNum = 0;
        int res = 0;
        for(int i : inventory){
            maxNum = Math.max(maxNum,i);
            map.put(i,map.getOrDefault(i,0)+1);
        }
        while(order-- > 0){
            res += maxNum;
            map.put(maxNum,map.get(maxNum)-1);
            map.put(maxNum-1,map.getOrDefault(maxNum-1,0)+1);
            if(map.get(maxNum) == 0) {
                map.remove(maxNum);
                maxNum--;
            }
        }
        return res;
    }
}
