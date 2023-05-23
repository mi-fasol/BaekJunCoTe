import sys

n = int(sys.stdin.readline())

a = list(map(int, sys.stdin.readline().split()))

arr = sorted(set(a))

dic = {arr[i]: i for i in range(len(arr))}

for i in a:
    print(dic[i], end = " ")