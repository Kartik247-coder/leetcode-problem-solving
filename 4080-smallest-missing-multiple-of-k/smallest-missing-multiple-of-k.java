class Solution {
    public int missingMultiple(int[] arr, int k) {
        int n=arr.length;
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(arr[i]%k==0){
               list.add(arr[i]/k);
            }
            
        }
        Collections.sort(list);

        int t=1;

        for(int i=0;i<list.size();i++){
            if(list.get(i)<t) continue;
            if(list.get(i)==t) t++;
            else return t*k;
        }
        return t*k;

        
    }
}