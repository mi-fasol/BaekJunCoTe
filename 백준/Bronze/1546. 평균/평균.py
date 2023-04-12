n = int(input())
score = list(map(int, input().split()))
new_score = [0.0 for i in range(n)]

max = max(score)

for i in range(n):
    new_score[i] = score[i]/max*100

print(sum(new_score)/n)