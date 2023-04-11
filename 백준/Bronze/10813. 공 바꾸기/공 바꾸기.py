n, m = map(int, input().split())
arr = []
new = 0

for i in range(0, n+1):
    arr.append(i)

for i in range(m):
    a, b = map(int, input().split())
    new = arr[b]
    arr[b] = arr[a]
    arr[a] = new

for i in range(1, n + 1):
    print(arr[i])