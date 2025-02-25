def solution(s):
    answer = []
    
    key_val = {}
    
    
    for idx, c in enumerate(s):
        if c not in list(key_val.keys()):
            key_val[c] = idx
            answer.append(-1)
        else:
            last_idx = key_val[c]
            key_val[c] = idx
            answer.append(idx-last_idx)
        
        
        
    
    return answer