public class databrickscountSegment {
    public  static void  main(String[] args){
       int[] arr = new int[]{0,0,0,0,0};
        System.out.println(counter(arr));
    }
    public static long counter(int[] a) {
        long res = 0;
        int n = a.length;
        int[] prefix = new int[n];
        prefix[0] = a[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+a[i];
        }
        int sum =  prefix[n-1];
        int firstIndex = 0;
        while(firstIndex < n && prefix[firstIndex] <= sum/3){
            for(int i=firstIndex+1;i<n;i++){
                int secondSum = prefix[i] -  prefix[firstIndex];
                if(secondSum > sum - prefix[firstIndex] -  secondSum) break;
                if(prefix[firstIndex] <= secondSum) res++;
            }
            firstIndex++;
        }
        return res;
    }
}
