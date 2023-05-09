tx = []
ty = []

for i in range(3):
    x, y = map(int, input().split())
    tx.append(x)
    ty.append(y)

gapx = max(tx) - min(tx)
gapy = max(ty) - min(ty)

if tx.count(min(tx)) == 2:
    if ty.count(min(ty)) == 2:
        print(min(tx) + gapx, min(ty) + gapy)
    else:
        print(min(tx) + gapx, min(ty))
else:
    if ty.count(min(ty)) == 2:
        print(min(tx), min(ty) + gapy)
    else:
        print(min(tx), min(ty))