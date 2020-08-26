package leet15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if (hash.containsKey(complement)){
                return new int[] {hash.get(complement), i};
            }
            hash.put(nums[i], i);
        }
		return new int[] {};
    }
// 3 Sum
    void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); 
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) 
                    j--;  
                if(i < j) 
                    s[i++] = s[j];
                
                while(i < j && s[i] < x) 
                    i++;  
                if(i < j) 
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); 
            quick_sort(s, i + 1, r);
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        //quick_sort(nums, 0, nums.length-1);
        HashSet<List<Integer>> hashset = new HashSet<List<Integer>>();
        //List<List<Integer>> outside = new ArrayList<List<Integer>>();
        for (int i=0; i<len; i++) {
        	int target = 0 - nums[i];
        	Map<Integer, Integer> hash = new HashMap<>();
        	
        	for (int j=0; j<i; j++) {
        		int complement = target - nums[j];
        		if (hash.containsKey(complement)) {
        			List<Integer> inside = new ArrayList<Integer>();
        			inside.add(nums[hash.get(complement)]);
        			inside.add(nums[j]);
        			inside.add(nums[i]);
        			hashset.add(inside);
        		}
        		hash.put(nums[j], j);
        	}
        }
        List<List<Integer>> outside = new ArrayList<List<Integer>>();
        Iterator<List<Integer>> i = hashset.iterator(); 
        while (i.hasNext()) 
        	outside.add(i.next()); 
        return outside;
        
    }
//    quicksort :: [Int] -> [Int]
//    quicksort [] = []
//    quicksort [a] = [a]
//    quicksort (x:xs) = (quicksort less) ++ [x] ++ (quicksort more)
//   	where less = filter (<x) xs
//		      more = filter (>=x) xs 
    public static void main(String args[]) {
    	Solution sol = new Solution();
    	int [] arr = {-1,0,1,2,-1,-4};
    	System.out.println(sol.threeSum(arr));
    }
}
