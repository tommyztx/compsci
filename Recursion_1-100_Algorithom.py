#! user/bin/env python3

x=100
def sum(x):
    if x == 1:
        return 1
    else:
        return x + sum(x-1)
total=x+sum(x-1)
print(total)
