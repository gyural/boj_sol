function solution(before, after) {
    var answer = 0;
    before = Array.from(before)
    after = Array.from(after)
    before.sort()
    after.sort()
    answer = 1
    for (i = 0 ; i < before.length; i++){        
        if (before[i] != after[i]){
            answer = 0;
        }
    }
    return answer;
}