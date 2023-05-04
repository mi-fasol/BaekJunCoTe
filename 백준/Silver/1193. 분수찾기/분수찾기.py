n = int(input())
bun = 1

while n > bun:
    n -= bun
    bun += 1

if bun % 2 == 0:
    a = n
    b = bun - n + 1
else:
     a = bun - n + 1
     b = n
print(f"{a}/{b}")