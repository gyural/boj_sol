dh = [0, 1, -1, 0]
dw = [1, 0, 0, -1]
def solution(board, h, w):
    answer = 0
    
    #   step 1
    n = len(board)
    #   step 2
    count = 0
    #   step 4
    for i in range(4):
        h_check, w_check = h + dh[i], w + dw[i]
        #   step 4-1
        if (0 <= h_check < n and 0 <= w_check < n):
            #   step 4-2
            if (board[h][w] == board[h_check][w_check]):
                count += 1
            
    
    return count