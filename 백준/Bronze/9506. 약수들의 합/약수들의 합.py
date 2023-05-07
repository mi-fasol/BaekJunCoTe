while True:
    a = int(input())
    ar = []
    sum = 0
    if a == -1:
        break
    else:
        for i in range(1, a+1):
            if a % i == 0:
                ar.append(i)
        ar.remove(a)
        for i in range(len(ar)):
            sum += ar[i]
        if sum == a:
            print(a, "=", end=" ")
            for i in range(len(ar) -1):
                 print(ar[i], end =" + ")
            print(ar[len(ar)-1])
        else:
            print(a, "is NOT perfect.")