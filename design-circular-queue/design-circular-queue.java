class MyCircularQueue {
    
    int arr[];
    int front = 0;
    int rare = -1;
    int count = 0;
    
    
    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(count == arr.length){
            return false;
        }else{
            rare = (rare + 1) % arr.length;
            arr[rare] = value;
            count++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(count == 0){
            return false;
        }else{
            front = (front + 1) % arr.length;
            count--;
            return true;
        }
    }
    
    public int Front() {
        if(count == 0){
            return -1;
        }else{
            return arr[front];
        }
    }
    
    public int Rear() {
        if(count == 0){
            return -1;
        }else{
            return arr[rare];
        }
    }
    
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isFull() {
        if(count == arr.length){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */