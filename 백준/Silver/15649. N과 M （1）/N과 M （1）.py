import sys


def sol():
    if len(result) == m:
        print(" ".join(map(str, result)))
        return
    else:
        for i in range(1, n+1):
            if i not in result:
                result.append(i)
                sol()
                result.pop()


result = []
n, m = map(int, sys.stdin.readline().split())
sol()