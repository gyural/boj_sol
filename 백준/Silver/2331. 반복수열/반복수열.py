A, P= map(int, input().split())

arr = [A]
while(True):
    tmp = 0
    for n in str(arr[-1]):
        tmp += int(n) ** P
    if(True and tmp in arr):
        arr = arr[:arr.index(tmp)]
        break
    else:
        arr.append(tmp)

result = len(arr)

# print(arr)
print(len(arr))

