r = []

for i in range(5):
    r.append(int(input()))

r.sort()

print(sum(r)//5)
print(r[2])