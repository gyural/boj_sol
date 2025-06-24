class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skillTree: skill_trees){
            String el = "";
            for (int i=0; i<skillTree.length(); i++){
                for (int j=0; j<skill.length(); j++){
                    if (skillTree.charAt(i) == skill.charAt(j)){
                        el += skillTree.charAt(i);
                    }
                }
            }
            
            int count =0;
            for (int i =0; i<el.length(); i++){
                if(skill.charAt(i) == el.charAt(i)){
                    count++;
                }
            }
            
            if (count == el.length()) answer++;
        }
        return answer;
    }
}