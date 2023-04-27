a = []
max = 0
r, c = 0, 0

for i in range(9):
    i = list(map(int, input().split()))
    a.append(i)

for i in range(9):
    for j in range(9):
        if max <= a[i][j]:
            max = a[i][j]
            r = i + 1
            c = j + 1
print(max)
print(r,c)