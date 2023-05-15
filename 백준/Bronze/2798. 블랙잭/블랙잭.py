import itertools
n, m = map(int, input().split())
a = list(map(int, input().split()))

sum_of_card = [sum(i) for i in itertools.combinations(a, 3) if sum(i) <= m]

print(max(sum_of_card))