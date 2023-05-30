import math
import sys

result = []

a, b = map(int, sys.stdin.readline().split())
result.append(a*b/math.gcd(a, b))

for i in result:
    print(round(i))