import java.util.*;
public class sample {
    public static int subarraySum(int[] nums) {
        int sum =0,count =0;
        Map<Integer,Integer>presum = new HashMap<>();
        presum.put(sum,1);
        for(int i=0;i<nums.length-1;i++){
            sum +=nums[i];
            if(presum.containsKey(sum-nums[i+1])){
                count +=presum.get(sum-nums[i+1]);
            }
            presum.put(sum,presum.getOrDefault(sum,0)+1);
        }
        return count;
    };
    public static void main(String []args){
        int[] nums = {1,2,3,5,8};
         System.out.println(subarraySum(nums));
    }
    
    
}