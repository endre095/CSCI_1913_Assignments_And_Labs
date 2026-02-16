import random

def create_list(size):
    return_list = []
    for i in range(size):
        random_int = random.randint(0,1000)
        return_list.append(random_int)
    return return_list
test = [0,2,7,12,17,25,40]

def binary_search(list, value):
    high = len(list)-1
    low = 0
    while low <= high:
        middle = (high-low)//2
        if list[int(middle)] == value:
            return middle
        elif value < list[int(middle)]:
            low = middle-1
        else:
            high = middle+1
    return -1

print(binary_search(test, 7))
print(create_list(10))