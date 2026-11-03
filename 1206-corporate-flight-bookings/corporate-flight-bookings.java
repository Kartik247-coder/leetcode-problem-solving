class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int [] ans=new int[n];
        int row=bookings.length;
        

        for(int i=0;i<row;i++){
            int start=bookings[i][0];
            int end=bookings[i][1];
            int num=bookings[i][2];

            ans[start-1]+=num;
            if(end!=n) ans[end]+=-num;
            
        }

        for(int i=1;i<n;i++){
             ans[i]+=ans[i-1];
        }

        return ans;
    }
}