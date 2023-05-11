function solution(array, n) {
    var answer = 0;
    
    diff = Array(array.length)
    
    for (i = 0; i < array.length; i++){
        diff[i] = Math.abs(array[i] - n)
    }
    
    minValue = diff[0]
    answer = array[0]
    for (i=1; i < diff.length; i++){
        tmp = diff[i]
        if (tmp == minValue){
            answer = Math.min(answer, array[i])
        }
        else if (tmp < minValue){
            answer = array[i]
            minValue = tmp
        }
    }
    return answer;
}