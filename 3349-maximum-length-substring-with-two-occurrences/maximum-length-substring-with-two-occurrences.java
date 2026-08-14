class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int ans=0;
        int i=0,j=0;

        HashMap<Character,Integer> map=new HashMap<>();

        while(j<n){
            char ch=s.charAt(j);
            if(!map.containsKey(ch)){
              map.put(ch,1);
            }
            else map.put(ch,map.get(ch)+1);
            int count=map.get(ch);

            while(map.get(ch)>2){
                char temp=s.charAt(i);
                int freq=map.get(temp);
                if(freq==1) map.remove(temp);
                else map.put(temp,freq-1);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;

    }
}