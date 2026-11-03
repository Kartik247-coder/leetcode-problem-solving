class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] arr=new int[n];
        int count=0;

        arr[0]=nums[0];

        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]+nums[i];
        }


        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
           if(arr[i]==k) count++;
           int rem=arr[i]-k;
           if(map.containsKey(rem)){
            count+=map.get(rem);
           }
           if(!map.containsKey(arr[i])){
            map.put(arr[i],1);
           }
           else{
            map.put(arr[i],map.get(arr[i])+1);
           }
        }
        return count;
    }
}