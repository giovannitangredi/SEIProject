myApp = App("Chrome")
myApp.focus()
wait(1)
# login as user1
click("1590828520884.png")
wait(3)
find("1590829977997.png")
type("1590852890405.png","user2@gmail.com")
wait(1)
type("1590852921225.png","user2")
wait(1)
click("1590852943968.png")
wait(3)

# scroll down
for i in range(12):
    type(Key.DOWN)
    
# search without giving address gas station
wait(2)
click("1590858853832.png")
wait(2)
type(Key.DOWN)
type(Key.DOWN)
type(Key.DOWN)
find("1590859906563.png")