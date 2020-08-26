package leet127;

import java.util.ArrayList;
import java.util.List;

class Solution {
	   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		    if(!wordList.contains(endWord)){
		    	return 0;
		    }
	        //int count = 0;
	        int last = -1;
	    	List<String> openList = new ArrayList<String>();
	    	boolean [] visited = new boolean[wordList.size()];
	        int [] counts = new int[wordList.size()];
	        //String [] parents = new String[wordList.size()];
	    	openList.add(beginWord);
	        
	    	while(!openList.isEmpty()) {
	    		String current = openList.get(0);
	    		openList.remove(0);
	    		last = wordList.indexOf(current);
	    		
	    		for(int i=0; i<wordList.size(); i++) {
	    			if (!visited[i] && diffOne(wordList.get(i), current)) {
	                    if(last==-1){
	                        counts[i] = 1;
	                        //parents[i] = current;
	                    }
	                    else{
	                        counts[i] = counts[last] +1;
	                    }
	                    if (wordList.get(i) == endWord) {
	                    	if(wordList.get(i).equals(endWord))
	                    	return counts[i]+1;
	                    }

	    				openList.add(wordList.get(i));
	    				visited[i] = true;

	    			}

	    		}
	    	}
	    	
	        return -1;
	    }
	    public boolean diffOne(String word1, String word2){
	        if(word1.length() != word2.length())
	        {return false;}
	        int count = 0;
	        for(int i=0; i<word1.length(); i++) {
	        	if (word1.charAt(i) != word2.charAt(i))
	        		count++;
	        }
	        if(count ==1) {
	        	return true;
	        }else {
	        	return false;
	        }
	    }
	    public static void main(String args[]) {
	    	String  beginWord = "hit",endWord = "cog";
	    	String[] arr = {"hot","dot","dog","lot","log","cog"};
	    	List<String> wordList = new ArrayList<String>();
	    	for(int i=0; i<arr.length; i++) {
	    		wordList.add(arr[i]);
	    	}
	    	Solution sol = new Solution();
	    	int res = sol.ladderLength(beginWord, endWord, wordList);
	    	
	    	System.out.println(res);
	    	
	    }
	    
}