def commonality(*num_of_lists):
    animals = set()
    animals_lists = set(num_of_lists)
    for animal in num_of_lists:
            animals.update(animal)
    animals.intersection(animals_lists)
    print(animals)
    return animals

dense_forest = ["howler monkey", "sloth", "chipmunk", "toucan", "leafcutter ant", "sloth", "tarantula", "pit viper"]
cave = ["pit viper", "bat", "leafcutter ant", "pit viper", "tarantula", "tadpole"]
volcano = ["tarantula", "parrot", "pit viper", "leafcutter ant", "tarantula", "grasshopper"]

common_animals = commonality(dense_forest, cave, volcano)

assert common_animals == {'leafcutter ant', 'tarantula', 'pit viper'}
