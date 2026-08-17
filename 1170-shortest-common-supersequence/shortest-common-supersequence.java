class Solution {
    public static String lcs(String a,String b){
        int m=a.length();
        int n=b.length();

        int[][] dp=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        //lcs String
        int i=m;
        int j=n;
        StringBuilder str=new StringBuilder();


        while(i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                str.append(a.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]) i--;
            else j--;

        }
        str.reverse();
        return str.toString();

    }
    public String shortestCommonSupersequence(String a, String b) {
        String lcs=lcs(a,b);
        
        int m=a.length();
        int n=b.length();
        int t=lcs.length();
        StringBuilder ans=new StringBuilder();

        int i=0,j=0,k=0;

        while(i<m && j<n && k<t){
            while(a.charAt(i)!=lcs.charAt(k)){
               ans.append(a.charAt(i));
               i++;
            }
            while(b.charAt(j)!=lcs.charAt(k)){
                ans.append(b.charAt(j));
                j++;
            }
            ans.append(lcs.charAt(k));
            i++;j++;k++;
        }

        while(i<m){
          ans.append(a.charAt(i));
          i++;
        }

        while(j<n){
            ans.append(b.charAt(j));
            j++;
        }
        return ans.toString();
    }
}