class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // read J and build jewels hash set.
        // read S and count jewels.
        int count = 0;
        Set setJ = new HashSet();
        for(char j :jewels.toCharArray()){
            setJ.add(j);
        }
        for(char s : stones.toCharArray()){
            if(setJ.contains(s)) count++;
        }
        return count;
    }
}


// I used hash set and it's O(1) time to check if it contains an element.
// So the total time complexity will be O(J+S), instead of O(JS)
// Space is O(J)