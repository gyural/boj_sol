function solution(players, callings) {
    var answer = [...players];
    const playerMap = new Map();
    // players 배열을 Map에 저장
    for (let i = 0; i < players.length; i++) {
        playerMap.set(players[i], i);
    }
    for (let target of callings){
        const idx = playerMap.get(target);
        //SWAP
        let tmp = answer[idx - 1]
        answer[idx-1] =  answer[idx]
        answer[idx] = tmp
        playerMap.set(answer[idx], idx);
        playerMap.set(answer[idx-1], idx-1);
        
    }
    return answer;
}