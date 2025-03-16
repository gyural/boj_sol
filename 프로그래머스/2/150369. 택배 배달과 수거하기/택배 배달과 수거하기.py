def getSum(arr):
    result = 0
    for v in arr:
        result += v
    return result


def solution(cap, n, deliveries, pickups):
    answer = 0
    
    delivery_save = -1
    
    for i in range(n-1, -1, -1):
        if deliveries[i] > 0:
            delivery_save = i
            break
    pickup_save = -1
    for j in range(n-1, -1, -1):
        if pickups[j] > 0:
            pickup_save = j
            break
    
            
    while not (delivery_save < 0 and pickup_save < 0):
        
        # print(delivery_save, pickup_save)
        answer += max(delivery_save, pickup_save)+1
        
        count = 0
        
        for i in range(delivery_save, -1, -1):
            # 여기서 그만 둬야할 때
            if deliveries[i] > cap - count:
                deliveries[i] -= (cap-count)
                delivery_save = i
                break
            else:
                count += deliveries[i]
                deliveries[i] = 0
                delivery_save = i-1
        
        #2. pickups
        count = 0
        
        for i in range(pickup_save, -1, -1):
            # 여기서 그만 둬야할 때
            if pickups[i] > cap - count:
                pickups[i] -= (cap-count)
                pickup_save = i
                break
            else:
                count += pickups[i]
                pickups[i] = 0
                pickup_save = i-1
    
    return answer *2