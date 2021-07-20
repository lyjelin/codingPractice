N, M, K = map(int, input().split())
data = list(map(int, input().split()))

data.sort()

n1 = data[N-1]
n2 = data[N-2]

count = int(M / (K + 1)) * K
count += M % (K + 1)

ans = 0
ans += count * n1
ans += (M - count) * n2

print(ans)