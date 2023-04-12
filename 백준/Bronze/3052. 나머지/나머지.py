arr = [0] * 10

for i in range(10):
    num = int(input())
    arr[i] = (num % 42)

result = list(set(arr))

print(len(result))