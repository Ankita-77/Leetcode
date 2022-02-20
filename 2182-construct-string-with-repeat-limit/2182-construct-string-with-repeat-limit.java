class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // store freq of every character
        int freq[] = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        
        // add char and freq in pq
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.ch - a.ch);
        for(int i=0; i<freq.length; i++){
            if(freq[i] == 0) continue;
            pq.offer(new Pair((char)(i+'a'), freq[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            Pair p = pq.poll();
            char ch = p.ch;
            int count = p.count;
            
//If the current ending char is what we poll from PQ We need a different char, cause we cannot use same char in a row.
            if(sb.length() == 0 || sb.charAt(sb.length()-1) != ch){
                int times = Math.min(count, repeatLimit);
                while(times-- > 0){
                    sb.append(ch);
                    count--;
                }
                
                if(count > 0){
                    pq.offer(new Pair(ch, count));
                }
            }else{
                if(pq.size() == 0) break;
                Pair p1 = pq.poll();
                char ch1 = p1.ch;
                int count1 = p1.count;
                
                sb.append(ch1);
                count1--;
                if(count1 > 0){
                    pq.offer(new Pair(ch1, count1));
                }
                
                pq.offer(p); // Remember to put the first polled pair back.
            }
        }
        
        return sb.toString();
    }
}


class Pair{
    char ch;
    int count;
    
    public Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}