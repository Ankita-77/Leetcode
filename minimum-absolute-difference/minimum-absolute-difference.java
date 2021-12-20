class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<Integer> innerList;
        List<List<Integer>> resultList = new ArrayList<>();
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length-1; i++){
            if(minDiff > Math.abs(arr[i+1] - arr[i])){
                minDiff = Math.abs(arr[i+1] - arr[i]);
            }
        }
        
        for(int i=0; i<arr.length-1; i++){
            if(minDiff == Math.abs(arr[i+1] - arr[i])){
                innerList = new ArrayList<>();
                innerList.add(arr[i]);
                innerList.add(arr[i+1]);
                resultList.add(innerList);
            }
        }
        return resultList;
    }
}