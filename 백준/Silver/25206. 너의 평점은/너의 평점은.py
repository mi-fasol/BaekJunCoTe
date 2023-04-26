r = ["A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "P", "F"]
s = [4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0]
allScore = [0.0] * 20
avs = 0.0

for i in range(20):
    name, score, rate = input().split()
    if rate != "P":
        allScore[i] = float(score)
    else:
        allScore[i] = 0.0
    avs += float(score) * s[r.index(rate)]

print(format(avs/sum(allScore), '.6f'))