from tkinter import *

root = Tk()

def printName():
    print("Hello my name is Zach!")

button_1 = Button(root,text="Press this!",command=printName)
button_1.pack()

root.mainloop()