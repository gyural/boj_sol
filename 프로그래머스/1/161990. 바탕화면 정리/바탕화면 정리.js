const countFileNum = (sY, sX, eY, eX, wallpaper) =>{
    let files = 0
    for (Y=sY; Y<eY; Y++){
        
        for(X=sX; X<eX; X++){
            if(wallpaper[Y][X] === "#"){
                files = files + 1
            }
        }
    }
    return files
}
function getFileNum(wallpaper){
    let res = 0
    for (line of wallpaper){
        for (char of line){
            if(char==="#"){
                res += 1
            }
        }
    
    }
    return res
    
}

function solution(wallpaper) {
    var answer = [0,0,0,0];
    let minSize = 2100000000
    const FileNum = getFileNum(wallpaper)
    
    
    for (sY = 0; sY < wallpaper.length; sY++){
        for (sX=0; sX < wallpaper[0].length; sX++){
            for (eY = sY; eY <= wallpaper.length; eY++){
                for (eX=sX; eX <= wallpaper[0].length; eX++){
                    if(countFileNum(sY, sX, eY, eX, wallpaper)===FileNum){
                        
                        let Size = (eY-sY) + (eX-sX)
                        if(Size < minSize){
                            minSize = Size
                            answer = [sY,sX,eY,eX]
                        }
                }}
            }
        }
    }
    
    return answer;
}