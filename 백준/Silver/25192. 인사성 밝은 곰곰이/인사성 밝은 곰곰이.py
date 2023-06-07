import sys

n = int(sys.stdin.readline())
a = set()
cnt = 0

for i in range(n):
    m = input()
    if m == "ENTER":
        a.clear()
    else:
        if m not in a:
            cnt += 1
            a.add(m)

print(cnt)