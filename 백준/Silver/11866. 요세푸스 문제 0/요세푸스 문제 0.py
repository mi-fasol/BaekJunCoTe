import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
queue = deque([i+1 for i in range(n)])

print("<", end="")
while True:
    if len(queue) == 1:
        print(queue[0], end=">")
        break
    else:
        for i in range(k-1):
            queue.append(queue[0])
            queue.popleft()
        print(queue.popleft(), end=", ")