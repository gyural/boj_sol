function solution(s) {
    var answer = '';
    ch = Array(26).fill(0)
    // str.charCodeAt(i)
    for (i = 0; i < s.length; i++){
        ch[s.charCodeAt(i) - 97] += 1
        }
    
    for(i = 0; i < 26; i++){
        if (ch[i] == 1){
            answer += String.fromCharCode(i+97)
        }
    }
          
    return answer;
}