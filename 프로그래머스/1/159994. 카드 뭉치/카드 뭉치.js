function solution(cards1, cards2, goal) {
    let answer = 'No';
    let [fivot1, fivot2, fivot3] = [0,0, 0]
    
    for(targetWord of goal){
        if (fivot1 < cards1.length && cards1[fivot1] === targetWord){
            fivot1 += 1
        }else if(fivot2 < cards2.length && cards2[fivot2] === targetWord){
            fivot2 += 1

        }   
    }
    answer  = (fivot1 + fivot2) === goal.length? "Yes" : "No" 
    return answer;
}