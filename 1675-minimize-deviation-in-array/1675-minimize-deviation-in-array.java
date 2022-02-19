class Solution {
    public int minimumDeviation(int[] nums) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        int min = Integer.MAX_VALUE;
        for(int it : nums){
            if(it % 2 == 1) it *= 2; // make odd -> evem
            min = Math.min(min, it); // find min
            pq.add(it);
        }
        
        int diff = Integer.MAX_VALUE;
        while(pq.peek() % 2 == 0){
            int max = pq.remove();
            diff = Math.min(diff, max-min);
            min = Math.min(min, max/2);
//minimum can change because, new value we are getting by half max can be lower then current minimum
            pq.add(max/2);
        }
        
        return Math.min(diff, pq.peek()-min);
        
    }
}