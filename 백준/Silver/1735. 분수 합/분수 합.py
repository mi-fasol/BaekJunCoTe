import sys
import math

a = []
b = []

for i in range(2):
    n, m = map(int, sys.stdin.readline().split())
    a.append(n)
    b.append(m)

result = [a[0]*b[1] + a[1]*b[0], b[0]*b[1]]
c = math.gcd(result[0], result[1])

print(result[0]//c, result[1]//c)