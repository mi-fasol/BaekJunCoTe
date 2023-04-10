n = int(input())
arr = list(map(int, input().split()))
max = arr[0]
min = arr[0]

for i in range(1, n):
    if arr[i] > max:
        max = arr[i]
    elif arr[i] < min:
        min = arr[i]

print(min, max)