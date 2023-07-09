from itertools import permutations
import sys

n, m = map(int, sys.stdin.readline().split())
a = [i+1 for i in range(n)]
result = permutations(a, m)

for i in result:
    for j in i:
        print(j, end=" ")
    print("")