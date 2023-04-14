str = input()
alphabet = 'abcdefghijklmnopqrstuvwxyz'

for i in alphabet:
    if i in str:
        print(str.index(i), end= ' ')
    else:
        print("-1", end = ' ')