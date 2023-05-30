import math
import sys

n = int(sys.stdin.readline())
result = []

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    result.append(a*b/math.gcd(a, b))

for i in result:
    print(round(i))