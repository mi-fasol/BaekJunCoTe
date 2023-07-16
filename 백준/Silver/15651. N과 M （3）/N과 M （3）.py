import itertools

n, m = map(int, input().split())
ar = [i+1 for i in range(n)]

result = list(itertools.product(ar, repeat=m))

for i in result:
    for j in i:
        print(j, end=" ")
    print()