import pickle

#Creation of nested dictionary to hold animal data.
#A dictionary of dictionaries

pet_profiles = {
    1111 : {
        "Shelter_ID": 1111, #make the ID the profile name???
        "Name": "Maggie",
        "Age": 3,
        "Sex": "F",
        "Species": "Cat",
        "Breed": "British Domestic Shorthair"
    },

    1112:{
        "Shelter_ID": 1112,
        "Name": "Sherlock",
        "Age": 1,
        "Sex": "M",
        "Species": "Dog",
        "Breed": "Basset Hound"
    },

    1113: {
        "Shelter_ID": 1113,
        "Name": "Jack",
        "Age": 6,
        "Sex": "M",
        "Species": "Dog",
        "Breed": "Jack Russel Terrier"
    },

    1114: {
        "Shelter_ID": 1114,
        "Name": "Simon",
        "Age": 2,
        "Sex": "M",
        "Species": "Cat",
        "Breed": "Ginger Shorthair Tabby"
    },

    1115: {
        "Shelter_ID": 1115,
        "Name": "Lady",
        "Age": 5,
        "Sex": "F",
        "Species": "Dog",
        "Breed": "Cocker Spaniel"
    },
    1116: {
        "Shelter_ID": 1116,
        "Name": "Sassy",
        "Age": 1,
        "Sex": "F",
        "Species": "Cat",
        "Breed": "Calico"
    },
    1117: {
        "Shelter_ID": 1117,
        "Name": "Dennis",
        "Age": 9,
        "Sex": "M",
        "Species": "Dog",
        "Breed": "Yellow Labrador"
    }
 
}
#METHOD USED TO PICKLE THE NESTED LIBRARY. PICKLE.DUMP() TO SERIALIZE THE DATA
with open('animalshelter.txt', 'ab') as file_write:
    pickle.dump(pet_profiles, file_write)
    print("Complete")

#METHOD USED TO READ THE PICKLE FILE. PICKLE.LOAD() TO DE-SERIALIZE
with open('animalshelter.txt', 'rb') as read_file:
    while True:
            try:
            #reading from our file
                residents = pickle.load(read_file)
        #USING A FOR LOOP TO ITERATE THROUGH OUR NESTED DICTIONARY
                for pet_id, pet_info in residents.items():
                    print("\nPet ID:", pet_id)

                    for key in pet_info:
                        print(key + ':', pet_info[key])

                flag = True
                break
        
            except:
                EOFError()
                break
