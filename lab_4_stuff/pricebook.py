'''
sorted_get(pricebook, name)
sorted_put(pricebook, name, price)
'''

prices = [(80.0, 'Lego'),
          (690.0, 'Laptop'),
          (300.0, 'Camera'),
          (5.9, 'Knife'),
          (194.4, 'Headphone')]

def is_sorted(pricebook):
    if len(pricebook) == 0:
        return True
    for j in range(len(pricebook)):
        if j + 1 >= len(pricebook):
            return True
        if pricebook[j][1] > pricebook[j+1][1]:
            return False

def price_average(pricebook):
    if len(pricebook) == 0:
        return 0.0
    sum = 0
    for i in range(len(pricebook)):
        sum += pricebook[i][0]
    return (sum/len(pricebook))

def unsorted_get(pricebook, name):
    for i in range(len(pricebook)):
        if pricebook[i][1] == name:
            return pricebook[i][0]
    return None

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

def sorted_get(pricebook, name):
    for i in range(len(pricebook)):
        if pricebook[i][1] == name:
            return pricebook[i][0]
    return None



def sorted_get(pricebook, name):
    high = len(pricebook)-1
    low = 0
    while low <= high:
        middle = (high-low)/2
        if pricebook[int(middle)][1] == name:
            return pricebook[int(middle)][0]
        elif name < pricebook[int(middle)][1]:
            low = middle-1
        else:
            high = middle+1
    return None


print(sorted_get(prices, "Lego"))
print("done")

