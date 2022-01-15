class Solution {
    public int minJumps(int[] arr) {
        
		//Used to store all the indices of all values present in the array
        HashMap<Integer, ArrayList<Integer>>
            map = new HashMap<Integer, ArrayList<Integer>>();
        
		// This is my take on the problem
		// I use it to track the 'VALUE' which has been seen by us,
		// Not the index of the value !
        HashSet<Integer> visitedVal = new HashSet<Integer>();
        
		//Used to mark the visited indices
        boolean[] visited = new boolean[arr.length];
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i=arr.length-1;i>=0;i--){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }
            else{
                map.put(arr[i], new ArrayList<Integer>());
                map.get(arr[i]).add(i);
            }
        }
        
		//We start on the index-0
        q.offer(0);
        int jumps = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int top = q.poll();
                
				//Base case
                if(top == arr.length-1){
                    return jumps;
                }
                
				//Mark index as visited
                visited[top] = true;
                
				//Check the next index
                if(top + 1 < arr.length && !visited[top+1]){
                    q.offer(top+1);
                }
                
				//Check the previous index
                if(top-1 >= 0 && !visited[top-1]){
                    q.offer(top-1);
                }
                
				//This is where we can check if I have encountered the value present at 'top' index
                if(visitedVal.contains(arr[top])) continue;
                
                visitedVal.add(arr[top]);
                
				//We include the value in the set, So next time if reach the index 
				//which contains the same value, we do not run this loop again
				//This prevents O(N ^ 2) complexity
                for(int val : map.get(arr[top])){
                    if(val != top && !visited[val]){
                        q.offer(val);
                    }   
                }
                
                
            }
            
			//Incrementing jumps after I have checked all the possibilities
			//from the current content of queue
            jumps++;
            
            
        }
        //Not required in this problem as we can reach last index anyhow
        return -1;
    }
}