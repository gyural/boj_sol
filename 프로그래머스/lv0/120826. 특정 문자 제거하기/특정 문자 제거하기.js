function solution(my_string, letter) {
    var answer = '';
    tmp_list = my_string.split('')
    N = tmp_list.length
    for (i = 0; i < N; i++){
        c = tmp_list.pop()
        if (c != letter){
            tmp_list.unshift(c)
        }
    }
    answer = tmp_list.join('')
    return answer;
}