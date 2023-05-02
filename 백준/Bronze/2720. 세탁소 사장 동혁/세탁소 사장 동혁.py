n = int(input())
chan = [25, 10, 5, 1]
all = [0] * 4

for i in range(n):
    a = int(input())
    for j in range(4):
        all[j] = a // chan[j]
        a = a - all[j]*chan[j]
        print(all[j], end = " ")