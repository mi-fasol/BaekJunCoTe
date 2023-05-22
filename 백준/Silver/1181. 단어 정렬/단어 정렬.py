n = int(input())

arr = set(list(input() for _ in range(n)))
arr = sorted(arr)
arr = sorted(arr, key=lambda x: (len(x)))

for i in arr:
    print(i)