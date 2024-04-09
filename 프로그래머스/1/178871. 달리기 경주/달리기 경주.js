
function solution(players, callings) {
    const callingsAccum = {}
    let plyaerToidx = {}
    let idxToPlayer = {}
    players.forEach((item, idx)=> {
        plyaerToidx[item] = idx
        idxToPlayer[idx] = item
    })
    callings.forEach((item, idx)=> {
        const targetIndex = plyaerToidx[item]
        const loseP = idxToPlayer[targetIndex-1]
        const winP = idxToPlayer[targetIndex]
        plyaerToidx[loseP] = plyaerToidx[loseP] + 1
        plyaerToidx[winP] = plyaerToidx[winP] - 1
        idxToPlayer[targetIndex] = loseP
        idxToPlayer[targetIndex-1] = winP
        
        
    })
    const answer = []
    for (i=0; i < players.length; i++){
        answer.push(idxToPlayer[i])
    }
    
    return answer;
}