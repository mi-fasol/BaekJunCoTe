n = int(input())
r = []

for i in range(n):
    r.append(int(input()))

r.sort()
for i in range(n):
    print(r[i])