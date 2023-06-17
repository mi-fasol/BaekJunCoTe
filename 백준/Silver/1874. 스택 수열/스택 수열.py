import sys

stack = []

n = int(sys.stdin.readline())
default = 1
result = []
is_impossible = 0

for i in range(n):
    a = int(sys.stdin.readline())
    while default <= a:
        stack.append(default)
        default += 1
        result.append("+")
    if stack[-1] == a:
        stack.pop()
        result.append("-")
    else:
        print("NO")
        is_impossible = 1
        break

if is_impossible == 0:
    for i in result:
        print(i)