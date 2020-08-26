package Hash_Problem;

import java.util.*;

import Simple_Leet_Problem.leet15.Solution;
// The solution1：
// 两层循环，最内的循环求出complement = target - nums[i] - nums[j]利用哈希找Key为complement的
// 即使使用了HashSet先存储再转存，算法依旧将[-1, 1,0]和[1,0,-1]当作不同的结果(实际它们是同一个数字组合)
// 需要先将nums List进行一个排序，因此还需要QuickSort--这个思路太麻烦
public class L15_Sum3_sol1 {
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
        List<List<Integer>> res = new ArrayList<>();
        quick_sort(nums, 0, nums.length-1);
        int length = nums.length;
        HashSet<List<Integer>> hashRes = new HashSet<>();
        for (int i=0;i<length; i++) {
        	HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        	for(int j=0; j<i; j++) {
        		int com = 0 - nums[i] - nums[j];
        		
        		if(hash.containsKey(com)) {
        			//System.out.println("i: "+ nums[i]+" j: "+nums[j] +" com:"+com);
        			List<Integer> inner = new ArrayList<Integer>();
        			inner.add(nums[i]);
        			inner.add(nums[j]);
        			inner.add(com);
        			hashRes.add(inner);
        		}
        		hash.put(nums[j], j);
        	}
        
        }
        Iterator<List<Integer>> i = hashRes.iterator(); 
        while(i.hasNext()) {
        	res.add(i.next());
        }
        
        return res;
    }
    public static void main(String args[]) {
    	L15_Sum3_sol1 sol = new L15_Sum3_sol1();
    	int [] arr = {-1,0,1,2,-1,-4};
    	System.out.println(sol.threeSum(arr));
    }
}
