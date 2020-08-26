package BFS;

import java.util.*;
// 类似Leet127，但是要找出所有最短的路径，而不只是返回最短路径的长度
public class mySolution {
	List<String> wordList;
	boolean [] visited;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> res =  new ArrayList<List<String>>();
    	Map<String, List<String>> graph = new HashMap<>();
    	graph.put(beginWord, new ArrayList<>());
    	for(String w: wordList) {
    		graph.put(w, new ArrayList<>());
    		System.out.println(graph.get(w).size());
    	}
    	
    	Set<String> words = new HashSet<>(wordList);
        this.wordList = wordList;
        //开始扫描wordList找和beginWord匹配的
        List<String> openList = new ArrayList<String>();
        Map<String, Integer> visited = new HashMap<>();
        openList.add(beginWord);
        int level = 0;
        visited.put(beginWord, level);
        while(!openList.isEmpty()) {
        	String current = openList.get(0);
        	openList.remove(0);
        	List<String> neibours = getNeibours(current, words);
        	for(String word: neibours) {
        		System.out.println(current+ graph.get(current));
        		graph.get(current).add(word);
        		if (!visited.containsKey(word)) {
        			//System.out.println(current + ":" +visited.get(current)+ " " + word);
        			openList.add(word);
        			visited.put(word, visited.get(current)+1);
        			if(word.contentEquals(endWord)) {break;}
        			
        		}
        	}
        }
        //for (Entry<String, Integer> entry : visited.entrySet()) {
           // System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        //}
        List<String> inner = new ArrayList<String>();
        //From now the BFS is allright
        dfs(beginWord, endWord, visited, inner, res, wordList, graph);
        return res;
    }
    public List<String> getNeibours(String word, Set<String> wordList){
        char[] arr = word.toCharArray();   // charlength * 26 * (hashSet * 1)
        List<String> res = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            for(char c='a'; c<='z'; c++) {
                if(c == arr[i]) continue;
                char old = arr[i];
                arr[i] = c;
                String temp = new String(arr);
                if(wordList.contains(temp)) {
                	res.add(temp);
                	
                }
                arr[i] = old;
            }
        }
        
        return res;
    }
    
    public void dfs(String begin, String end, Map<String, Integer> visited, List<String> inner, List<List<String>> res, List<String> wordList, Map<String, List<String>> graph) {
    	inner.add(begin);
    	//System.out.println();
    	if(begin.equals(end)) {
    		res.add(new ArrayList<>(inner));
    		// 						   ^	
    		//I should build a new --  |   ArrayList Here instead of inner. Because we will change the value in inner later.  
    	}else {
    		for(String word: graph.get(begin)) {
    			if(visited.containsKey(word) && visited.get(word) == visited.get(begin)+1 && diffOne(word, begin)) {
    				dfs(word, end, visited, inner, res, wordList, graph);
    			}
    			
    		}
    	}
    	inner.remove(inner.size()-1);
    }
    public boolean diffOne(String word1, String word2){
    	// wordLength * wordListLength 
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
    	String [] words = {"hot","dot","dog","lot","log","cog"};
    	String [] words1 = {"a", "b", "c"};
    	List<String> wordList = new ArrayList<>();
    	for(int i=0; i<words.length; i++) {
    		wordList.add(words[i]);
    	}
    	String beginWord = "hit",
    			endWord = "cog";
    	mySolution sol = new mySolution();
    	List<List<String>> res= sol.findLadders(beginWord, endWord, wordList);
    	
    	for( int i=0; i<res.size(); i++) {
    		List<String> inner = res.get(i);
    		
    		for(int j=0; j<inner.size(); j++) {
    			System.out.print(inner.get(j)+ " ");
    		}
    		System.out.println();
    	}
    }
}
