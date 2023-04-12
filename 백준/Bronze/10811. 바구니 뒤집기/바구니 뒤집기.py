n, m = map(int, input().split())
buc = [i for i in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    buc[a:b+1] = reversed(buc[a: b+1])

for i in range(1, n+1):
    print(buc[i])