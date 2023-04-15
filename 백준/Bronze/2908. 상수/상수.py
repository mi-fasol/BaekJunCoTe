a, b = input().split()
a1 = a[::-1]
b1 = b[::-1]

if int(a1) > int(b1):
    print(a1)
else:
    print(b1)