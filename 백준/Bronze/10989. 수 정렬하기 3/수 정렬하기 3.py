import sys

n = int(input())
r = [0] * 10001

for i in range(n):
    r[int(sys.stdin.readline())] += 1

for i in range(10001):
    if r[i] != 0:
        for j in range(r[i]):
            print(i)