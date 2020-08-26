package Array;

public class L941_Valid_Mount_Array {
    public boolean validMountainArray(int[] A) {
        int length = A.length;
        boolean incre = true;
        boolean changed = false;
        for (int i=1; i<length; i++){
            if (A[i] < A[i-1] && incre && i!=1){ // 峰顶已过
                incre = false;
                changed = true;
            }
            if(A[i] > A[i-1] && incre){
                return false;
            }

        }
        if(changed && !incre){
            return true;
        }
        return false;
    }
    
}
