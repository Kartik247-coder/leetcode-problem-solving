class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;

        int[] arr=new int[n];
        Stack<Integer> st=new Stack<>();

        arr[n-1]=0;
        st.push(prices[n-1]);

        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()>prices[i]){
                  st.pop();
            }
            arr[i]=(st.size()==0)?0:st.peek();
            st.push(prices[i]);
        }

        for(int i=0;i<n;i++){
            prices[i]=prices[i]-arr[i];
        }
        return prices;
         
    }
}