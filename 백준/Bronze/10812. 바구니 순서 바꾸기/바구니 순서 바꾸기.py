n, m = map(int, input().split())
buc = [i for i in range(1, n+1)]

for i in range(m):
    a, b, c = map(int, input().split())
    a, b, c = a-1, b-1, c-1
    buc = buc[:a] + buc[c:b+1] + buc[a:c] + buc[b+1:]

for i in range(n):
    print(buc[i], end=' ')