def multiply_items(list, int):
    new_list = []
    for item in list:
        for j in range(int):
            new_list.append(item)
    print(new_list) 
    return new_list     

things = ["apple", 3, 4.0]
assert multiply_items(things, 3) == ["apple", "apple", "apple", 3, 3, 3, 4.0, 4.0, 4.0]