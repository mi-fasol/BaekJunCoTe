n = int(input())

for i in range(1, n+1):
    result = sum((map(int, str(i))))
    total = result + i
    if total == n:
        print(i)
        break
    if i == n:
        print(0)