import pickle
#import json

#method for setting the data
def animal_data():
    ani_id= str(input("Please enter the animals shelter ID: "))
    ani_name= str(input("Please enter the animals name: "))
    ani_breed= str(input("Please enter the breed of animal: "))
    ani_sex= str(input("Male or Female? (Please enther M or F): "))
    ani_age= int(input("Please enther the estimated age of the animal: "))
    #ani_chip= str(input("Please enther the microchip number (if not present enter None): "))
    print()

#creation of dictionary to hold info
    rescue = {}
    rescue ['ani_id'] = ani_id
    rescue ['ani_name'] = ani_name
    rescue ['ani_breed'] = ani_breed
    rescue ['ani_sex'] = ani_sex
    rescue ['ani_age'] = ani_age
    #rescue ['ani_chip'] = ani_chip

    return rescue

def display_data(rescue):
    print('Shelter ID: ', rescue['ani_id'])
    print('Name: ', rescue['ani_name'])
    print('Breed: ', rescue['ani_breed'])
    print('Sex: ', rescue['ani_sex'])
    print('Age: ', rescue['ani_age'])
    #print('Microchip No: ', rescue['ani_chip'])
    print()

def write_record():
    #open the file in binary mode to WRITE.
    with open('animal_shelter.txt', 'ab') as file_write:
    #file_write = open('animal_shelter.txt', 'ab') #use txt or dat??

    #serialization of object and writing to file
        pickle.dump(animal_data(), file_write)
    
    #file_write.close()

def read_record():
    #open in binary mode to READ
    with open('animal_shelter.txt', 'rb') as file_read:
    #file_read = open('animal_shelter.txt', 'rb')
   
    #to read onto the end of our file
        while True:
            try:
            #reading from our file
                residents = pickle.load(file_read)
        
                display_data(residents)
                flag = True
                break
        
            except:
                EOFError()
                break
    
    #file_read.close()

def search_record():
    with open('animal_shelter.txt', 'rb') as file_search:
    #file_search = open('animal_shelter.txt', 'rb')
        animal_id = str(input("Enter the Shelter ID to search: "))
        flag= True #flagging to let prog know not to run this CONTINUOUSLY

        while True:
            try:
            #read the object from the file
                resident = pickle.load(file_search)

                if resident['ani_id'] == animal_id:
                    display_data(resident)
                    #Flag = True
                    break
        
            except:
                EOFError()
                print("Record not found!")
                break

        #if flag == False:
           # print("RECORD NOT FOUND")
            #print()

    #file_search.close()

#ADD METHOD FOR DELETION!!!!!!!!!!!!!
def menu_choices():
    print("MENU\n~~~~~~~")
    print("1.\tADD Record")
    print("2.\tDISPLAY Records ")
    print("3.\tSEARCH for a Record")
    print("4,\tEXIT")
    print("~~~~~~~~")
    #ADD FOR DELETION

#now to make the menu (hopefully) work

def main():
    while(True):
        menu_choices()
        choice = input("Please choose from the menu the action you wish to take.\n\
            Enter 1, 2, 3, or 4:")
        print()

        if choice == "1":
            write_record()

        elif choice == "2":
            read_record()

        elif choice == "3":
            search_record()
        
        elif choice == "4":
            break

        #DON'T FORGET THE D IN CRUD! Can't spell Crud w/o delete, Caoimhe
        
        else:
            print("INVALID INPUT! Why must you make my life difficult?")

#call back our main function
main()

    





