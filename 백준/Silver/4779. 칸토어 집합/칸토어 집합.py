while True:
    try:
        n = int(input())
        if n == 0:
            print("-")
        else:
            for i in range(n):
                tmp = "-"
                for j in range(i+1):
                    tmp = tmp+" "*len(tmp)+tmp
            print(tmp)
    except EOFError:
        break
