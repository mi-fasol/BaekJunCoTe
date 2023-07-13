import math
import sys


def merge_sort(array, p, r):
    if p < r:
        q = math.floor((p+r)/2)
        merge_sort(array, p, q)
        merge_sort(array, q+1, r)
        merge(array, p, q, r)


def merge(array, p, q, r):
    global cnt, result
    i = p
    j = q + 1
    t = 1
    tmp = []
    while i <= q and j <= r:
        if array[i] <= array[j]:
            tmp.append(array[i])
            i += 1
        else:
            tmp.append(array[j])
            j += 1
    while i <= q:
        tmp.append(array[i])
        i+=1
    while j <= r:
        tmp.append(array[j])
        j+=1
    i = p
    t = 0
    while i <= r:
        array[i] = tmp[t]
        cnt += 1
        if cnt == k:
            result = array[i]
            break
        i += 1
        t += 1


n, k = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
cnt = 0
result = -1
merge_sort(arr, 0, n-1)
print(result)
