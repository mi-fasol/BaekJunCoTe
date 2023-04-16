num = list(map(int, input().split()))
c = [1, 1, 2, 2, 2, 8]
x = [-10] * 6

for i in range(6):
    print(c[i] - num[i], end = ' ')