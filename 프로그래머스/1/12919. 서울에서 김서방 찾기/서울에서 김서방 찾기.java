class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int place =-1;
        
        for (int i=0; i < seoul.length; i++){
            String v = seoul[i];
            if (v.equals("Kim")){
                place = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ");
        sb.append(place+"");
        sb.append("에 있다");
        
        return sb.toString();
    }
}