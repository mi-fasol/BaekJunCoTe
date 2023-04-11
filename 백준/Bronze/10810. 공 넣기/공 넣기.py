n, m = map(int, input().split())
arr = [0] * (n + 1)

for i in range(m):
    a, b, k = map(int, input().split())
    for j in range(a, b+1):
        arr[j] = k

for i in range(1, n+1):
    print(arr[i])