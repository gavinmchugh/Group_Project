import pickle
import tkinter as tk
from tkinter import DISABLED, StringVar, ttk
from datetime import date
from turtle import bgcolor

today=date.today()

# dictionary to use throughout the program, takes the data from the file at startup and is maintained in the code the match with file at all times
test = {}

#hold the currentIndex for filling the entry boxes with data from the dictionary at this position, start at 0 for first row
listIndexes = []##need to include this in the addEntry() and deleteEntry() functions so that this gets updated in tandem with the dictionary
currentIndex = 1
""" 

#to access elements of dictionary
print(test['IDPlaceholder1']['key_1'])

#to delete entries in nested dictionary
print("Before Delete:\n")
print(test)
del test['IDPlaceholder2']
print("\nAfter Delete:")
print(test)

#to add/modify entries in dictionary
test['IDPlaceholder3'] = {}
test['IDPlaceholder3']['key_1'] = 'value_1'
test['IDPlaceholder3']['key_2'] = 'value_2'
print(test)

#code to loop through the nested dictionary
print("All elements in dictionary:")
for a_id, a_info in test.items():
    print("\nID:", a_id)
    
    for key in a_info:
        print(key + ':', a_info[key])

#print(test)
print("Completed!") 

"""

def addEntry(data):
    """
    #this gets the number of elements in the dictionary, and adds 1 so we can use that for the next entry
    #bad way to get the ID because it only functions if using IDs starting at 1
    #nextItemID = len(test)+1
    """
    
    #if the dictionary is empty (i.e. first time adding to the dictionary) then set the index to 0
    if (len(test) == 0):
        nextItemID = 1
    else:
        ##this orders the dictionary on the keys, then gets the lasy key in that ordered list and adds 1, so you will always be getting the next highest number
        nextItemID = sorted(test)[-1]+1
    
    ## creates a new entry in the dictionary, and adds the data
    test[nextItemID] = {}
    test[nextItemID]['Name'] = data[0]
    test[nextItemID]['Age'] = data[1]
    test[nextItemID]['Sex'] = data[2]
    test[nextItemID]['Species'] = data[3]
    test[nextItemID]['Breed'] = data[4] #repeat as necessary for the number of key-value pairs in nested dictionary
    printData(test)

    listIndexes.append(nextItemID)

    ## WRITE ENTIRE DICTIONARY TO THE FILE ##
    saveData(test)

## Cannot append to file, as the initial write to the file writes the nested dictionary, while appending is just adding a new single dictionary
    ## APPEND TO FILE ##
    ## file_temp = open("tempfile.txt","ab")
    ## pickle.dump(test[nextItemID],file_temp)
    ## file_temp.close()
def updateEntry(index, data):
    test[index]['Name'] = data[0]
    test[index]['Age'] = data[1]
    test[index]['Sex'] = data[2]
    test[index]['Species'] = data[3]
    test[index]['Breed'] = data[4]
    #printData(test)
    saveData(test)

def deleteEntry(index):
    del test[index]
    listIndexes.remove(index)
    saveData(test)

def saveData(data):
    file_temp = open("animalshelter.txt","wb")
    pickle.dump(data,file_temp)
    file_temp.close()

def loadData():
    fileContents = {}
    fileIndexes = []
    with open("animalshelter.txt","rb") as file_temp:
        try:
            while True:
                fileContents = pickle.load(file_temp)
        except EOFError:
            pass
    file_temp.close()

    if(len(fileContents)>0):
        fileIndexes = list(fileContents.keys())
    return fileContents, fileIndexes

def getDictLength():
    #Need to grab the len(test) value here
    return len(test)

#need to figure out this piece, not sure how to change the currentIndex, seems like you would have to continually pass it around when calling the function
#def setToLastIndex():
#    currentIndex = len(test)

#def updateCurrentIndex(intPassedValue):
#    value = currentIndex + intPassedValue
#    return value

def getID():
    if (getDictLength() == 0):
        return 123
    else:
        #return list(test.keys())[currentIndex-1]## -1 here to make sure we are using the index (which starts at 0), as the variable starts at 1 so it can be used in the get methods below
        return currentIndex

def getEntry1():
    if (getDictLength() == 0):
        return "Name"
    else:
        return test[currentIndex]['Name']

def getEntry2():
    if (getDictLength() == 0):
        return "Age"
    else:
        return test[currentIndex]['Age']

def getEntry3():
    if (getDictLength() == 0):
        return "Sex"
    else:
        return test[currentIndex]['Sex']

def getEntry4():
    if (getDictLength() == 0):
        return "Species"
    else:
        return test[currentIndex]['Species']

def getEntry5():
    if (getDictLength() == 0):
        return "Breed"
    else:
        return test[currentIndex]['Breed']

def printData(dict1):
    for a_id, a_info in dict1.items():
        print("\nID:", a_id)
    
        for key in a_info:
            print(key + ':', a_info[key])

def createGUI():
    #setup the window
    window = tk.Tk()
    window.title("Test Project")
    window.title(today.strftime("%d/%m/%Y"))
    window.geometry('600x400+100+100')
    window.resizable(0,0)
    window['background']= '#FFD39B'
    window.iconbitmap('./paw.ico')

    #create column grid
    window.columnconfigure(0,weight=1)
    window.columnconfigure(1,weight=1)
    window.columnconfigure(2,weight=1)
    window.columnconfigure(3,weight=1)
    window.columnconfigure(4,weight=1)
    window.columnconfigure(5,weight=1)

    #start building elements/widgets
    appHeading = ttk.Label(window,text="Petsie!")
    appHeading.grid(column=0,row=0,sticky=tk.W,padx=5,pady=5)

    # this is where we will pull values from the dictionary to populate the text boxes
    # will use the bottom buttons to change these variables
    def setEntryVariables():
        a_var0.set(str(getID()))
        a_var1.set(getEntry1())
        a_var2.set(getEntry2())
        a_var3.set(getEntry3())
        a_var4.set(getEntry4())
        a_var5.set(getEntry5())

    #variables for entry boxes
    a_var0 = StringVar()
    a_var1 = StringVar()
    a_var2 = StringVar()
    a_var3 = StringVar()
    a_var4 = StringVar()
    a_var5 = StringVar()
    setEntryVariables() #set them on first load

    ## LABEL COLUMN ##
    #this label0 should probably be hidden, as it is only the ID
    # it will be used for updating an existing entry and deleting an existing entry
    label0 = ttk.Label(window, text="ID NUM: ")
    label0.grid(column=0,row=1,pady=10,)
    

    label1 = ttk.Label(window, text="Name ")
    label1.grid(column=0,row=2,pady=10)

    label2 = ttk.Label(window, text="Age: ")
    label2.grid(column=0,row=3,pady=10)

    label3 = ttk.Label(window, text="Sex: ")
    label3.grid(column=0,row=4,pady=10)

    label4 = ttk.Label(window, text="Breed: ")
    label4.grid(column=0,row=5,pady=10)

    label5 = ttk.Label(window, text="Species: ")
    label5.grid(column=0,row=6,pady=10)


    #entry column
    entry0 = ttk.Entry(window, justify='left',textvariable=a_var0,state=DISABLED, width=40)
    entry0.grid(column=1,row=1,sticky=tk.W, columnspan=2)

    entry1 = ttk.Entry(window, justify='left',textvariable=a_var1, width=40)
    entry1.grid(column=1,row=2,sticky=tk.W, columnspan=2)

    entry2 = ttk.Entry(window, justify='left',textvariable=a_var2, width=40)
    entry2.grid(column=1,row=3,sticky=tk.W, columnspan=2)

    entry3 = ttk.Entry(window, justify='left',textvariable=a_var3, width=40)
    entry3.grid(column=1,row=4,sticky=tk.W, columnspan=2)

    entry4 = ttk.Entry(window, justify='left',textvariable=a_var4, width=40)
    entry4.grid(column=1,row=5,sticky=tk.W, columnspan=2)

    entry5 = ttk.Entry(window, justify='left',textvariable=a_var5, width=40)
    entry5.grid(column=1,row=6,sticky=tk.W, columnspan=2)

    #functions for below buttons
    def addBtnClicked():
        print("Add Button Clicked")
        addList = [entry1.get(),entry2.get(),entry3.get(),entry4.get(),entry5.get()]
        addEntry(addList)
        window.destroy()
        createGUI()
    
    def UpdateBtnClicked():
        print("Update Button Clicked")
        updateList = [entry1.get(),entry2.get(),entry3.get(),entry4.get(),entry5.get()]
        updateEntry(int(entry0.get()),updateList)

    def DeleteBtnClicked():
        global currentIndex
        print("Delete Button Clicked")
        deleteEntry(int(entry0.get()))
        currentIndex = listIndexes[0]
        window.destroy()
        createGUI()

    def SearchBtnClicked():
        print("Search Button Clicked")
    
    def ExitBtnClicked():
        print("Exit Button Clicked")
        window.destroy()

    #buttons column - right
    addBtn = ttk.Button(window, text="Add",command=addBtnClicked)
    addBtn.grid(column=6, row=1, padx=10)

    UpdateBtn = ttk.Button(window, text="Update",command=UpdateBtnClicked)
    UpdateBtn.grid(column=6, row=2, padx=10)

    DeleteBtn = ttk.Button(window, text="Delete",command=DeleteBtnClicked)
    DeleteBtn.grid(column=6, row=3, padx=10)

    SearchBtn = ttk.Button(window, text="Search",command=SearchBtnClicked)
    SearchBtn.grid(column=6, row=4, padx=10)

    ExitBtn = ttk.Button(window, text="Exit",command=ExitBtnClicked)
    ExitBtn.grid(column=6, row=5, padx=10)

    ## BOTTOM BUTTON VARIABLES ##
    pageCurrent = 1
    pageMax = ""
    pageText = StringVar()

    if(getDictLength()==0): pageCurrent=0 #if there are entries in the dictionary then we can start the count at page 1, otherwise it will be page 0 of 0
    pageMax = str(getDictLength())
    pageText.set("Page " + str(pageCurrent) + " of " + pageMax)
    print(pageText.get())

    def updatePageText():
        nonlocal pageText
        pageText.set("Page " + str(pageCurrent) + " of " + pageMax)

    ## BOTTOM BUTTON FUNCTIONS ##
    def firstBtnClicked():
        global currentIndex
        global listIndexes
        nonlocal pageCurrent
        if(currentIndex>int(listIndexes[0])):
            currentIndex = int(listIndexes[0])
            setEntryVariables()
            pageCurrent = 1
            updatePageText()

    def prevBtnClicked():
        global currentIndex
        nonlocal pageCurrent
        if(currentIndex>int(listIndexes[0])):
            currentIndex = int(listIndexes[listIndexes.index(currentIndex)-1])
            setEntryVariables()
            pageCurrent = pageCurrent - 1
            updatePageText()

    def nextBtnClicked():
        global currentIndex#1
        nonlocal pageCurrent#1
        print("CurrentIndex: " +str(currentIndex))
        print("Page Current: " + str(pageCurrent))
        if(currentIndex<int(listIndexes[-1])):
            #update the currentIndex value so we can update the text boxes with the new values
            print("listIndexes[-1]: " + str(listIndexes[-1]))
            currentIndex = int(listIndexes[listIndexes.index(currentIndex)+1])
            print("CurrentIndex: " + str(currentIndex))
            setEntryVariables()
            #update the pageCurrent so we can update the text in the Page X of Y
            pageCurrent = pageCurrent + 1
            updatePageText()
            
    def lastBtnClicked():
        global currentIndex
        nonlocal pageCurrent
        if(currentIndex<int(listIndexes[-1])):
            currentIndex=int(listIndexes[-1])
            setEntryVariables()
            pageCurrent = getDictLength()
            updatePageText()
        
    ## BOTTOM BUTTONS ##
    # this will be for the first, previous, next, last buttons, and the page X of Y text area
    firstBtn = ttk.Button(window, text="<< First",command=firstBtnClicked)
    firstBtn.grid(column=0, row=7)

    prevBtn = ttk.Button(window, text="< Previous",command=prevBtnClicked)
    prevBtn.grid(column=1, row=7)

    pageEntry = ttk.Entry(window,textvariable=pageText,state=DISABLED)
    pageEntry.grid(column=2,row=7, pady=10)

    nextBtn = ttk.Button(window, text="Next >",command=nextBtnClicked)
    nextBtn.grid(column=3, row=7, padx=25)

    lastBtn = ttk.Button(window, text="Last >>",command=lastBtnClicked)
    lastBtn.grid(column=4, row=7)


    window.mainloop()


if __name__ == '__main__':
    #print("Test2 (should be empty):\n")
    #print(test2)
    #saveData(test)
    test, listIndexes = loadData()
    currentIndex = int(listIndexes[0])
    #print("\nTest: (should now have data):")
    printData(test)
    print(listIndexes)
    #print(currentIndex)
    createGUI()

    #CAN'T DELETE ALL ENTRIES AS WILL MAKE PROG FAIL. WAYS AROUND THIS??? future work...