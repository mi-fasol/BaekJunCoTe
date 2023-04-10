array = list(0 for i in range(9))
max = array[0]
c = 0

for i in range(9):
    a = int(input())
    array[i] = a
    if array[i] > max:
        max = array[i]
        c = i+1

print(max)
print(c)