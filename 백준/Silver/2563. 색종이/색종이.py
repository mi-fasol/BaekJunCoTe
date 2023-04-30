mat = [[0] * 100 for _ in range(100)]
cnt = 0
n = int(input())

for i in range(n):
    x, y = map(int, input().split())
    for j in range(x, x + 10):
        for k in range(y, y + 10):
            mat[j][k] = 1

for i in range(100):
    cnt += mat[i].count(1)

print(cnt)