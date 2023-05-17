function solution(emergency) {
    var answer = [];
    
    
    for (i = 0; i < emergency.length; i++){
        tmp = 1
        for (j = 0; j < emergency.length; j++){
            if (emergency[i] < emergency[j]){
                tmp += 1
            }
        
        }
        answer.push(tmp)
    }
    
    return answer;
}