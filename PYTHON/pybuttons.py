from tkinter import *
root = Tk() #creates the main window
topFrame = Frame(root) #making an invisible frame container in the main window
topFrame.pack() #anytime we want to display, we have to pack 
bottomFrame = Frame(root)
bottomFrame.pack(side=BOTTOM)


#setting up the buttons
button1 = Button(topFrame,text="BUTTON1",fg="blue")
button2 = Button(topFrame,text="BUTTON2",fg="red")
button3 = Button(topFrame,text="BUTTON3",fg="green")
button4 = Button(bottomFrame,text="BUTTON4",fg="purple")

#displaying the buttoms
button1.pack(side=LEFT)
button2.pack(side=RIGHT)
button3.pack(side=TOP)
button4.pack(side=BOTTOM)

root.mainloop() #the window loop