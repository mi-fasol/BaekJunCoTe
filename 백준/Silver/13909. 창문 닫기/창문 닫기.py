import sys
import math

n = int(sys.stdin.readline())
print(math.floor(pow(n, 0.5)))
#
# 1 - 1
# 2 - 1
# 3 - 1
# 4 -  1 0 0 1 - 2
# 5 - 1 0 0 1 0 - 2
# 6 - 1 0 0 1 0 0 - 2
# 7 - 1 0 0 1 0 0 0 - 2
# 8 - 1 0 0 1 0 0 0 0 - 2
# 9 - 1 0 0 1 0 0 0 0 1 - 3