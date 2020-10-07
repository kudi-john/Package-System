import java.util.*;

public class SAP {
    public  static void  main(String[] args){
        String[] str = new String[]{"kylan charles","raymond strickland","bcdefgh  ijklms","julissa  shepard","andrea meze","destiney  alvarado","abcdefg hijklm"};
        System.out.println(counter(str));
    }
    public static String counter(String[] str){
        Map<String,Integer> map = new HashMap<>();
        for(String s : str){
            map.put(s,countNumberOfLetter(s.toLowerCase()));
        }
        String res = "";
        int maxNumberOfLetter = 0;
        for(String s : map.keySet()){
            if(map.get(s) > maxNumberOfLetter){
                maxNumberOfLetter = map.get(s);
                res = s;
            }else if(map.get(s) == maxNumberOfLetter){
                if(s.compareTo(res) <  0){
                    res = s;
                }
            }
        }
        return res;
    }
    private static int countNumberOfLetter(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(c != ' ') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return map.size();
    }


}

//POST .../insert
//DELETE .../





//Idempotency
