import sys
from collections import Counter

n = int(sys.stdin.readline())
r = []

for i in range(n):
    a = int(sys.stdin.readline())
    r.append(a)

print(round(sum(r)/n))
r = sorted(r)
print(r[round(n//2)])
cnt = Counter(r).most_common()
if len(cnt) > 2 and cnt[0][1] == cnt[1][1]:
    print(cnt[1][0])
else:
    print(cnt[0][0])
print(max(r) - min(r))