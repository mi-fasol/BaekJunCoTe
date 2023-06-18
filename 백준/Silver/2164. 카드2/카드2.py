import sys
from collections import deque

queue = deque([i+1 for i in range(int(sys.stdin.readline()))])

while True:
    if len(queue) == 1:
        break
    else:
        queue.popleft()
        tmp = queue[0]
        queue.popleft()
        queue.append(tmp)

print(queue[0])