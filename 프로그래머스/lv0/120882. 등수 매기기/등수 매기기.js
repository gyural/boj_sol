function solution(score) {
    var answer = [];
    let rank = Array(score.length).fill(1)
    
    //새로운 배열인 총합 점수 배열 만들어주기
    let sum_arr = []
    for (i = 0; i < score.length; i++){
        sum_arr.unshift((score[i][0]+score[i][1]))
    }
    //등수 계산해주기
    for (i = 0; i < sum_arr.length; i++){
        for (j = 0; j < sum_arr.length; j++){
            if (sum_arr[i] < sum_arr[j]){
                rank[i] += 1
            }
        }
    }
    for (i of rank){
        answer.unshift(i)
    }
    
    return answer;
}