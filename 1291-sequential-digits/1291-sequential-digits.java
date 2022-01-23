class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        int l1 = String.valueOf(low).length();
        int l2 = String.valueOf(high).length();
        String s = "123456789";
        while(l1 <= l2) {
            for(int i = 0; i < 10 - l1; i++) {
                int a = Integer.valueOf(s.substring(i, i + l1));
                if(a < low) continue;
                if(a > high) break;
                list.add(a);
            }
            l1++;
        }
        return list;
    }
}