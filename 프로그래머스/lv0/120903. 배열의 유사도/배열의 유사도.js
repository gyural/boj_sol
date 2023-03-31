function solution(s1, s2) {
    var answer = 0;
    for (word1 of s2){
        for (word2 of s1){
            if (word1 == word2){
                answer += 1 
            }
        }
    }
    return answer;
}