from cgitb import text
import tkinter as tk
from tkinter import ttk
from tkinter import *
from datetime import date
today=date.today()
#import pickle

root = tk.Tk()
#Adding the titles to the GUI, and the page icon
root.title(today.strftime("%d/%m/%Y"))
root.geometry('600x400+50+50')
root['background']= '#C7F4AD'
root.iconbitmap('./paw.ico')
root.resizable(0,0)#makes sure the window cannot be resized

#setting up the columns/rows
root.columnconfigure(0,weight=1)
root.columnconfigure(1,weight=1)
root.columnconfigure(2,weight=1)
root.columnconfigure(3,weight=1)
root.columnconfigure(4,weight=1)
root.columnconfigure(5,weight=1)

#Addition of Main Label text
message = tk.Label(root, text="Animal Shelter Name") #label is a widget
message.grid(column=0,row=0,sticky=tk.W,columnspan=4)#this puts the label in position 0,0 in the grid, and aligns to the left (west) side
#message.pack()#removed this to use grid instead
#message.place(x=20, y=10)#removed this to use grid instead

#Addition of buttons. Need to link these to the methods for calling up the animal info
def upd_result():
    None

Upd_Button=ttk.Button(root, text="UPDATE", command=upd_result)
Upd_Button.grid(column=5,row=0,padx=5,pady=10) #pad adds a little space. Y adds space above and under 
#Upd_Button.pack() 
#Upd_Button.place(x=550, y=30, anchor='e')


def show_result():
    None

Add_Button=ttk.Button(root, text="ADD", command=show_result)
Add_Button.grid(column=5,row=1,padx=5,pady=10)
#Add_Button.pack() 
#Add_Button.place(x=550, y=60, anchor='e') #x200 sends it way off to the left. 

def del_res():
    None
Del_Button=ttk.Button(root, text="DELETE", command= del_res)
Del_Button.grid(column=5,row=2,padx=5,pady=10)
#Del_Button.pack() 
#Del_Button.place(x=550, y=90, anchor='e')


def search_result():
    None

Search_Button=ttk.Button(root, text="SEARCH", command=search_result)
Search_Button.grid(column=5,row=3,padx=5,pady=10)
#Search_Button.pack() 
#Search_Button.place(x=550, y=120, anchor='e')

def can_res():
    None
Can_Button=ttk.Button(root, text="CANCEL", command=can_res)
Can_Button.grid(column=5,row=4,padx=5,pady=10)
#Can_Button.pack() 
#Can_Button.place(x=550, y=150, anchor='e')


def exit():
    None

Exit_Button=ttk.Button(root, text="EXIT", command=exit)
Exit_Button.grid(column=5,row=5,padx=5,pady=10)
#Exit_Button.pack() 
#Exit_Button.place(x=550, y=180, anchor='e')


#############Text boxes for animal info###########################
shelter_id= tk.StringVar()
animal_name=tk.StringVar()
animal_age=tk.StringVar()
animal_breed=tk.StringVar()
animal_sex=tk.StringVar()

#SHELTER ID#
#info_add = ttk.Frame(root)#removing the FRAME as it is not necessary when using GRID
#info_add.pack(padx=15, pady=10, side=LEFT)
id_label = ttk.Label(root, text="Shelter ID:")
id_label.grid(column=0,row=1)
id_entry= ttk.Entry(root, textvariable=shelter_id)
id_entry.grid(column=1,row=1,sticky=tk.W)#sticky forces widget to align to the left (West) side
#id_entry.pack()
#id_entry.place(x=160, y=50)

#ANIMAL NAME#
name_label = ttk.Label(root, text="Name:")
name_label.grid(column=0,row=2)
name_entry= ttk.Entry(root, textvariable=animal_name)
name_entry.grid(column=1,row=2,sticky=tk.W)

#ANIMAL AGE#
age_label = ttk.Label(root, text="Age:")
age_label.grid(column=0,row=3)
age_entry= ttk.Entry(root, textvariable=animal_age)
age_entry.grid(column=1, row=3, sticky=tk.W)

#ANIMAL BREED#
breed_label = ttk.Label(root, text="Breed:")
breed_label.grid(column=0,row=4)
breed_entry= ttk.Entry(root, textvariable=animal_breed)
breed_entry.grid(column=1, row=4, sticky=tk.W)

#ANIMAL SEX#
sex_label = ttk.Label(root, text="Sex:")
sex_label.grid(column=0,row=5)
sex_entry= ttk.Entry(root, textvariable=animal_sex)
sex_entry.grid(column=1, row=5, sticky=tk.W)


#PAGE BUTTONS# may need to play with alignment of the buttons so it looks good
#First Button
def first_page():
    None
First_Button=ttk.Button(root, text="First", command=first_page)
First_Button.grid(column=0,row=6,padx=5, pady=25)

#Back Button
def go_back():
    None
Back_Button=ttk.Button(root, text="Back", command=go_back)
Back_Button.grid(column=1,row=6,padx=5, pady=25)
#Page display
def display_result():
    None
display_label = ttk.Label(root, text="PAGE")
display_label.grid(column=2,row=6, padx=5,pady=25)

#Next Button
def next_page():
    None
Next_Button=ttk.Button(root, text="Next", command=next_page)
Next_Button.grid(column=3,row=6,padx=5, pady=25)

#Last Button
def last_page():
    None
Last_Button=ttk.Button(root, text="Last", command=last_page)
Last_Button.grid(column=4,row=6,padx=5, pady=25)

root.mainloop()

