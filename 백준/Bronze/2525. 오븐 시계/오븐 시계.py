a, b = input().split()
c = int(input())

hour = (int(b) + int(c)) // 60
min = (int(b) + int(c)) % 60

if int(b) + c >= 60:
    if int(a) + hour >= 24:
        a = int(a) - 24
    a = int(a) + hour
    print(int(a), min)
else:
    if int(a) >= 24:
        a = int(a) - 24
    print(int(a), int(b)+c)