function solution(n) {
    var answer = 0;
    cmp = 1
    while (n >= cmp){
        cmp = cmp * (answer+1)
        answer += 1
    }
    
    
    
    return answer-1;
}