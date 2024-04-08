//체력 회복 함수
const healing = (curHealth, value, max)=>{
    const sumHealth = curHealth + value
    if(sumHealth > max){
        return max
    }else{
        return sumHealth
    }
}
function solution(bandage, health, attacks) {
    var answer = 0;
    let currentHealth = health
    const maxTime = attacks[attacks.length-1][0]
    let attIndex = 0
    let accumTime = 0
    let timeCount = 0
    // console.log(attTime)
    for (let i=0; i <= maxTime; i++){
        
        if (i === attacks[attIndex][0]){
            const val = -1 * attacks[attIndex][1]
            //공격당함
            currentHealth = healing(currentHealth, val, health)
            
            if (currentHealth <= 0){return -1}
            accumTime = 0
            timeCount = 0
            attIndex += 1 
        }else{
            timeCount += 1
            currentHealth = healing(currentHealth, bandage[1], health)
            accumTime += 1
            if(accumTime === bandage[0]){
                console.log("???")
                currentHealth = healing(currentHealth, bandage[2], health)
                accumTime = 0
            }
        }
        
        console.log(currentHealth)
    }
    
    answer = currentHealth
    return answer;
}