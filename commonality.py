def commonality(*num_of_lists):
    new_set = set(num_of_lists[0])
    for lists in num_of_lists:
       #temp_set = set(lists)
       new_set = new_set.intersection(lists)
    print(new_set)
    return new_set

dense_forest = ["howler monkey", "sloth", "chipmunk", "toucan", "leafcutter ant", "sloth", "tarantula", "pit viper"]
cave = ["pit viper", "bat", "leafcutter ant", "pit viper", "tarantula", "tadpole"]
volcano = ["tarantula", "parrot", "pit viper", "leafcutter ant", "tarantula", "grasshopper"]

common_animals = commonality(dense_forest, cave, volcano)

assert common_animals == {'leafcutter ant', 'tarantula', 'pit viper'}
