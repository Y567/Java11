package likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    //三数之和为0
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0,j = i+1,k=nums.length-1;
        if(nums.length < 3){
            return null;
        }
        while(j < k){
            if(nums[k]+ nums[j]+nums[i] < 0){
                j++;
            }else if(nums[k]+ nums[j]+nums[i] > 0){
                k--;
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                result.add(list);
                while(j < k && nums[j] == nums[j+1]){
                    j++;
                }
                j++;
                while(j < k && nums[k] == nums[k-1]){
                    k--;
                }
                k--;
            }
            if(j >= k){
                while(i < nums.length - 2 && nums[i] == nums[i+1]){
                    i++;
                }
                i++;
                j = i+1;
                k=nums.length-1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
