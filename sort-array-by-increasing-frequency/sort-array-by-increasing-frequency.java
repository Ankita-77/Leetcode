class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map= new HashMap<>();//data -- frequency
        
        for(int data: nums)//calculating and putting the frequency of data 
            map.put(data, map.getOrDefault(data, 0)+1);
        
        
PriorityQueue<Map.Entry<Integer, Integer>> heap= new PriorityQueue<>((a, b)->{
            return (a.getValue() == b.getValue())? b.getKey() - a.getKey() :                         a.getValue() - b.getValue();
        });
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet())
            //putting all the Entry into the heap 
            heap.offer(entry);
        
        int index= 0;
        //index is for insering into the same array
        
        while(heap.size() != 0){
            
           Map.Entry<Integer, Integer> temp= heap.poll();
 
           int val= temp.getKey();
           int freq= temp.getValue();
           
           for(int i= 0; i< freq; i++)
               nums[index+i]= val;
           index+= freq;
        }
        
        return nums;
        
        
    }
}