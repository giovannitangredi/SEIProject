# GUI  Testing Documentation 

Authors:Enrico Clemente, Luca Francescato, Giovanni Tangredi, Seyedali Mousavi

Date:31/06/2020

Version: 1

# GUI testing

This part of the document reports about testing at the GUI level. Tests are end to end, so they should cover the Use Cases, and corresponding scenarios.
It was used SikulixIDE 2.0.4
## Coverage of Scenarios and FR

### 

| Scenario ID | Functional Requirements covered | GUI Test(s) |
| ----------- | ------------------------------- | ----------- | 
|  UC1.1        | FR1.1                         | uc1_1.py    |             
|  UC1.2        | FR1.1                         | uc1_2.py            |             
|  UC2.1        | FR1.1                         | uc2_1.py            |             
|  UC2.2        | FR1.1                         | uc2_2.py            |             
|  UC3.1        | FR1.2                         | uc3_1.py            |             
|  UC4.1        | FR3.1                         | uc4_1.py  	      |     
|  UC4.2        | FR3.1                         | uc4_2.py  	      |  
|  UC5.1        | FR3.1                         | uc5_1.py 	          |  
|  UC5.2        | FR3.1                         | uc5_2.py 	          |  
|  UC6.1        | FR3.2                         | uc6_1.py	          |    
|  UC7.1        | FR5.1                         | uc7_1.py 	          |  
|  UC7.2        | FR5.1                         | uc7_2.py            |  
|  UC8.1        | FR4,FR3.3                     | uc8_1.py			  |  
|  UC8.2        | FR4                           | uc8_2.py			  |
|  UC9.1        | FR5.2                         | uc9_1.py            |
|  UC10.1       | FR5.3                         | uc10_1.py            | 
|  UC10.2       | FR5.3                         | uc10_2.py            |                


# REST  API  Testing

This part of the document reports about testing the REST APIs of the back end. The REST APIs are implemented by classes in the Controller package of the back end. 
Tests should cover each function of classes in the Controller package

## Coverage of Controller methods



| class.method name | Functional Requirements covered |REST  API Test(s) | 
| ----------- | ------------------------------- | ----------- | 
| UserController.getUserById | FR1.4         | getUsersByIdTest |     
| UserController.getAllUsers | FR1.3         | getAllUsersTest  |             
| UserController.saveUser    | FR1.1         | saveUserTest     |             
| UserController.deleteUser  | FR1.2         | deleteUserTest   |             
| UserController.increaseUserReputation | FR5.3  |  increaseUserReputationTest  |
| UserController.decreaseUserReputation | FR5.3  |  decreaseUserReputationTest  |              
| UserController.login                  | FR2    |  loginTest  | 
| GasStationController.getGasStationById | FR4   |  getGasStationByIdTest |
| GasStationController.getAllGasStations | FR3.3, FR5.2 |  getAllGasStationsTest |
| GasStationController.saveGasStation |  FR3.1 |  saveGasStationTest    |
| GasStationController.deleteUser |   FR3.2    |  deleteGasStationTest  |
| GasStationController.getGasStationsByGasolineType | FR4.5   |  getGasStationsByGasolineTypeTest  |
| GasStationController.getGasStationsByProximity |  FR4.2, FR4.1   | getGasStationsByProximityTest |
| GasStationController.getGasStationsWithCoordinates |  FR4.2, FR4.1, FR4.3, FR4.5 | getGasStationsWithCoordinatesTest  |
| GasStationController.setGasStationReport | FR5.1  |  setGasStationReportTest  |          