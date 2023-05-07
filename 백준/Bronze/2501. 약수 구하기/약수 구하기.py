n, k = map(int, input().split())
ar = []
s = {0}

for i in range(1, n+1):
    if n % i == 0:
        ar.append(i)

if len(ar) < k:
    print(0)
else:
    print(ar[k - 1])