def count_coins(list):
    counted_coins = {"pennies": 0,
                     "quarters": 0,
                     "dimes": 0,
                     "nickels": 0
                     }
    for num in list:
        if num == 25:
            counted_coins["quarters"] += 1
        if num == 10:
            counted_coins["dimes"] += 1
        if num == 5:
            counted_coins["nickels"] += 1
        if num == 1:
            counted_coins["pennies"] += 1
    return counted_coins


coins = [1, 25, 1, 25, 1, 10, 5]  
counted_coins = count_coins(coins) 
assert counted_coins == {"pennies": 3,
                         "quarters": 2,
                         "dimes": 1,
                         "nickels": 1}
print("PASSED")