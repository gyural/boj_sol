class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int pt1 = 0;
        int pt2 = 0;
        
        int goalPt = 0;
        
        while(pt1 < cards1.length || pt2 < cards2.length){
            if (goalPt >= goal.length){
                return "Yes";
            }
            
            String targetWord = goal[goalPt];
            
            if (pt1 < cards1.length && cards1[pt1].equals(targetWord)){
                pt1++;
                goalPt++;
            } else if (pt2 < cards2.length && cards2[pt2].equals(targetWord)){
                pt2++;
                goalPt++;
            } else{
                return "No";
            }
            
            
        }
        
        if (goalPt == goal.length){
            return "Yes";
        }
        
        return "No";
       
    }
}