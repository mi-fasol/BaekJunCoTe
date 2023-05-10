while True:
    arr = list(map(int, input().split()))
    if arr[0] != 0 and max(arr) >= (sum(arr) - max(arr)):
        print("Invalid")
    else:
        if len(set(arr)) == 1:
            if arr[0] == 0:
                break
            else:
                print("Equilateral")
        elif len(set(arr)) == 2:
            print("Isosceles")
        else:
            print("Scalene")