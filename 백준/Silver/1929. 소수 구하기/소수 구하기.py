import math
import sys

n, m = map(int, sys.stdin.readline().split())


def find(a):
    if a == 0 or a == 1:
        return False
    for i in range(2, int(math.sqrt(a) + 1)):
        if a % i == 0:
            return False
    return True

for i in range(n, m+1):
    if find(i):
        print(i)