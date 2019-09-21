#! /user/bin/env python3

num=2
total=1
while num >0:
    if num == 101:
        break
    prevnum=num
    total=prevnum+total
    num=num+1
    print(num)
print(total)
