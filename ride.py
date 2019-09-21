#! /usr/bin/env python3

# ID:tommyzh2
# LANG:Python3
# TASK:ride 

Codes = []

with open("ride.in", "r") as fp:
    for s in fp:
        total = 1
        for c in s.strip():
            value = ((ord(c) - ord("A"))+1)
#            print(c,value)
            total *= value
#        print(total)
        Codes.append(total % 47)
#print(Codes)

if Codes[0] == Codes[1]:
    with open("ride.out", "w") as wp:
        wp.write("GO")
        wp.write("\n")
else:
    with open("ride.out", "w") as wp:
        wp.write("STAY")
        wp.write("\n")
exit(0)
