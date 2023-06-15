while True:
    a = input()
    stack = []
    cnt = 0
    if a == '.':
        break
    else:
        for i in a:
            if i == '(' or i == '[':
                cnt += 1
                stack.append(i)
            elif i == ')':
                if len(stack) != 0 and stack[-1] == '(':
                    stack.pop()
                    cnt -= 1
                else:
                    stack.append(')')
                    break
            elif i == ']':
                if len(stack) != 0 and stack[-1] == '[':
                    stack.pop()
                else:
                    stack.append(')')
                    break
    if len(stack) == 0:
        print('yes')
    else:
        print('no')
