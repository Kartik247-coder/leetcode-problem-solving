class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int n=stones.length();
        int m=jewels.length();
        int count=0;

        Set<Character> set=new HashSet<>();

        for(int i=0;i<m;i++){
            char ch=jewels.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }
        }

        for(int i=0;i<n;i++){
            char ch=stones.charAt(i);
            if(set.contains(ch)) count++;
        }
        return count;
    }
}