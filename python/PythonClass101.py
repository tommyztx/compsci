'''
Define a set which is a collection of random items.Where items are integers and
 strings. We have operations to a set:
1. +
Set a + Set b
Merge items in both sets and return a new set which is the combined set of a and
 b and duplicate items are not permitted.
2. -
Set a - Set b
Any items in Set b will be taken out from Set a and any items in Set a that
is not apparent in Set b will be left untouched. Return a set that gives the
results of the operation.
3. in
Set b in Set a
Return is true or false. If true Set a contains Set b False otherwise.
4. ==
Set a == Set b
Items in set a is the same as items in set b


(Under here is Optional)
 *
Set a * Integer n
Each item in Set a will duplicate n times. Return new set.
 /
Set a / Integer n
Divide the number of duplicates by n times. If the number of duplicates cannot
is not divisable then the number will be rounded up. Return the new set.
'''



#!/usr/bin/env python3

Set_A=['Danny',72,'Boy','Underwear',90,'Yolo',15]
Set_B=['Danny',32,'Boy','Shorts',94,'Volvo']
Set_C=Set_A
n=0
while n < len(Set_A) :
    if (Set_A[n] in Set_B) == False:
        n=n+1
        continue
    else:
        Set_C.pop(n)
        n=n+1
        continue
Set_c=Set_C+Set_B
print(Set_c)

'''
B-A
'''
Set_A=['Dargon',56,'Donald','ERIK',48,'From',56,98]
Set_B=['Dargon',56,'Donald','ERIK',95,'Grath',11]
Tup_B=tuple(Set_B)
for BItem in Tup_B:
    #print("BItem=",BItem)
    if (BItem in Set_A) == True:
        #print("taken out BITEM=",BItem)
        Set_B.remove(BItem)
print(Set_B)
