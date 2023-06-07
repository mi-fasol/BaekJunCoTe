import sys

n = int(sys.stdin.readline())
a = {"ChongChong": 'True'}

for i in range(n):
    ap, bp = map(str, sys.stdin.readline().split())
    if ap not in a and bp not in a:
        a[ap] = 'False'
        a[bp] = 'False'
    else:
        if ap in a and bp in a:
            if a[ap] == 'True':
                a[bp] = 'True'
            elif a[bp] == 'True':
                a[ap] = 'True'
        else:
            if ap in a:
                if a[ap] == 'True':
                    a[bp] = 'True'
            elif bp in a:
                if a[bp] == 'True':
                    a[ap] = 'True'

r = [k for k, v in a.items() if v == "True"]

print(len(r))