% python3 bigNumRule1
% Enter 3 input in first line, i.e. 5 8 3
% Enter list of integers in second line, i.e. 2 4 5 4 6

# Input
N, M, K = map(int, input().split())

data = list(map(int, input().split()))

data.sort() # sort in ascending order

n1 = data[N-1] # Biggest number
n2 = data[N-2] # Second biggest number

result = 0

while True:
    for i in range(K):
        if M == 0 :
            break
        result += n1
        M -= 1
    if M == 0:
        break
    result += n2
    M -= 1

print(result)

''' 
연속으로 더할 수 있는 휫수는 최대 K번이므로 
'가장 큰 수를 K번 더하고 주번째로 큰 수를 한번 더하는 연산'을 반복하면 된다
'''
