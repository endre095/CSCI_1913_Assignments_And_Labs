'''
sorted_put(pricebook, name, price)
'''

prices = [(80.0, 'Lego'),
          (690.0, 'Laptop'),
          (300.0, 'Camera'),
          (5.9, 'Knife'),
          (194.4, 'Headphone')]
prices_sorted = [(300.0, 'Camera'),
                 (194.4, 'Headphone'), 
                 (5.9, 'Knife'), 
                 (690.0, 'Laptop'), 
                 (80.0, 'Lego')]

""" This function takes in a list and compares its name values 
alphabetically to see if it is in order"""
def is_sorted(pricebook):
    if len(pricebook) == 0:
        return True
    for j in range(len(pricebook)):
        if j + 1 >= len(pricebook):
            return True
        if pricebook[j][1] > pricebook[j+1][1]:
            return False
        
""" This function goes through the given list and adds up the prices
from each list and then divides by the length of the list to give the
average"""
def price_average(pricebook):
    if len(pricebook) == 0:
        return 0.0
    sum = 0
    for i in range(len(pricebook)):
        sum += pricebook[i][0]
    return (sum/len(pricebook))

"""This function searches through the given list linearly to determine
if the given name is in the list, and if so it returns its corresponding
value"""
def unsorted_get(pricebook, name):
    for i in range(len(pricebook)):
        if pricebook[i][1] == name:
            return pricebook[i][0]
    return None

""" This function searches through the given list for a specific name of a 
product, if that product is found it assigns it with its new price, if not
it appends it to the end of the list"""
def unsorted_put(pricebook, name, price):
    found = False
    for i in range(len(pricebook)):
        if pricebook[i][1] == name:
            pricebook[i] = list(pricebook[i])
            pricebook[i][0] = price
            pricebook[i] = tuple(pricebook[i])
            found = True
    if found == False:
        temp_tuple = (price, name)
        pricebook.append(temp_tuple)

""" This function uses a binary search to go through a sorted list and 
returns the value associated with the name given"""
def sorted_get(pricebook, name):
    high = len(pricebook)-1
    low = 0
    while low <= high:
        middle = (high+low)//2
        if pricebook[middle][1] == name:
            return pricebook[middle][0]
        elif name < pricebook[middle][1]:
            high = middle-1
        else:
            low = middle+1
    return None

"""This function is given a list, name, and price. It creates a 
tuple with the given parameters for potential insertion into the
orignial list. If the name is found the price is updated accordingly,
if the name is not found, it is determined where to put the new tuple
according to alphabetical order."""
def sorted_put(pricebook, name, price):
    found = False
    temp_tuple = (price, name)
    for i in range(len(pricebook)):
        if pricebook[i][1] == name:
            pricebook[i] = list(pricebook[i])
            pricebook[i][0] = price
            pricebook[i] = tuple(pricebook[i])
            found = True
    if found == True:
        return
    if name < pricebook[0][1]:
        temp_tuple = (price, name)
        pricebook.insert(0, temp_tuple)
        return
    if name > pricebook[len(pricebook)-1][1]:
        temp_tuple = (price, name)
        pricebook.append(0, temp_tuple)
        return
    else:
        for i in range(1, len(pricebook)-2):
            if pricebook[i][1] > name:
                pricebook.insert(i,temp_tuple)
    return
    


