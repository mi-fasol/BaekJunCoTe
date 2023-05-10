a = [int(input()) for i in range(3)]

if len(set(a)) == 1 and a[0] == 60:
    print("Equilateral")
elif sum(a) == 180 and len(set(a)) == 2:
    print("Isosceles")
elif sum(a) == 180 and len(set(a)) == 3:
    print("Scalene")
else:
    print("Error")