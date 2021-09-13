class MyQueue {

    Stack<Integer> main = new Stack<Integer>(); 
    Stack<Integer> helper = new Stack<Integer>(); 
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        main.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(main.size() == 0){
            return -1;
        }else{
            while(main.size() > 1){
                helper.push(main.pop());
            }
            
            int val = main.pop();
            
            while(helper.size() > 0){
                main.push(helper.pop());
            }
            
            return val;
        }
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(main.size() == 0){
            return -1;
        }else{
            while(main.size() > 1){
                helper.push(main.pop());
            }
            
            int val = main.pop();
            helper.push(val);
            
            while(helper.size() > 0){
                main.push(helper.pop());
            }
            
            return val;
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(main.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */