class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int count = 0;
        String sUpper = s.toUpperCase();
        
        for (int i = 0; i < s.length(); i++){
            if (sUpper.charAt(i) == 'P'){
                count +=1;
            } else if (sUpper.charAt(i) == 'Y'){
                count -= 1;
            }
            
        }

        return count == 0 ? true : false;
    }
}