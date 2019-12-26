import sys

numItems = int(sys.stdin.readline().strip()) #a number which is just the number of items on our menu
items = sys.stdin.readline().strip().split()
items = [int(item) for item in items] #getting the costs of each of the items on our menu

numOrders = int(sys.stdin.readline().strip()) #getting the total number of orders
orders = sys.stdin.readline().strip().split()
orders = [int(order) for order in orders] #getting the price of each order

#-1 means it is impossible to fulfill the order
#-2 means it is ambiguous to fill the order 
#anything greater than or equal to 0 means we have a unique solution for the order total

# numItems = 3
# items = [4,5,8]
# numOrders = 3
# orders = [11,13,14]

DP = [-1 for i in range(max(orders)+1)] 
DP[0] = 0

for i in range(0,numItems):
    for j in range(0,len(DP)):

        if DP[j] == -2 and j+items[i] < len(DP): #any solution that builds off of an ambiguous solution will be ambiguous too
            DP[j+items[i]] = -2
        
        elif DP[j] >= 0: #a solution that builds off of only one unique solution will be unique too
            if(j+items[i] < len(DP) and DP[j+items[i]] == -1):
                DP[j+items[i]] = i
            elif(j+items[i] < len(DP)):
                DP[j+items[i]] = -2 #this spot has already been visited, so it is ambiguous

# for index, element in enumerate(DP):
#     print("here is the index %d, here is the element %d" % (index,element))

#Now let's execute the print statements 
for order in orders:
    if(DP[order] == -1):
        print("Impossible")
    elif(DP[order] == -2):
        print("Ambiguous")
    else:
        amount = order

        itemsOrdered = []
        while amount > 0:
            itemNumber = DP[amount]

            itemsOrdered.append(itemNumber + 1)
            amount = amount - items[itemNumber]

        print(*sorted(itemsOrdered))
