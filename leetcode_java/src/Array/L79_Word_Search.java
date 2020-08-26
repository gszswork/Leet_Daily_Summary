package Array;
/*题目：给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 * 
 * */
/* DFS是简单的部分，难点在于回溯的位置
	一开始的设计，扫描所有点直接开始dfs，复杂度太高容易出错。优化后，扫描所有点，当该点与word[0]一样时再开始dfs。
	dfs中，如果str.length()==0， return true。 然后考虑上下左右四个位置，当“该位置未被访问，且该位置字符与str匹配“，将该位置标记为访问，开始递归dfs。
	1. 如果在dfs的过程中找到了目标串，return true，递归结束。   2. 如果无法找到，则不返回，采用回溯，把之前的访问标记去除（visited[][] = false;)
*/

public class L79_Word_Search {
	char [][] mat;
	boolean [][] visited;
	//four direction:
	int [][] direction = {{-1, 0}, {1,0}, {0, -1}, {0, 1}};
	boolean ret = false;
	int lengthX, lengthY;
    public boolean exist(char[][] board, String word) {
    	mat = board;
    	lengthX = board.length; lengthY = board[0].length;
    	for(int i=0; i<lengthX; i++) {
    		for(int j=0; j<lengthY; j++) {
    			visited = new boolean[lengthX][lengthY];
    			if(word.charAt(0)==board[i][j]) {
    				visited[i][j] = true;
    				if(dfs(i, j, word.substring(1))) {
    					return true;
    				}
    			}
    		}
    	}
        return false;
    }
    public boolean dfs(int xx,int yy , String str) {
    	if (str.length()==0) {
    		return true;
    	}
    	System.out.println(xx + " "+yy+ " str:"+ str+" "+str.length());
    	// 这里只考虑上下左右，应该四种情况就全部列出来了 (x+1,y) (x-1,y) (x,y+1) (x,y-1)
    	for(int i=0; i<4; i++) {
    		int x = xx+direction[i][0];
    		int y = yy+direction[i][1];
	    	if(x>=0 && x<lengthX && y>=0 && y<lengthY && !visited[x][y]  && str.length()>0) {
	    		if (mat[x][y] == str.charAt(0)) {
	    			visited[x][y] = true;
	    			if(dfs(x,y,str.substring(1))) {
	    				return true;
	    			}
	    		}
	    		//回溯
	    		visited[x][y] = false;
	    	}
    	}
    	
    	
    	return false;
    }
    public void printFunc() {
    	for(int i=0; i<lengthX; i++) {
    		for(int j=0; j<lengthY; j++) {
    			int num = visited[i][j]?1:0;
    			System.out.print(mat[i][j]+":"+num+", ");
    		}
    		System.out.println();
    	}
    }
	public static void main(String args[]) {
		char [][]board =
			{
					{'A','B','C','E'},
					{'S','F','E','S'},
					{'A','D','E','E'}
			};
		char [][] board1 = {{'a','a'}};
		String word = "ABCESEEEFS";
	}
}
