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
    
# search for a gas station
type("1590858553828.png","Via San Paolo")
wait(3)
type(Key.DOWN)
wait(2)
click("1590858853832.png")
wait(2)

# add report 
click("1590858892868.png")
wait(2)
for i in range(20):
    type(Key.DOWN)
wait(1)
type(Pattern("1590860026563.png").targetOffset(35,-2),"1.6")
wait(1)
type(Pattern("1590860132469.png").targetOffset(20,-3),"1.3")
wait(1)
type(Pattern("1590860143525.png").targetOffset(30,-5),"1.7")
wait(1)
type(Pattern("1590860152706.png").targetOffset(25,0),"1.3")
wait(1)
type(Pattern("1590860161363.png").targetOffset(32,-4),"1.35")
wait(3)
click("1590859794884.png")

# check the report
wait(3)
click("1590859887378.png")
wait(2)
find("1590859906563.png")