class Solution {
    public String solution(String phone_number) {
        int size = phone_number.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i =0; i<size-4; i++) sb.append("*");
        
        
        
        
        
        return sb.toString() + phone_number.substring(size-4);
    }
}