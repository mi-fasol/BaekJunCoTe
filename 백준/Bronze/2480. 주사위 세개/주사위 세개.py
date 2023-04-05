a, b, c = input().split()

if(a == b and b == c):
    print(10000+(int(a)*1000))
elif(a==b and a!=c): print(1000+(int(a)*100))
elif(a==c and a!=b):print(1000+(int(a)*100))
elif(b==c and b !=a):print(1000+(int(b)*100))
else:
    if(a> b and a>c): print(int(a)*100)
    elif(b>a and b>c): print(int(b)*100)
    else: print(int(c)*100)