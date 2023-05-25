n, m = map(int, input().split())
cnt = 0
set1 = set([input() for _ in range(n)])

for _ in range(m):
    set2 = input()
    if set2 in set1:
        cnt += 1

print(cnt)