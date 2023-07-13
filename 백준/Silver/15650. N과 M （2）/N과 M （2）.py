from itertools import combinations

n, m = map(int, input().split())
ar = [i+1 for i in range(n)]

result = combinations(ar, m)

for i in result:
    for j in i:
        print(j, end=" ")
    print("")