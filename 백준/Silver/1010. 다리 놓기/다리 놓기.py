import sys
import math

for i in range(int(sys.stdin.readline())):
    n, k = map(int, sys.stdin.readline().split())
    if n >= k:
        print(math.comb(n, k))
    else:
        print(math.comb(k, n))