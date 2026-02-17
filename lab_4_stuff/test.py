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

print(sorted_get(prices_sorted, "Lego"))