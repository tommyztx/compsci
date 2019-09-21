'''
use index number of halfway through to determine if desired number is greater  
than or less than or equal to the index number. Depending on the answer either
go halfway through the max of the list and the index number, go half way through between the min of the list and the index number,or print the item of the list.
Then there needs to be the same process to go through with the the index numbers that come from that process.


This is your first attempt at a binary search. The concept was good but too tedious for a longer list compile the singular digits into a while and use maximums and minimums to make the binary search.

#!/usr/bin/env python3
number_list=[1,2,3,4,5,6,7,8,9,10]
index1=number_list[0]
index2=number_list[1]
index3=number_list[2]
index4=number_list[3]
index5=number_list[4]
index6=number_list[5]
index7=number_list[6]
index8=number_list[7]
index9=number_list[8]
index10=number_list[9]
index=index6
if  index5 == index :
    print( index )
elif index < index5 :
    if index <= index3 :
        if index == index1 :
            print( index )
        elif index == index2 :
            print( index )
        elif index == index3 : 
            print( index )
    elif index >= index3 :
        if index == index4 :
            print( index )
elif index > index5 :
    if index <= index8 :
        if index == index6 :
            print( index )
        elif index == index7 :
            print( index )
        elif index == index8 :
            print( index )
    elif index >= index8 :
        if index == index9 :
            print( index )
        elif index == index10 :
            print( index )
elif index != n in number_list :
    print(-1)

'''


#!/usr/bin/env python3

number_list[2,20,34,44,50,67,71,75,98,103]

var value=71

var max=len(number_list)

var min=0

var mid index=var min + ((var max - var min)/2)

While Value != number_list[mid index] :
    if Value < number_list[mid index] :
        max=mid index
        mid index = min+((max-min)/2)
    elif Value > number_list[mid index] :
        min=mid index
        mid index = min+((max-min)/2)

print(mid index)

#if mid index < min or mid index > max :
#    print(-1)
