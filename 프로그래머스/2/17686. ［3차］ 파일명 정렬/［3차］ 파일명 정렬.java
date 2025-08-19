import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<String> fileList = new ArrayList<>();
        for (String f : files){
            fileList.add(f);
        }
        
        fileList.sort((a,b) -> parseNumber(a)-parseNumber(b));
        fileList.sort((a,b) -> parseHEAD(a).compareTo(parseHEAD(b)));
        
        for (int i=0; i<files.length; i++){
            answer[i] = fileList.get(i);
        }
        
        return answer;
    }
    
    private int parseNumber(String fileName) {
        // Number Start Index
        int startIdx=0;
        int endIdx=0;
        
        for (int i=0; i<fileName.length(); i++){
            char c = fileName.charAt(i);
            
            if (isNumber(c)){
                startIdx = i;
                endIdx = i;
                break;
            }
        }
        
        for (int i=startIdx+1; i<fileName.length(); i++){
            char c = fileName.charAt(i);
            
            if (isNumber(c)){
                endIdx = i;
            } else{
                break;
            }
        }
        
        // NUMBER뒤에 숫자가 이어질 때  99999 --> endIdx -startIdx == 4
        if (endIdx -startIdx > 4){
            endIdx = startIdx + 4;
        }
        return Integer.parseInt(fileName.substring(startIdx, endIdx+1));
        
    }
    private String parseHEAD(String fileName){
        int endIdx=0;
        for (int i=0; i<fileName.length(); i++){
            char c = fileName.charAt(i);
            
            if (isNumber(c)){
                endIdx = i;
                break;
            }
        }
        return fileName.substring(0, endIdx).toUpperCase();
    }
    
    private boolean isNumber(char c){
        return "0123456789".contains(c+"");
    }
}