total = int(input())
number = int(input())
count = []
sum = 0

for i in range(0, number):
    price, product = map(int, input().split())
    count.append(product * price)
    sum += count[i]

if sum == total:
    print("Yes")
else:
    print("No")
