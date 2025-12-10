class Solution {
    private final static String[] els = {"aya", "ye", "woo", "ma"};
    int answer = 0;
    public int solution(String[] babbling) {
        
        for (String s : babbling) {
            dfs(s, "", "");
        }
        return answer;
    }
    
    
    private void dfs(String target, String curString, String before) {
        // 1. 종료조건 target과 curString이 같아졌을 때
        if (target.equals(curString)) {
            answer++;
            return;
        }
        // 2. 종료조건 curString이 target 의 접두어가 아닐때
        if (!target.startsWith(curString)) {
            return;
        }
        // 3. 종료조건 curString이 target보다 길이가 길어졌을 때
        if (curString.length() > target.length()) {
            return;
        }
        
        for (int i=0; i<4; i++) {
            String nxt = els[i];
            if (!before.equals(nxt))
            dfs(target, curString+els[i], nxt);
        }
        
        return;
        
    }
}