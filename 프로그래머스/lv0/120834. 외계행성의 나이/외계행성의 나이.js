function solution(age) {
    var answer = '';
    let arr = []
    let tmp = age
    while (tmp >= 0){    
        el = tmp % 10
        tmp = parseInt(tmp / 10)
        arr.unshift(String.fromCharCode(el + 97))
        if (tmp == 0){
            break;
        }
    }
    answer = arr.join('')
    return answer;
}