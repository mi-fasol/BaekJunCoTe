word = list(str(input().upper()))
w = list(set(word))
most = "?"
total = []

for i in w:
    cnt = word.count(i)
    total.append(cnt)

if(total.count(max(total))) == 1:
    max_a = total.index(max(total))
    print(w[max_a])
else:
    print(most)