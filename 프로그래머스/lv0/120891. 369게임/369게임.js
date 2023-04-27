function solution(order) {
    var answer = 0;
    
    while (order > 0){
        tmp = parseInt(order % 10)
        order = parseInt(order / 10)
        if (tmp == 3 || tmp == 6 || tmp == 9){
            answer += 1
        }
    }
    return answer;
}