class FreqStack {

    HashMap<Integer,Integer> frequency;
    HashMap<Integer,Stack<Integer>> individual;
    int maxfreq;

    public FreqStack() {
           maxfreq=0;
        frequency=new HashMap<>();
        individual=new HashMap<>();
    }
    
    public void push(int val) {
        frequency.put(val,frequency.getOrDefault(val,0)+1);
        if(!individual.containsKey(frequency.get(val))){
            individual.put(frequency.get(val),new Stack<Integer>());
        }
        individual.get(frequency.get(val)).add(val) ;
        maxfreq = maxfreq > frequency.get(val) ? maxfreq : frequency.get(val);
     
        
    }
    
    public int pop() {
        int topElement = individual.get(maxfreq).pop();
        if(individual.get(maxfreq).isEmpty()){
            maxfreq--;
        }
        frequency.put(topElement,frequency.getOrDefault(topElement,0)-1);

        return topElement;
       
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */