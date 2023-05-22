n = int(input())

arr = []

for i in range(n):
    [a, b] = map(int, input().split())
    arr.append([a, b])

a = sorted(arr, key=lambda x: (x[1], x[0]))

for i in range(n):
    print(a[i][0], a[i][1])