class Solution {
    public boolean checkDivisibility(int n) {
        int add=0;
        int pro=1;
        int k=n;
        while(n!=0){
            int temp=n%10;
            n=n/10;
            add+=temp;
            pro*=temp;
        }
        int ans=add+pro;
        if(k%ans==0) return true;
        else return false;
    }
}