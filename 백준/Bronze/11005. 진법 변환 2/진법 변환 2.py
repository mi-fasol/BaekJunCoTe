import string

num, ari = input().split()

tmp = string.digits + string.ascii_uppercase


def convert(n, q):
    a, b = divmod(n, q)
    if a == 0:
        return tmp[b]
    else:
        return convert(a, q) + tmp[b]


print(convert(int(num), int(ari)))