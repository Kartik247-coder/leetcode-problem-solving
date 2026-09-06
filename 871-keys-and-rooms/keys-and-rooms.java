class Solution {
    public static void dfs(int i,boolean[] vis,List<List<Integer>> list){
        vis[i]=true;
        for(int ele:list.get(i)){
            if(!vis[ele]){
                dfs(ele,vis,list);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> list) {
        int n=list.size();

        boolean[] vis=new boolean[n];

        dfs(0,vis,list);

        for(int i=0;i<n;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
}