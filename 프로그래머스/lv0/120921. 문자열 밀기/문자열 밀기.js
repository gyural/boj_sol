function solution(A, B) {
    var answer = 0;
    let count = 1
    let size = A.length
    A = A.split('')
    let flag = false
    for (i = 0; i < size+1; i++){
        A.unshift(A.pop())
        //A와 B를 비교하기
        console.log(A.join(''), B)
        if (A.join('') == B){
            answer = count
            flag = true
            break
        }
        count += 1
    }
    answer = count % size
    //같아질수 없다면 -1 리턴
    if (flag == false){return -1} 
    return answer;
}