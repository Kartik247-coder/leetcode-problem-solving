class Solution {
    public static int[] nse(int[] arr){
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        res[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                   st.pop();
            }
            res[i]=(st.size()==0)?n:st.peek();
            st.push(i);
        }
        return res;
    }
    public static int[] pse(int[]arr){
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        res[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                st.pop();
            }
            res[i]=(st.size()==0)?-1:st.peek();
            st.push(i);
        }
        return res;
    }
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        
        int[]nse=nse(arr);
        int[]pse=pse(arr);

        int mod = (int)1e9 + 7;
        int sum=0;

        for(int i=0;i<n;i++){
           int left=i-pse[i];
           int right=nse[i]-i;
           long freq=left*right*1L;
           int val=(int)(freq*arr[i]%mod);
           sum=(sum+val)%mod;
        }
        return sum;
    }
}