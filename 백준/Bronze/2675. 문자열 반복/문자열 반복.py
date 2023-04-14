n = int(input())

for i in range(n):
    r, s = input().split()
    for j in s:
        print(j*int(r), end='')
    print()