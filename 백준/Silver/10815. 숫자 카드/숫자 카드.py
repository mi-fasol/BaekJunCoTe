n = int(input())
s_arr = list(map(int, input().split()))
m = int(input())
c_arr = list(map(int, input().split()))
dic = {}

for i in range(len(s_arr)):
    dic[s_arr[i]] = 0

for i in range(len(c_arr)):
    if c_arr[i] in dic:
        print(1, end=" ")
    else:
        print(0, end=" ")