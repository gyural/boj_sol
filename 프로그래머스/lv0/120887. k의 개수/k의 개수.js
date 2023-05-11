function count_k(num, k){
    res = 0
    k = String(k)
    num = String(num)
    for (let i of num){
        if (i == k){
            res += 1
        }
        
    }
    return res
}

function solution(i, j, k) {
    var answer = 0;
    
    for (n = i; n <= j; n++){
        answer += count_k(n, k)
    }
    return answer;
}