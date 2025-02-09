def getTotalSec(mmss):
    min, second = mmss.split(":")
    totalSec = int(min) * 60 + int(second)
    return totalSec

def nextTime(pos_sec, video_len_sec):
    return min(pos_sec + 10 , getTotalSec(video_len))

def prevTime(pos_sec):
    return max(pos_sec - 10 , 0)
    
def solution(video_len, pos, op_start, op_end, commands):
    answer = ''
#   초단위로 전처리
    op_start_second = getTotalSec(op_start)
    op_end_second = getTotalSec(op_end)
    pos_sec = getTotalSec(pos)
    video_len_sec = getTotalSec(video_len)
    
    for c in commands:
#       오프닝 스킵
        if(op_start_second <= pos_sec and  pos_sec < op_end_second):
            pos_sec = op_end_second
        
        if (c == "next"):
            pos_sec = min(pos_sec+10, video_len_sec)
        if(c == "prev"):
            pos_sec = max(pos_sec-10, 0)
            
        if(op_start_second <= pos_sec and  pos_sec < op_end_second):
            pos_sec = op_end_second
        
        
    return f"{int(pos_sec/60):02d}:{pos_sec%60:02d}"