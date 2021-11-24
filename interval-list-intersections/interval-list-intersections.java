class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList){
        if (firstList.length == 0) return firstList;
        
        if (secondList.length == 0) return secondList;
        
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        
        while (i < firstList.length && j < secondList.length){
            int fs = firstList[i][0];
            int fe = firstList[i][1];
            int ss = secondList[j][0];
            int se = secondList[j][1];
            
            if (fs >= ss && fs <= se){
                result.add(new int[]{fs, Math.min(fe, se)});
            } else if (ss >= fs && ss <= fe){
                result.add(new int[]{ss, Math.min(fe, se)});
            }
        
            if (se > fe) i++;
            else j++;
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}
