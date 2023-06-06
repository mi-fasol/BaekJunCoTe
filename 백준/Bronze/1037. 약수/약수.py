import sys

n = int(sys.stdin.readline())
l = list(map(int, sys.stdin.readline().split()))

lcm = 0

if n == 1:
    print(pow(l[0], 2))
else:
   print(max(l)*min(l))