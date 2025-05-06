class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        int pt1 = 0;
        int pt2 = 0;
        
        int cards1Size = cards1.length;
        int cards2Size = cards2.length;
        
        for (String targetWord: goal){
            
            String pt1Word = pt1 < cards1Size? cards1[pt1] : "-1";
            String pt2Word = pt2 < cards2Size? cards2[pt2] : "-1";
            
            System.out.println(targetWord + " " + pt1Word + " " + pt2Word);
            
            if (pt1Word.equals(targetWord)) {
                pt1++;
            }
            else if (pt2Word.equals(targetWord)) {
                pt2++;
                
            }
            else {
                return "No";
            }
                
        }
        return "Yes";
    }
}