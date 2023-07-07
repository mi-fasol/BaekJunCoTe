import sys
from collections import deque

n = int(sys.stdin.readline())

for i in range(n):
    cmd = sys.stdin.readline().rstrip()
    num = int(sys.stdin.readline())
    arr = deque(sys.stdin.readline().rstrip()[1:-1].split(','))
    is_reversed = 0
    if num == 0:
        arr = deque()
    for j in cmd:
        if j == "R":
            is_reversed += 1
        elif j == "D":
            if len(arr) == 0:
                print("error")
                break
            else:
                if is_reversed % 2 == 0:
                    arr.popleft()
                else:
                    arr.pop()
    else:
        if is_reversed % 2 == 0:
            print("["+",".join(arr)+"]")
        else:
            print("["+",".join(reversed(arr))+"]")
