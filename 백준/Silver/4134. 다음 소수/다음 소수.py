import math
import sys

n = int(sys.stdin.readline())


def find(a):
    if a == 0 or a == 1:
        return False
    for i in range(2, int(math.sqrt(a) + 1)):
        if a % i == 0:
            return False
    return True


for i in range(n):
    a = int(sys.stdin.readline())
    while True:
        if find(a):
            print(a)
            break
        else:
            a += 1
