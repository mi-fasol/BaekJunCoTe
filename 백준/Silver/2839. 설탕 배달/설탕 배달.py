kg = int(input())
a = 0
b = 0

while kg >= 0:
    if kg % 5 == 0:
        a = kg//5
        print(a+b)
        break
    else:
        kg -= 3
        b += 1
else:
    print(-1)