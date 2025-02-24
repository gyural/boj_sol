def solution(data, ext, val_ext, sort_by):
    answer = []
    
    key2index = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}
    
    ext_index = key2index[ext]
    for d in data:
        if d[ext_index] < val_ext:
            answer.append(d)
    
    
    # 정렬
    answer.sort(key = lambda x: x[key2index[sort_by]])
    
    return answer