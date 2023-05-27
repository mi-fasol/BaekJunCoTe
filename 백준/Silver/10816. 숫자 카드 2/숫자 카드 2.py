import sys
from collections import Counter

n = int(input())
arr1 = list(map(int, sys.stdin.readline().split()))
m = int(input())
arr2 = list(map(int, sys.stdin.readline().split()))
result = Counter(arr1)


for i in arr2:
    print(result[i], end=" ")