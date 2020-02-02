#! usr/env/bin python3
import random
import sys
if int(sys.argv[1]) > int(sys.argv[2]):
    print("Argument 1 is larger than Argument 2")
    exit(1)
RandList=[]
i=0
while i < int(sys.argv[1]):
    RandNum= random.randint(0,int(sys.argv[2]))
    if RandNum in RandList:
        continue
    RandList.append(RandNum)
    i=i+1
    
print(RandList)
