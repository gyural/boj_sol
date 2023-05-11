function solution(my_str, n) {
    var answer = [];
    for (start = 0; start < my_str.length; start += n){
        answer.push(my_str.slice(start, start+n))
    }
    
    return answer;
    
    
}