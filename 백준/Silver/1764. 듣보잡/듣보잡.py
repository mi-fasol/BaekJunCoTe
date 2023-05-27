import sys

n, m = map(int, sys.stdin.readline().split())
a = []
b = []
for i in range(n):
    a.append(input())

for i in range(m):
    b.append(input())

result = list(set(a) & set(b))
print(len(result))
for i in sorted(result):
    print(i)