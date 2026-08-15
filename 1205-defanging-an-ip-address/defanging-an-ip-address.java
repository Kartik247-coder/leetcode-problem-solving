class Solution {
    public String defangIPaddr(String address) {
        char[] str=address.toCharArray();
        StringBuilder ans=new StringBuilder();
        int n=address.length();
        for(int i=0;i<n;i++){
           if(str[i]=='.') ans.append("[.]");
           else ans.append(str[i]);
        }
        return ans.toString();
    }
}