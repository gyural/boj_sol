function solution(my_string) {
    var answer = '';
    tmp = Array.from(my_string)
    tmp.reverse()
    for (i of tmp){
        answer += i
    }
    return answer;
}