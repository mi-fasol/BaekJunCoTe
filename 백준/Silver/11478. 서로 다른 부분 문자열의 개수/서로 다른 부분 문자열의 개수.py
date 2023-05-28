import sys

str = sys.stdin.readline()
dic = set()

for i in range(len(str)):
    for j in range(i+1, len(str)):
        s = str[i: j]
        dic.add(s)

print(len(dic))