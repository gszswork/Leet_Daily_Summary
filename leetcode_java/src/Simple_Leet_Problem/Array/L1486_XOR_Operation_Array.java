package Simple_Leet_Problem.Array;
// 常识： Java 的位与操作符 ‘^’
public class L1486_XOR_Operation_Array {
    public int xorOperation(int n, int start) {
        int res = start;
        for(int i=1; i<n; i++) {
        	res ^= (start+2*i);
        }
        return res;
    }
}
