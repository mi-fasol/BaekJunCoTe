good = [i for i in range(1, 31)]

for i in range(28):
    num = int(input())
    good.remove(num)

if good[0] > good[1]:
    a = good[1]
    good[1] = good[0]
    good[0] = a

print(good[0])
print(good[1])