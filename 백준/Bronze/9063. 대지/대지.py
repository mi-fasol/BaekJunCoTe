n = int(input())
x1 = []
y1 = []

for i in range(n):
    x, y = map(int,input().split())
    x1.append(x)
    y1.append(y)

if n != 1:
    print((max(x1)-min(x1))*(max(y1)-min(y1)))
else:
    print(0)