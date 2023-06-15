import sys

n = int(sys.stdin.readline())

for i in range(n):
    a = sys.stdin.readline()
    cnt = 0
    for j in a:
        if j == '(':
            cnt += 1
        elif j == ')':
            cnt -= 1
        if cnt < 0:
            break

    if cnt == 0:
        print('YES')
    else:
        print('NO')