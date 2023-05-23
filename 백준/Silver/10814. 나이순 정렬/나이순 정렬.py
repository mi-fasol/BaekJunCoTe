n = int(input())

arr = []

for i in range(n):
    [a, b] = input().split()
    arr.append([a, b])

arr = sorted(arr, key=lambda x: (int(x[0])))

for i in range(len(arr)):
    print(arr[i][0] +" " + arr[i][1])