n = int(input())
num = list(map(int, input().split()))
cnt = 0

while True:
    for i in range(n):
        n_list = []
        for j in range(1, num[i] + 1):
            if num[i] % j == 0:
                n_list.append(j)
        set(n_list)
        if len(n_list) == 2:
            cnt += 1
    break
print(cnt)