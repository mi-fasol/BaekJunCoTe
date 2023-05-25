import sys

n, m = map(int, sys.stdin.readline().split())
dic = {}
dic2 = {}

for i in range(n):
    a = sys.stdin.readline().rstrip()
    dic[i+1] = a
    dic2[a] = i+1

for i in range(m):
    a = sys.stdin.readline().rstrip()
    if a.isdigit():
        print(dic[int(a)])
    else:
        print(dic2[a])