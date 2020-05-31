myApp = App("Chrome")
myApp.focus()
wait(1)
click("1590852966657.png")
# login as admin
click("1590828520884.png")
wait(3)
find("1590829977997.png")
type("1590852890405.png","admin@ezgas.com")
wait(1)
type("1590852921225.png","admin")
wait(1)
click("1590852943968.png")
click("1590853110017.png")
wait(2)
# scroll down
for i in range(20):
    type(Key.DOWN)
# check initial list of gas stations
find("1590856646271.png")
click("1590856659165.png")
wait(2)
# check the final list of gas stations
find("1590857403696.png")
