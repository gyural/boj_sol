import math

#올림
def upFloat(f):
    # 정수 값일 때
    if (f == float(int(f))):
        return int(f)
    return int(f)+1

#내림
def downFloat(f):
    return int(f)
    
def solution(r1, r2):
    # 축위의 점은 무조건 8개가 됨
    answer = 4
    axis_count = 0
    # 1.
    # r1 <= p <= r2 points찾기 y = 0 ->  r2-1까지
    # x^2 + y(0 to r2)^2 --> 을 소수점을 버린 값만큼의 점의 개수를 가짐  
    # 이때 x값의 소수점을 버린값의 정수 값이 1사분면의 
    # x^2 = r2^2 - y^2
    for y in range(1, r2):
        x_L = math.sqrt(r2**2- y**2) #큰 X
        
        if (y >= r1):
            x_S = 1
            axis_count +=1
            start = 1
        else:
            x_S = math.sqrt(r1**2- y**2) #작은 X
            start = upFloat(x_S)
        
        end = downFloat(x_L)
        
        # print(f"start: {start} end: {end}")
        answer += (end - start + 1) * 4 
    answer += 4 * axis_count
        
    print(axis_count)
    return answer