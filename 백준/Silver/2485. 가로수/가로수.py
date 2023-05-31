import sys
from math import gcd

n = int(sys.stdin.readline())
first = int(sys.stdin.readline())
a = []

for i in range(n-1):
    new = int(sys.stdin.readline())
    a.append(new - first)
    first = new

c = a[0]

for i in range(1, len(a)):
    c = gcd(c, a[i])

result = 0
for i in a:
    result += i // c - 1
print(result)