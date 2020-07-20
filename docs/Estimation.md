# Project Estimation  

Authors: Enrico Clemente, Luca Francescato, Giovanni Tangredi, Seyedali Mousavi

Date: 30/06/2020

Version: 2

# Contents



- [Estimate by product decomposition]
- [Estimate by activity decomposition]



# Estimation approach

<Consider the EZGas  project as described in YOUR requirement document, assume that you are going to develop the project INDEPENDENT of the deadlines of the course>

# Estimate by product decomposition



### 

|             | Estimate                        |             
| ----------- | ------------------------------- |  
| NC =  Estimated number of classes to be developed   |15 |             
|  A = Estimated average size per class, in LOC       |100| 
| S = Estimated size of project, in LOC (= NC * A) |1500|
| E = Estimated effort, in person hours (here use productivity 10 LOC per person hour)|150|   
| C = Estimated cost, in euro (here use 1 person hour cost = 30 euro) | 4500| 
| Estimated calendar time, in calendar weeks (Assume team of 4 people, 8 hours per day, 5 days per week ) | 1 |               


# Estimate by activity decomposition



### 

|         Activity name    | Estimated effort (person hours)   |             
| ----------- | ------------------------------- | 
| Requirements | 20 |
| Design | 30  |
| Coding | 150 |
| Unit Testing | 20 |
| System Testing | 50 |


###
``` plantuml
@startuml Gantt
[Requirements] lasts 1 days
then [Design] lasts 1 days
then [Coding] lasts 5 days
then [Unit Testing] lasts 1 days
then [System Testing] lasts 2 days
@enduml
```
###

