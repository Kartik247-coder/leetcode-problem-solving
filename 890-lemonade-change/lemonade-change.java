class Solution {
    public boolean lemonadeChange(int[] arr) {
        int n=arr.length;
        int five=0;
        int ten=0;
        int ternty=0;

        for(int i=0;i<n;i++){
            if(arr[i]==5) five++;
            else if(arr[i]==10){
                if(five==0) return false;
                else {
                    five--;
                    ten++;
                }
            }
            else if(arr[i]==20){
                if(ten!=0 && five!=0){
                    ten--;
                    five--;
                }
                else{
                    if(five<3) return false;
                    else five-=3;
                }
            }
        }
        return true;
    }
}