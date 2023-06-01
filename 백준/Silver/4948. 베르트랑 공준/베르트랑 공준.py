import math
import sys


def find(a):
    if a == 0 or a == 1:
        return False
    for num in range(2, int(math.sqrt(a) + 1)):
        if a % num == 0:
            return False
    return True


l = list(range(2, 123456*2))
result = []

for i in l:
    if find(i):
        result.append(i)

while True:
    n = int(sys.stdin.readline())
    cnt = 0
    if n == 0:
        break
    for i in result:
        if n < i <= 2*n:
            cnt += 1
    print(cnt)