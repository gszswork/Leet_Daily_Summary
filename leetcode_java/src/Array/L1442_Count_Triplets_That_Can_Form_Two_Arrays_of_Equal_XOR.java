package Array;
// a == b  a^b = 0
public class L1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
    public int countTriplets(int[] arr) {
    	int count = 0;
    	for (int i=0; i<arr.length; i++) {
    		int sum = 0;
    		for(int j=i; j<arr.length; j++ ) {
    			sum ^= arr[j];
    			if(j>i && sum ==0) {
    				count += j-i;
    			}
    		}
    	}
    	return count;
    }
    public static void main(String args[]) {
    	System.out.println(1^0);
    	System.out.println(0^0);
    	System.out.println(1^1);
    }
    
}
