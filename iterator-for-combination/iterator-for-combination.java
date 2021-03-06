class CombinationIterator {

    PriorityQueue<String> pq = new PriorityQueue<>();
    
    public CombinationIterator(String s, int k) {
        generateSub(s,k,0,new StringBuilder());
    }
    
    private void generateSub(String s,int len,int start,StringBuilder result){
        if (len == 0){
            pq.add(result.toString());
            return;
        }
        for (int i = start; i <= s.length()-len; i++){
            result.append(s.charAt(i));
            generateSub(s, len-1, i+1, result);
            result.deleteCharAt(result.length()-1);
        }
    }
    
    public String next() {
        return pq.poll();
    }
    
    public boolean hasNext() {
        return !pq.isEmpty();
    }
    
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */