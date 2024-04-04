const getGiftDegree = (gifts, giftDegree) =>{
    for (gLog of gifts){
        [a, b] = gLog.split(' ') 
        giftDegree[a] = giftDegree[a]+1 
        giftDegree[b] = giftDegree[b]-1 
    }
    
}
function solution(friends, gifts) {
    var answer = 0;
    
    let giftDegree = {}
    let nextMonth = {}
    for (n of friends){
        giftDegree[n] = 0
        nextMonth[n] = 0
    }
    
    getGiftDegree(gifts, giftDegree)
	console.log(giftDegree)
    for (i = 0; i < friends.length-1; i++){
        for (j= i+1; j < friends.length; j++){
//          gift순회하며 현재 쌍에 대해 i와 j중 횟수 비교
            let first = 0
            let second = 0
            let first_f = friends[i]
            let second_f = friends[j]
//          두명이서 받은 기록 확인
            for (gLog of gifts){
                [a, b] = gLog.split(' ')
                if (a === first_f && b === second_f){
                    first +=1
                }else if(a === second_f && b === first_f){
                    second +=1
                }
            }
//          NextMonth Counting
            if(first > second){
                nextMonth[first_f] =  nextMonth[first_f]+1
            }else if(first < second){
                nextMonth[second_f] =  nextMonth[second_f]+1
            }else if(first === second){
//              선물지수 비교
                if (giftDegree[first_f] > giftDegree[second_f]){
					nextMonth[first_f] =  nextMonth[first_f]+1
                }else if(giftDegree[second_f] > giftDegree[first_f]){
					nextMonth[second_f] = nextMonth[second_f]+1
                }
            }
            
        }
    }
    
	for (f of friends){
        if(nextMonth[f] > answer){
           answer = nextMonth[f]  
        }  
    }
    
    
    return answer;
}