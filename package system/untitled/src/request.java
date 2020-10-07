import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class request {
    public  static void  main(String[] args){
        List<Integer> inventory  = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7));
        List<List<Integer>> after = new ArrayList<>();
        after.add(new ArrayList<>(Arrays.asList(1,2)));
        after.add(new ArrayList<>(Arrays.asList(3,4)));
        System.out.print(findBeforeMatrix(after));
      //  System.out.print(requesr(21,inventory));

    }
    public static int requesr(int n, List<Integer> request){
        int onesecond=0;
        int tensecond=0;
        int minute=0;
        int num=0;
        for(int i=0;i<n;i++){
            int curtime=request.get(i);
            while(request.get(onesecond)!=curtime){
                onesecond++;
            }
            while(request.get(tensecond)<(Math.max(1,curtime-9))){
                tensecond++;
            }
            while(request.get(minute)<(Math.max(1,curtime-59))){
                minute++;
            }
            //test
            if((i-onesecond+1)>3||(i-tensecond+1)>20||(i-minute+1)>60){
                num++;
            }
        }
        return num;

    }


    public static List<List<Integer>> findBeforeMatrix(List<List<Integer>> after) {
        // Write your code here
        List<List<Integer>> before = new ArrayList<>();
        int m = after.size();
        int n = after.get(0).size();
        before.add(new ArrayList<>());
        before.get(0).set(0,after.get(0).get(0));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j > 0){
                    before.get(i).set(j,after.get(i).get(j) - after.get(i).get(j-1));
                }else if(j == 0 && i > 0){
                    before.get(i).set(j,after.get(i).get(j) - after.get(i-1).get(j));
                }else if(i > 0 && j > 0){
                    before.get(i).set(j,after.get(i).get(j) - after.get(i).get(j-1) - after.get(i-1).get(j) + after.get(i-1).get(j-1));
                }
            }
        }
        return before;
    }

}
