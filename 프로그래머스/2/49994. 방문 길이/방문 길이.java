import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[] dy = new int[]{-1,1,0,0}; 
        int[] dx = new int[]{0,0,-1,1}; 
        
        int curY = 0;
        int curX = 0;
        
        Set<String> route = new HashSet<>(); 
        
        for (int i=0; i<dirs.length(); i++){
                
            char cmd = dirs.charAt(i);
            
            int nxtY = curY + dy[cmd2Idx(cmd)];
            int nxtX = curX + dx[cmd2Idx(cmd)];
            
            // 맵밖
            if ((nxtY < -5 || nxtY > 5) || (nxtX < -5 || nxtX > 5)){
                continue;
            }
            
            String nxtEntry = ""+curY+curX+nxtY+nxtX;
            String nxtEntryOpposite = ""+nxtY+nxtX+curY+curX;
            
            if (!(route.contains(nxtEntry) || route.contains(nxtEntryOpposite))){
                route.add(nxtEntry);
                route.add(nxtEntryOpposite);
                
                answer++;
            }
            
            curY = nxtY;
            curX = nxtX;
        }
        
        return answer;
    }
    
    private int cmd2Idx (char cmd){
        switch (cmd){
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'R':
                return 2;
            case 'L':
                return 3;
            
        }
        
        return -1;
    }
}