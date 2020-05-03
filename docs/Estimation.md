# Project Estimation  

Authors: Enrico Clemente, Luca Francescato, Giovanni Tangredi, Seyedali Mousavi

Date: 03/05/2020

Version: 1

# Contents



- [Estimate by product decomposition]
- [Estimate by activity decomposition]



# Estimation approach

<Consider the EZGas  project as described in YOUR requirement document, assume that you are going to develop the project INDEPENDENT of the deadlines of the course>

# Estimate by product decomposition



### 

|             | Estimate                        |             
| ----------- | ------------------------------- |  
| NC =  Estimated number of classes to be developed   |10|             
|  A = Estimated average size per class, in LOC       |200| 
| S = Estimated size of project, in LOC (= NC * A) |2000|
| E = Estimated effort, in person hours (here use productivity 10 LOC per person hour)|200|   
| C = Estimated cost, in euro (here use 1 person hour cost = 30 euro) | 6000| 
| Estimated calendar time, in calendar weeks (Assume team of 4 people, 8 hours per day, 5 days per week ) | 2 |               


# Estimate by activity decomposition



### 

|         Activity name    | Estimated effort (person hours)   |             
| ----------- | ------------------------------- | 
| Requirements | 20 |
| Design | 50  |
| Coding | 200 |
| Unit Testing | 60 |
| System Testing | 40 |


###
``` plantuml
@startuml Gantt
[Requirements] lasts 1 days
then [Design] lasts 2 days
then [Coding] lasts 7 days
then [Unit Testing] lasts 2 days
then [System Testing] lasts 2 days
@enduml
```
###

