n, k = map(int, input().split())
r = list(map(int, input().split()))
r.sort()

print(r[n-k])