class Solution {
    public static int sol(String a,String b,int i,int j,int[][]dp){
        if(j<0) return i+1;
        if(i<0) return j+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]=sol(a,b,i-1,j-1,dp);
        }
        else{
            int insert=sol(a,b,i,j-1,dp);
            int delete=sol(a,b,i-1,j,dp);
            int replace=sol(a,b,i-1,j-1,dp);
            return dp[i][j]=1+Math.min(insert,Math.min(delete,replace));
        }
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][]dp=new int[m][n];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return sol(word1,word2,m-1,n-1,dp);
    }
}