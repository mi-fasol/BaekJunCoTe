c = int(input())

for i in range(c):
    num = list(map(int, input().split()))
    avg = sum(num[1:])/num[0]
    cnt = 0
    for j in num[1:]:
        if j > avg:
            cnt += 1
    rate = '{:.3f}'.format(round(cnt/num[0]*100, 3))
    print(rate, "%")