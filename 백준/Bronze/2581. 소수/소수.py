m = int(input())
n = int(input())
total = []

for i in range(m, n+1):
    if i == 2:
        total.append(i)
    else:
        for j in range(2, i+1):
            if i % j == 0:
                break
            elif j == i-1:
                total.append(i)

if len(total) > 0:
    print(sum(total))
    print(total[0])
else:
    print(-1)
