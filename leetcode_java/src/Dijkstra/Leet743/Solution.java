package Dijkstra.Leet743;

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        boolean visited [] = new boolean[N + 1];
        // initilize boolean all false
        visited[K] = true;
        
        
        // distance 2 source
        int distance [] = new int [N + 1];
        for(int i=1; i<=N; i++) {
        	distance[i] = Integer.MAX_VALUE;
         }
        distance[K] = 0;  // source 2 source dis is 0
        
        int timeLength = times.length;
        boolean allvisited = false;
        while(!allvisited) {
        
	        // 更新U集合与S的距离
	        for(int i=0; i<timeLength; i++) {
	        	if (visited[times[i][0]] && distance[times[i][0]] + times[i][2] < distance[times[i][1]]) {
	        		distance[times[i][1]] = distance[times[i][0]] + times[i][2];
	        	}
	        }
	        // print_func
	        // end print
	        int min = Integer.MAX_VALUE;
	        int minIndex = K;
	        allvisited = true;
	        for(int i=1; i<=N; i++) {
	        	if (!visited[i] && distance[i]<min) {
	        		min = distance[i];
	        		minIndex = i;
	        		allvisited = false;
	        	}
	        }
	        visited[minIndex] = true;
	                
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
        	if(distance[i] > max) {
        		max = distance[i];
        	}
        }
        
        return max==Integer.MAX_VALUE? -1: max;
    }
    public boolean allVisited(boolean[] visit) {
    	for (int i=1; i < visit.length; i++) {
    		if(!visit[i])
    			return false;
    			
    	}
    	return true;
    }
    
}