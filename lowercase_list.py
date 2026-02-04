def lowercase_list(list):
    for count, item in enumerate(list):
        list[count] = item.lower()
    print(list)
    return list    

fruit = ["APPLE", "BANANA", "PEAR"]
lowercase_list(fruit)
assert fruit == ["apple", "banana", "pear"]