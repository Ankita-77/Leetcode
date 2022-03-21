class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] l = new int[26];
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            int c = a[i] - 'a';
            l[c] = i;
        }
        
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int c = a[i] - 'a';
            int newEnd = l[c];
            if (newEnd > end) {
                end = newEnd;
            }
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
                end = i + 1;
            }
        }
        return result;
    }
}