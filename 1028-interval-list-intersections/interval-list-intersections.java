class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        int n=first.length;
        int m=second.length;
        int i=0,j=0,k=0;
        
         if(n==0 || m==0) return new int[][]{};
        int[][] ans=new int[n+m][2];

        int start1=first[0][0];
        int end1=first[0][1];
        
        int start2=second[0][0];
        int end2=second[0][1];

        while(i<n && j<m){
            if(end1>=start2 && end2>=start1){
                ans[k][0]=Math.max(start1,start2);
                ans[k][1]=Math.min(end1,end2);
                k++;
            }
     
            if(end1<end2){
                i++;
                if(i<n){
                    start1=first[i][0];
                    end1=first[i][1];
                }
            }
            else{
                j++;
                if(j<m){
                    start2=second[j][0];
                    end2=second[j][1];
                }
            }
        
        }
        return Arrays.copyOf(ans,k);
    }
}