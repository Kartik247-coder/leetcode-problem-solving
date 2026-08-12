class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        int count=0;
        int i=0,j=0;
         
        while(j<n && i<n){
            if(!map.containsKey(arr[j])){
                map.put(arr[j],1);
            }
            else map.put(arr[j],map.get(arr[j])+1);
            
            while(map.get(arr[j])>k){
                int temp=map.get(arr[i]);
                if(temp==1) map.remove(arr[i]);
                else map.put(arr[i],temp-1);
                i++;
            }
            count=Math.max(count,j-i+1);
            j++;
        }
        return count;
        
    }
}