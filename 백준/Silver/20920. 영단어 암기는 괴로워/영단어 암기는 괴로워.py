import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
w = {}

for i in range(n):
    word = sys.stdin.readline().rstrip()
    if len(word) >= m:
        if word in w:
            w[word] += 1
        else:
            w[word] = 1

w = sorted(w.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for i in w:
    print(i[0])