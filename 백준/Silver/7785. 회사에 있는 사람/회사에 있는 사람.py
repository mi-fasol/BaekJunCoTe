n = int(input())
dic = {}

for i in range(n):
    name, state = input().split()
    dic[name] = state

dic = {key:value for key, value in dic.items() if value != "leave"}

dic = sorted(dic, reverse=True)

for k in dic:
    print(k)