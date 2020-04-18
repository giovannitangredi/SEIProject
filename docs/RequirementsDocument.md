# Requirements Document 

Authors: Enrico Clemente, Luca Francescato, Giovanni Tangredi, Seyedali Mousavi

Date: 18/04/2020

Version: 1.0

# Contents

- [Stakeholders](#stakeholders)
- [Context Diagram and interfaces](#context-diagram-and-interfaces)
	+ [Context Diagram](#context-diagram)
	+ [Interfaces](#interfaces) 
- [Stories and personas](#stories-and-personas)
- [Functional and non functional requirements](#functional-and-non-functional-requirements)
	+ [Functional Requirements](#functional-requirements)
	+ [Non functional requirements](#non-functional-requirements)
- [Use case diagram and use cases](#use-case-diagram-and-use-cases)
	+ [Use case diagram](#use-case-diagram)
	+ [Use cases](#use-cases)
    	+ [Relevant scenarios](#relevant-scenarios)
- [Glossary](#glossary)
- [System design](#system-design)
- [Deployment diagram](#deployment-diagram)


# Stakeholders


| Stakeholder name  | Description | 
| ----------------- |:-----------:|
| Registered User   |  Uses the application to add new gas stations, add and update gas station prices, search for gas stations and relative prices on the map | 
| User | Uses the application to search for gas stations and relative prices on the map |
| Map Service | Gives the user the location of gas stations with their prices |

# Context Diagram and interfaces

## Context Diagram



## Interfaces

| Actor | Logical Interface | Physical Interface  |
| ------------- |:-------------:| -----:|
| User/Registered User| GUI | TouchScreen, Monitor, Keyboard |
| Map Service | API | Internet connection |

# Stories and personas

Robert travels for work. He is a freelancer, and drives his car at least 4 hours per day. He drives most of the times in highways, where gas prices are quite high and gas stations are very far one from each other. This makes him plan every movement so that he knows where to get gas, without having troubles and paying too much. He would like to have a rapid way of looking for the best gas stations in the route he's going to run across, and also update the prices so that others with similar necessities can get the most out of this application.

Alberto is on holiday and he’s noticed that his car is quite out of gas and he uses the app to check if there are any good gas stations nearby. 
He selects a radius of 1km from his position and gets the results from the app, he then decides to go to the gas station with the lowest prices but also with the best facilities (bar, toilets,...) to have a break with his family.

Alan is a food delivery employee and he uses its scooter for his deliveries. He wants to earn the best he can so he wants to save on fuel cost. 
So he uses EZGas to find always the cheapest gas station in his area.

Luigi is a gas station owner. He spends too much time on his gas station, but he has a few customers. Since he does not expend much money to introduce his gas station to people around, his earning is low. His gas station was not in the main district of the city and not anybody was aware of existence of this gas station. Joe, one of his friends, introduces the “EZGas” application to him in which he can add his gas station to the list of all gas stations to show on the map for drivers. Also, he was able to insert the prices of fuels and possibly open/close hours. Now, he can count on having more customers in his gas station.


# Functional and non functional requirements

## Functional Requirements

| ID        | Description  |
| ------------- |:-------------:| 
| FR1 | Create a new user account |
| FR2 | Deactivating a user account |
| FR3 | Update user account information |
| FR4 | Add a gas station with its fuel types and their prices |
| FR4.1 |	Add facilities information of a gas station |
| FR4.2 | Add optional review |
| FR5 | Update prices of an existing gas station |
| FR6 | Show on the map service gas stations with their prices |
| FR6.1 | Filter gas stations on fuel type |
| FR6.2 | Filter gas stations on price |
| FR6.3 | Filter gas stations on distance from the user location |
| FR6.4 | Filter gas stations on the facilities |
| FR7 | Report bugs and data errors FR1 |  

## Non Functional Requirements

| ID        | Type (efficiency, reliability, ..)           | Description  | Refers to |
| ------------- |:-------------:| :-----:| -----:|
| NFR1 | Usability | Application should be used with no training by any user	 | All FR |
| NFR2 | Performance |	All functions should complete in < 1 sec | All FR |
| NFR3	| Portability| The application runs on smartphones (Android, iOS) | All FR |
| NFR4 | Portability | The application runs on PCs' web browsers(Google Chrome, Safari, Mozilla Firefox) | All FR|
|NFR5 | Localisation | Decimal numbers use . (dot) as decimal separator | All FR |
| NFR6 | Usability | Name of the gas stations may be in other languages which demands usage and support of Unicode | All FR|
| NFR7 | Privacy	| The application doesn't collect any personal information and doesn't bind GPS data to any specific user |
| NFR8	| Privacy	| The application is GDPR compliant|	


# Use case diagram and use cases


## Use case diagram
\<define here UML Use case diagram UCD summarizing all use cases, and their relationships>


\<next describe here each use case in the UCD>
### Use case 1, UC1
| Actors Involved        |  |
| ------------- |:-------------:| 
|  Precondition     | \<Boolean expression, must evaluate to true before the UC can start> |  
|  Post condition     | \<Boolean expression, must evaluate to true after UC is finished> |
|  Nominal Scenario     | \<Textual description of actions executed by the UC> |
|  Variants     | \<other executions, ex in case of errors> |

##### Scenario 1.1 

\<describe here scenarios instances of UC1>

\<a scenario is a sequence of steps that corresponds to a particular execution of one use case>

\<a scenario is a more formal description of a story>

\<only relevant scenarios should be described>

| Scenario 1.1 | |
| ------------- |:-------------:| 
|  Precondition     | \<Boolean expression, must evaluate to true before the scenario can start> |
|  Post condition     | \<Boolean expression, must evaluate to true after scenario is finished> |
| Step#        | Description  |
|  1     |  |  
|  2     |  |
|  ...     |  |

##### Scenario 1.2

### Use case 2, UC2
..

### Use case
..



# Glossary

\<use UML class diagram to define important concepts in the domain of the system, and their relationships> 

\<concepts are used consistently all over the document, ex in use cases, requirements etc>

# System Design
\<describe here system design>

\<must be consistent with Context diagram>

# Deployment Diagram 

\<describe here deployment diagram >
