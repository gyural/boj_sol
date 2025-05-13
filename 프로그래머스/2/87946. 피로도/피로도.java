class Solution {
    static int answer = 0;
     
    public int solution(int k, int[][] dungeons) {
        int[] visit = new int[dungeons.length];
        
        for (int i=0; i<dungeons.length; i++){
            if (dungeons[i][0] <= k){
                visit[i] = 1;
                DFS(k-dungeons[i][1], visit, dungeons, 1);
                visit[i] = 0;
            }
        }
        
        
        return answer;
    }
    
    static private void DFS(int leftK, int[] visit, int[][] dungeons, int depth){
        answer = Math.max(answer, depth);
        
        for (int i =0; i<visit.length; i++){
            if (dungeons[i][0] <= leftK && visit[i] == 0){
                visit[i] = 1;
                DFS(leftK-dungeons[i][1], visit, dungeons, depth+1);
                visit[i] = 0;
            }
        }
        
    }
}