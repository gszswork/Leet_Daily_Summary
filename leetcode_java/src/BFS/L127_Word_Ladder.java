package BFS;

import java.util.*;

public class L127_Word_Ladder {
	   public int ladderLength(String beginWord, String endWord, List<String> wordList) {

	        //int count = 0;
	        int last = -1;
	    	List<String> openList = new ArrayList<String>();
	    	boolean [] visited = new boolean[wordList.size()];
	        int [] counts = new int[wordList.size()];
	    	openList.add(beginWord);
	        	
	    	while(!openList.isEmpty()) {
	    		String current = openList.get(0);
	    		openList.remove(0);
	    		last = wordList.indexOf(current);
	    		
	    		for(int i=0; i<wordList.size() ; i++ ) {
                   
	    			if (!visited[i] && diffOne(wordList.get(i), current) ) {
	                    if(last==-1){
	                        counts[i] = 1;
	                    }
	                    else{
	                        counts[i] = counts[last] +1;
	                    }
	                    if(wordList.get(i).equals(endWord)) {
                           // should return here 
	                    	return counts[i]+1;
	                    }

	    				openList.add(wordList.get(i));
	    				visited[i] = true;

	    			}

	    		}
	    	}
	    	//System.out.println("end");
	        return 0;
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
}
