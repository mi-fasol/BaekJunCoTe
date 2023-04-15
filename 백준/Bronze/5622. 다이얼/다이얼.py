num = input()
time = 0
alp = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

for i in range(len(num)):
    for j in alp:
        if num[i] in j:
            time += alp.index(j) + 3

print(time)