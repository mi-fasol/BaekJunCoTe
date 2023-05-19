import sys

n = int(input())
r = []

for i in range(n):
    r.append(int(sys.stdin.readline()))

r.sort()
for i in range(n):
    print(r[i])