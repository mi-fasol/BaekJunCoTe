n = int(input())
sum = 0

for i in range(n):
    no = 0
    str = input()
    group = [""] * (len(str) - 1)
    for j in range(len(str) - 1):
        if str[j] != str[j + 1]:
            if str[j+1] in group:
                no = 1
                break
            else:
                group[j] = str[j]
    if no == 0:
        sum += 1

print(sum)