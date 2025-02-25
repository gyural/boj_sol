def solution(t, p):
    result = 0
    
    p_size = len(p)
    p_num = int(p)
    
    for i in range(len(t) - len(p)+1):
        sub_num = int(t[i: i+p_size])
        
        if sub_num <= p_num:
            result +=1 
    
    return result