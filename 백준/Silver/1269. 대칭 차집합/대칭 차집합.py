import sys

n, m = map(int, sys.stdin.readline().split())
a = set(map(int, sys.stdin.readline().split()))
b = set(map(int, sys.stdin.readline().split()))

a1 = [i for i in a if i not in b]
b1 = [i for i in b if i not in a]

print(len(a1) + len(b1))