# Unit Testing Documentation

Authors:

Date:

Version:

# Contents

- [Black Box Unit Tests](#black-box-unit-tests)




- [White Box Unit Tests](#white-box-unit-tests)


# Black Box Unit Tests

    <Define here criteria, predicates and the combination of predicates for each function of each class.
    Define test cases to cover all equivalence classes and boundary conditions.
    In the table, report the description of the black box test case and (traceability) the correspondence with the JUnit test case writing the 
    class and method name that contains the test case>
    <JUnit test classes must be in src/test/java/it/polito/ezgas   You find here, and you can use,  class EZGasApplicationTests.java that is executed before 
    the set up of all Spring components
    >



### **Class *User* - method *setUserId***

**Criteria for method *setUserId*:**

 - value of userId

**Predicates for method *setUserId*:**

| Criteria        | Predicate        |
| --------------- | ---------------- |
| value of userId | null             |
|                 | [minint, maxint] |

**Boundaries**:

| Criteria        | Boundary values |
| --------------- | --------------- |
| value of userId | minint - 1      |
|                 | minint          |
|                 | minint + 1      |
|                 | maxint - 1      |
|                 | maxint          |
|                 | maxint + 1      |

**Combination of predicates**:

| Criteria 1       | Valid / Invalid | Description of the test case | JUnit test case |
| ---------------- | --------------- | ---------------------------- | --------------- |
| null             | Valid           | T1(null) -> null             | it.polito.ezgas.UserTests.testSetUserId |
| [minint, maxint] | Valid           | T2(3) -> 3                   | it.polito.ezgas.UserTests.testSetUserId |
| minint - 1       | Invalid         | T3(minint - 1) -> Error      | it.polito.ezgas.UserTests.testSetUserId |
| maxint + 1       | Invalid         | T4(maxint + 1) -> Error      | it.polito.ezgas.UserTests.testSetUserId |



### **Class *User* - method *setUserName***

**Criteria for method *setUserName*:**

 - value of userName

**Predicates for method *setUserName*:**

| Criteria          | Predicate              |
| ----------------- | ---------------------- |
| value of userName | null                   |
|                   | sequence of characters |

**Boundaries**:

| Criteria          | Boundary values |
| ----------------- | --------------- |
| value of userName | null            |
|                   | ""              |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case |
| ---------------------- | --------------- | ---------------------------- | --------------- |
| null                   | Valid           | T1(null) -> null             | it.polito.ezgas.UserTests.testSetUserName |
| sequence of characters | Valid           | T2("Abc") -> "Abc"           | it.polito.ezgas.UserTests.testSetUserName |
| empty string           | Valid           | T3("") -> ""                 | it.polito.ezgas.UserTests.testSetUserName |



### **Class *User* - method *setPassword***

**Criteria for method *setPassword*:**

 - value of password

**Predicates for method *setPassword*:**

| Criteria          | Predicate              |
| ----------------- | ---------------------- |
| value of password | null                   |
|                   | sequence of characters |

**Boundaries**:

| Criteria          | Boundary values |
| ----------------- | --------------- |
| value of password | null            |
|                   | ""              |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case |
| ---------------------- | --------------- | ---------------------------- | --------------- |
| null                   | Valid           | T1(null) -> null             | it.polito.ezgas.UserTests.testSetPassword |
| sequence of characters | Valid           | T2("1!xyz") -> "1!xyz"       | it.polito.ezgas.UserTests.testSetPassword |
| empty string           | Valid           | T3("") -> ""                 | it.polito.ezgas.UserTests.testSetPassword |



### **Class *User* - method *setEmail***

**Criteria for method *setEmail*:**

 - value of email

**Predicates for method *setEmail*:**

| Criteria          | Predicate              |
| ----------------- | ---------------------- |
| value of email    | null                   |
|                   | sequence of characters |

**Boundaries**:

| Criteria          | Boundary values |
| ----------------- | --------------- |
| value of email    | null            |
|                   | ""              |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case |
| ---------------------- | --------------- | ---------------------------- | --------------- |
| null                   | Valid           | T1(null) -> null             | it.polito.ezgas.UserTests.testSetEmail |
| sequence of characters | Valid           | T2("123abc") -> "123abc"     | it.polito.ezgas.UserTests.testSetEmail |
| empty string           | Valid           | T3("") -> ""                 | it.polito.ezgas.UserTests.testSetEmail |



### **Class *User* - method *setReputation***

**Criteria for method *setReputation*:**

 - value of reputation

**Predicates for method *setReputation*:**

| Criteria            | Predicate        |
| ------------------- | ---------------- |
| value of reputation | null             |
|                     | [minint, maxint] |

**Boundaries**:

| Criteria            | Boundary values |
| ------------------- | --------------- |
| value of reputation | minint - 1      |
|                     | minint          |
|                     | minint + 1      |
|                     | maxint - 1      |
|                     | maxint          |
|                     | maxint + 1      |

**Combination of predicates**:

| Criteria 1       | Valid / Invalid | Description of the test case | JUnit test case   |
| ---------------- | --------------- | ---------------------------- | ----------------- |
| null             | Valid           | T1(null) -> null             | it.polito.ezgas.UserTests.testSetReputation |
| [minint, maxint] | Valid           | T2(2) -> 2                   | it.polito.ezgas.UserTests.testSetReputation |
| minint - 1       | Invalid         | T3(minint - 1) -> Error      | it.polito.ezgas.UserTests.testSetReputation |
| maxint + 1       | Invalid         | T4(maxint + 1) -> Error      | it.polito.ezgas.UserTests.testSetReputation |



### **Class *User* - method *setAdmin***

**Criteria for method *setAdmin*:**

 - value of admin

**Predicates for method *setAdmin*:**

| Criteria       | Predicate              |
| -------------- | ---------------------- |
| value of admin | null                   |
|                | {true, false}          |

**Boundaries**:

| Criteria       | Boundary values |
| -------------- | --------------- |
| value of admin | true            |
|                | false           |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case |
| ---------------------- | --------------- | ---------------------------- | --------------- |
| null                   | Valid           | T1(null) -> null             | it.polito.ezgas.UserTests.testSetAdmin |
| {true, false}          | Valid           | T2(true) -> true             | it.polito.ezgas.UserTests.testSetAdmin |






### **Class *GasStation* - method *setGasStationId***

**Criteria for method *setGasStationId*:**

 - value of gasStationId

**Predicates for method *setGasStationId*:**

| Criteria              | Predicate        |
| --------------------- | ---------------- |
| value of gasStationId | null             |
|                       | [minint, maxint] |

**Boundaries**:

| Criteria              | Boundary values |
| --------------------- | --------------- |
| value of gasStationId | minint - 1      |
|                       | minint          |
|                       | minint + 1      |
|                       | maxint - 1      |
|                       | maxint          |
|                       | maxint + 1      |

**Combination of predicates**:

| Criteria 1       | Valid / Invalid | Description of the test case | JUnit test case     |
| ---------------- | --------------- | ---------------------------- | ------------------- |
| null             | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetGasStationId |
| [minint, maxint] | Valid           | T2(55) -> 55                 | it.polito.ezgas.GasStationTests.testSetGasStationId |
| minint - 1       | Invalid         | T3(minint - 1) -> Error      | it.polito.ezgas.GasStationTests.testSetGasStationId |
| maxint + 1       | Invalid         | T4(maxint + 1) -> Error      | it.polito.ezgas.GasStationTests.testSetGasStationId |



### **Class *GasStation* - method *setGasStationName***

**Criteria for method *setGasStationName*:**

 - value of gasStationName

**Predicates for method *setGasStationName*:**

| Criteria                | Predicate              |
| ----------------------- | ---------------------- |
| value of gasStationName | null                   |
|                         | sequence of characters |

**Boundaries**:

| Criteria                | Boundary values |
| ----------------------- | --------------- |
| value of gasStationName | null            |
|                         | ""              |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case       |
| ---------------------- | --------------- | ---------------------------- | --------------------- |
| null                   | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetGasStationName |
| sequence of characters | Valid           | T2("Eni") -> "Eni"           | it.polito.ezgas.GasStationTests.testSetGasStationName |
| empty string           | Valid           | T3("") -> ""                 | it.polito.ezgas.GasStationTests.testSetGasStationName |



### **Class *GasStation* - method *setGasStationAddress***

**Criteria for method *setGasStationAddress*:**

 - value of gasStationAddress

**Predicates for method *setGasStationAddress*:**

| Criteria                   | Predicate              |
| -------------------------- | ---------------------- |
| value of gasStationAddress | null                   |
|                            | sequence of characters |

**Boundaries**:

| Criteria                   | Boundary values |
| -------------------------- | --------------- |
| value of gasStationAddress | null            |
|                            | ""              |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case         | JUnit test case          |
| ---------------------- | --------------- | ------------------------------------ | ------------------------ |
| null                   | Valid           | T1(null) -> null                     | it.polito.ezgas.GasStationTests.testSetGasStationAddress |
| sequence of characters | Valid           | T2("Via Roma, 31") -> "Via Roma, 31" | it.polito.ezgas.GasStationTests.testSetGasStationAddress |
| empty string           | Valid           | T3("") -> ""                         | it.polito.ezgas.GasStationTests.testSetGasStationAddress |



### **Class *GasStation* - method *setReportDependability***

**Criteria for method *setReportDependability*:**

 - value of reportDependability

**Predicates for method *setReportDependability*:**

| Criteria                     | Predicate              |
| ---------------------------- | ---------------------- |
| value of reportDependability | [mindouble, maxdouble] |

**Boundaries**:

| Criteria                     | Boundary values |
| ---------------------------- | --------------- |
| value of reportDependability | mindouble - 1   |
|                              | mindouble       |
|                              | mindouble + 1   |
|                              | maxdouble - 1   |
|                              | maxdouble       |
|                              | maxdouble + 1   |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case            |
| ---------------------- | --------------- | ---------------------------- | -------------------------- |
| [mindouble, maxdouble] | Valid           | T1(3.5) -> 3.5               | it.polito.ezgas.GasStationTests.testSetReportDependability |
| mindouble - 1          | Invalid         | T2(mindouble - 1) -> Error   | it.polito.ezgas.GasStationTests.testSetReportDependability |
| maxdouble + 1          | Invalid         | T3(maxdouble + 1) -> Error   | it.polito.ezgas.GasStationTests.testSetReportDependability |



### **Class *GasStation* - method *setReportUser***

**Criteria for method *setReportUser*:**

 - value of reportUser

**Predicates for method *setReportUser*:**

| Criteria            | Predicate        |
| ------------------- | ---------------- |
| value of reportUser | null             |
|                     | [minint, maxint] |

**Boundaries**:

| Criteria            | Boundary values |
| ------------------- | --------------- |
| value of reportUser | minint - 1      |
|                     | minint          |
|                     | minint + 1      |
|                     | maxint - 1      |
|                     | maxint          |
|                     | maxint + 1      |

**Combination of predicates**:

| Criteria 1       | Valid / Invalid | Description of the test case | JUnit test case   |
| ---------------- | --------------- | ---------------------------- | ----------------- |
| null             | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetReportUser |
| [minint, maxint] | Valid           | T2(2) -> 2                   | it.polito.ezgas.GasStationTests.testSetReportUser |
| minint - 1       | Invalid         | T3(minint - 1) -> Error      | it.polito.ezgas.GasStationTests.testSetReportUser |
| maxint + 1       | Invalid         | T4(maxint + 1) -> Error      | it.polito.ezgas.GasStationTests.testSetReportUser |



### **Class *GasStation* - method *setReportTimestamp***

**Criteria for method *setReportTimestamp*:**

 - value of reportTimestamp

**Predicates for method *setReportTimestamp*:**

| Criteria                 | Predicate              |
| ------------------------ | ---------------------- |
| value of reportTimestamp | null                   |
|                          | sequence of characters |

**Boundaries**:

| Criteria                 | Boundary values |
| ------------------------ | --------------- |
| value of reportTimestamp | null            |
|                          | ""              |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case        |
| ---------------------- | --------------- | ---------------------------- | ---------------------- |
| null                   | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetReportTimestamp |
| sequence of characters | Valid           | T2("1000") -> "1000"         | it.polito.ezgas.GasStationTests.testSetReportTimestamp |
| empty string           | Valid           | T3("") -> ""                 | it.polito.ezgas.GasStationTests.testSetReportTimestamp |



### **Class *User* - method *setHasDiesel***

**Criteria for method *setHasDiesel*:**

 - value of hasDiesel

**Predicates for method *setHasDiesel*:**

| Criteria           | Predicate              |
| ------------------ | ---------------------- |
| value of hasDiesel | null                   |
|                    | {true, false}          |

**Boundaries**:

| Criteria           | Boundary values |
| ------------------ | --------------- |
| value of hasDiesel | true            |
|                    | false           |

**Combination of predicates**:

| Criteria 1    | Valid / Invalid | Description of the test case | JUnit test case  |
| ------------- | --------------- | ---------------------------- | ---------------- |
| null          | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetHasDiesel |
| {true, false} | Valid           | T2(true) -> true             | it.polito.ezgas.GasStationTests.testSetHasDiesel |



### **Class *User* - method *setHasSuper***

**Criteria for method *setHasSuper*:**

 - value of hasSuper

**Predicates for method *setHasSuper*:**

| Criteria          | Predicate              |
| ----------------- | ---------------------- |
| value of hasSuper | null                   |
|                   | {true, false}          |

**Boundaries**:

| Criteria          | Boundary values |
| ----------------- | --------------- |
| value of hasSuper | true            |
|                   | false           |

**Combination of predicates**:

| Criteria 1    | Valid / Invalid | Description of the test case | JUnit test case |
| ------------- | --------------- | ---------------------------- | --------------- |
| null          | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetHasSuper |
| {true, false} | Valid           | T2(true) -> true             | it.polito.ezgas.GasStationTests.testSetHasSuper |



### **Class *User* - method *setHasSuperPlus***

**Criteria for method *setHasSuperPlus*:**

 - value of hasSuperPlus

**Predicates for method *setHasSuperPlus*:**

| Criteria              | Predicate              |
| --------------------- | ---------------------- |
| value of hasSuperPlus | null                   |
|                       | {true, false}          |

**Boundaries**:

| Criteria              | Boundary values |
| --------------------- | --------------- |
| value of hasSuperPlus | true            |
|                       | false           |

**Combination of predicates**:

| Criteria 1    | Valid / Invalid | Description of the test case | JUnit test case     |
| ------------- | --------------- | ---------------------------- | ------------------- |
| null          | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetHasSuperPlus |
| {true, false} | Valid           | T2(false) -> false           | it.polito.ezgas.GasStationTests.testSetHasSuperPlus |



### **Class *User* - method *setHasGas***

**Criteria for method *setHasGas*:**

 - value of hasGas

**Predicates for method *setHasGas*:**

| Criteria        | Predicate              |
| --------------- | ---------------------- |
| value of hasGas | null                   |
|                 | {true, false}          |

**Boundaries**:

| Criteria        | Boundary values |
| --------------- | --------------- |
| value of hasGas | true            |
|                 | false           |

**Combination of predicates**:

| Criteria 1    | Valid / Invalid | Description of the test case | JUnit test case |
| ------------- | --------------- | ---------------------------- | --------------- |
| null          | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetHasGas |
| {true, false} | Valid           | T2(true) -> true             | it.polito.ezgas.GasStationTests.testSetHasGas |



### **Class *User* - method *setHasMethane***

**Criteria for method *setHasMethane*:**

 - value of hasMethane

**Predicates for method *setHasMethane*:**

| Criteria            | Predicate              |
| ------------------- | ---------------------- |
| value of hasMethane | null                   |
|                     | {true, false}          |

**Boundaries**:

| Criteria            | Boundary values |
| ------------------- | --------------- |
| value of hasMethane | true            |
|                     | false           |

**Combination of predicates**:

| Criteria 1    | Valid / Invalid | Description of the test case | JUnit test case   |
| ------------- | --------------- | ---------------------------- | ----------------- |
| null          | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetHasMethane |
| {true, false} | Valid           | T2(false) -> false           | it.polito.ezgas.GasStationTests.testSetHasMethane |



### **Class *GasStation* - method *setLat***

**Criteria for method *setLat*:**

 - value of lat

**Predicates for method *setLat*:**

| Criteria     | Predicate              |
| ------------ | ---------------------- |
| value of lat | [mindouble, maxdouble] |

**Boundaries**:

| Criteria     | Boundary values |
| ------------ | --------------- |
| value of lat | mindouble - 1   |
|              | mindouble       |
|              | mindouble + 1   |
|              | maxdouble - 1   |
|              | maxdouble       |
|              | maxdouble + 1   |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case |
| ---------------------- | --------------- | ---------------------------- | --------------- |
| [mindouble, maxdouble] | Valid           | T1(45.987) -> 45.987         | it.polito.ezgas.GasStationTests.testSetLat |
| mindouble - 1          | Invalid         | T2(mindouble - 1) -> Error   | it.polito.ezgas.GasStationTests.testSetLat |
| maxdouble + 1          | Invalid         | T3(maxdouble + 1) -> Error   | it.polito.ezgas.GasStationTests.testSetLat |



### **Class *GasStation* - method *setLon***

**Criteria for method *setLon*:**

 - value of lon

**Predicates for method *setLon*:**

| Criteria     | Predicate              |
| ------------ | ---------------------- |
| value of lon | [mindouble, maxdouble] |

**Boundaries**:

| Criteria     | Boundary values |
| ------------ | --------------- |
| value of lon | mindouble - 1   |
|              | mindouble       |
|              | mindouble + 1   |
|              | maxdouble - 1   |
|              | maxdouble       |
|              | maxdouble + 1   |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case |
| ---------------------- | --------------- | ---------------------------- | --------------- |
| [mindouble, maxdouble] | Valid           | T1(-21.04) -> -21.04         | it.polito.ezgas.GasStationTests.testSetLon |
| mindouble - 1          | Invalid         | T2(mindouble - 1) -> Error   | it.polito.ezgas.GasStationTests.testSetLon |
| maxdouble + 1          | Invalid         | T3(maxdouble + 1) -> Error   | it.polito.ezgas.GasStationTests.testSetLon |



### **Class *GasStation* - method *setDieselPrice***

**Criteria for method *setDieselPrice*:**

 - value of dieselPrice

**Predicates for method *setDieselPrice*:**

| Criteria             | Predicate              |
| -------------------- | ---------------------- |
| value of dieselPrice | [mindouble, maxdouble] |

**Boundaries**:

| Criteria             | Boundary values |
| -------------------- | --------------- |
| value of dieselPrice | mindouble - 1   |
|                      | mindouble       |
|                      | mindouble + 1   |
|                      | maxdouble - 1   |
|                      | maxdouble       |
|                      | maxdouble + 1   |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case    |
| ---------------------- | --------------- | ---------------------------- | ------------------ |
| [mindouble, maxdouble] | Valid           | T1(1.39) -> 1.39             | it.polito.ezgas.GasStationTests.testSetDieselPrice |
| mindouble - 1          | Invalid         | T2(mindouble - 1) -> Error   | it.polito.ezgas.GasStationTests.testSetDieselPrice |
| maxdouble + 1          | Invalid         | T3(maxdouble + 1) -> Error   | it.polito.ezgas.GasStationTests.testSetDieselPrice |


### **Class *GasStation* - method *setSuperPrice***

**Criteria for method *setSuperPrice*:**

 - value of superPrice

**Predicates for method *setSuperPrice*:**

| Criteria            | Predicate              |
| ------------------- | ---------------------- |
| value of superPrice | [mindouble, maxdouble] |

**Boundaries**:

| Criteria            | Boundary values |
| ------------------- | --------------- |
| value of superPrice | mindouble - 1   |
|                     | mindouble       |
|                     | mindouble + 1   |
|                     | maxdouble - 1   |
|                     | maxdouble       |
|                     | maxdouble + 1   |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case   |
| ---------------------- | --------------- | ---------------------------- | ----------------- |
| [mindouble, maxdouble] | Valid           | T1(1.49) -> 1.49             | it.polito.ezgas.GasStationTests.testSetSuperPrice |
| mindouble - 1          | Invalid         | T2(mindouble - 1) -> Error   | it.polito.ezgas.GasStationTests.testSetSuperPrice |
| maxdouble + 1          | Invalid         | T3(maxdouble + 1) -> Error   | it.polito.ezgas.GasStationTests.testSetSuperPrice |



### **Class *GasStation* - method *setSuperPlusPrice***

**Criteria for method *setSuperPlusPrice*:**

 - value of superPlusPrice

**Predicates for method *setSuperPlusPrice*:**

| Criteria                | Predicate              |
| ----------------------- | ---------------------- |
| value of superPlusPrice | [mindouble, maxdouble] |

**Boundaries**:

| Criteria                | Boundary values |
| ----------------------- | --------------- |
| value of superPlusPrice | mindouble - 1   |
|                         | mindouble       |
|                         | mindouble + 1   |
|                         | maxdouble - 1   |
|                         | maxdouble       |
|                         | maxdouble + 1   |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case       |
| ---------------------- | --------------- | ---------------------------- | --------------------- |
| [mindouble, maxdouble] | Valid           | T1(1.56) -> 1.56             | it.polito.ezgas.GasStationTests.testSetSuperPlusPrice |
| mindouble - 1          | Invalid         | T2(mindouble - 1) -> Error   | it.polito.ezgas.GasStationTests.testSetSuperPlusPrice |
| maxdouble + 1          | Invalid         | T3(maxdouble + 1) -> Error   | it.polito.ezgas.GasStationTests.testSetSuperPlusPrice |



### **Class *GasStation* - method *setGasPrice***

**Criteria for method *setGasPrice*:**

 - value of gasPrice

**Predicates for method *setGasPrice*:**

| Criteria          | Predicate              |
| ----------------- | ---------------------- |
| value of gasPrice | [mindouble, maxdouble] |

**Boundaries**:

| Criteria          | Boundary values |
| ----------------- | --------------- |
| value of gasPrice | mindouble - 1   |
|                   | mindouble       |
|                   | mindouble + 1   |
|                   | maxdouble - 1   |
|                   | maxdouble       |
|                   | maxdouble + 1   |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case |
| ---------------------- | --------------- | ---------------------------- | --------------- |
| [mindouble, maxdouble] | Valid           | T1(0.79) -> 0.79             | it.polito.ezgas.GasStationTests.testSetGasPrice |
| mindouble - 1          | Invalid         | T2(mindouble - 1) -> Error   | it.polito.ezgas.GasStationTests.testSetGasPrice |
| maxdouble + 1          | Invalid         | T3(maxdouble + 1) -> Error   | it.polito.ezgas.GasStationTests.testSetGasPrice |



### **Class *GasStation* - method *setMethanePrice***

**Criteria for method *setMethanePrice*:**

 - value of methanePrice

**Predicates for method *setMethanePrice*:**

| Criteria              | Predicate              |
| --------------------- | ---------------------- |
| value of methanePrice | [mindouble, maxdouble] |

**Boundaries**:

| Criteria              | Boundary values |
| --------------------- | --------------- |
| value of methanePrice | mindouble - 1   |
|                       | mindouble       |
|                       | mindouble + 1   |
|                       | maxdouble - 1   |
|                       | maxdouble       |
|                       | maxdouble + 1   |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case     |
| ---------------------- | --------------- | ---------------------------- | ------------------- |
| [mindouble, maxdouble] | Valid           | T1(0.69) -> 0.69             | it.polito.ezgas.GasStationTests.testSetMethanePrice |
| mindouble - 1          | Invalid         | T2(mindouble - 1) -> Error   | it.polito.ezgas.GasStationTests.testSetMethanePrice |
| maxdouble + 1          | Invalid         | T3(maxdouble + 1) -> Error   | it.polito.ezgas.GasStationTests.testSetMethanePrice |



### **Class *GasStation* - method *setUser***

**Criteria for method *setUser*:**

 - value of user

**Predicates for method *setUser*:**

| Criteria      | Predicate     |
| ------------- | ------------- |
| value of user | null          |
|               | User instance |

**Combination of predicates**:

| Criteria 1    | Valid / Invalid | Description of the test case | JUnit test case |
| ------------- | --------------- | ---------------------------- | --------------- |
| null          | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetUser |
| User instance | Valid           | T1(user) -> user             | it.polito.ezgas.GasStationTests.testSetUser |



### **Class *GasStation* - method *setCarSharing***

**Criteria for method *setCarSharing*:**

 - value of carSharing

**Predicates for method *setCarSharing*:**

| Criteria            | Predicate              |
| ------------------- | ---------------------- |
| value of carSharing | null                   |
|                     | sequence of characters |

**Boundaries**:

| Criteria            | Boundary values |
| ------------------- | --------------- |
| value of carSharing | null            |
|                     | ""              |

**Combination of predicates**:

| Criteria 1             | Valid / Invalid | Description of the test case | JUnit test case   |
| ---------------------- | --------------- | ---------------------------- | ----------------- |
| null                   | Valid           | T1(null) -> null             | it.polito.ezgas.GasStationTests.testSetCarSharing |
| sequence of characters | Valid           | T2("Enjoy") -> "Enjoy"       | it.polito.ezgas.GasStationTests.testSetCarSharing |
| empty string           | Valid           | T3("") -> ""                 | it.polito.ezgas.GasStationTests.testSetCarSharing |






# White Box Unit Tests

### Test cases definition
    
    <JUnit test classes must be in src/test/java/it/polito/ezgas>
    <Report here all the created JUnit test cases, and the units/classes under test >
    <For traceability write the class and method name that contains the test case>


| Unit name     | JUnit test case   |
| ------------- | ----------------- |
| ***User***    | ***UserTests***   |
| getUserId     | testGetUserId     |
| setUserId     | testSetUserId     |
| getUserName   | testGetUserName   |
| setUserName   | testSetUserName   |
| getPassword   | testGetPassword   |
| setPassword   | testSetPassword   |
| getEmail      | testGetEmail      |
| setEmail      | testSetEmail      |
| getReputation | testGetReputation |
| setReputation | testSetReputation |
| getAdmin      | testGetAdmin      |
| setAdmin      | testSetAdmin      |
| ***GasStation***       | ***GasStationTests***      |
| getGasStationId        | testGetGasStationId        |
| setGasStationId        | testSetGasStationId        |
| getGasStationName      | testGetGasStationName      |
| setGasStationName      | testSetGasStationName      |
| getGasStationAddress   | testGetGasStationAddress   |
| setGasStationAddress   | testSetGasStationAddress   |
| getReportDependability | testGetReportDependability |
| setReportDependability | testSetReportDependability |
| getReportUser          | testGetReportUser          |
| setReportUser          | testSetReportUser          |
| getReportTimestamp     | testGetReportTimestamp     |
| setReportTimestamp     | testSetReportTimestamp     |
| getHasDiesel           | testGetHasDiesel           |
| setHasDiesel           | testSetHasDiesel           |
| getHasSuper            | testGetHasSuper            |
| setHasSuper            | testSetHasSuper            |
| getHasSuperPlus        | testGetHasSuperPlus        |
| setHasSuperPlus        | testSetHasSuperPlus        |
| getHasGas              | testGetHasGas              |
| setHasGas              | testSetHasGas              |
| getHasMethane          | testGetHasMethane          |
| setHasMethane          | testSetHasMethane          |
| getLat                 | testGetLat                 |
| setLat                 | testSetLat                 |
| getLon                 | testGetLon                 |
| setLon                 | testSetLon                 |
| getDieselPrice         | testGetDieselPrice         |
| setDieselPrice         | testSetDieselPrice         |
| getSuperPrice          | testGetSuperPrice          |
| setSuperPrice          | testSetSuperPrice          |
| getSuperPlusPrice      | testGetSuperPlusPrice      |
| setSuperPlusPrice      | testSetSuperPlusPrice      |
| getGasPrice            | testGetGasPrice            |
| setGasPrice            | testSetGasPrice            |
| getMethanePrice        | testGetMethanePrice        |
| setMethanePrice        | testSetMethanePrice        |
| getUser                | testGetUser                |
| setUser                | testSetUser                |
| getCarSharing          | testGetCarSharing          |
| setCarSharing          | testSetCarSharing          |


### Code coverage report

    <Add here the screenshot report of the statement and branch coverage obtained using
    the Eclemma tool. >

    ![Gas Station Coverage](GasStationCoverage.jpg?raw=true)
    ![User Coverage](UserCoverage.jpg?raw=true)


### Loop coverage analysis

    <Identify significant loops in the units and reports the test cases
    developed to cover zero, one or multiple iterations >

|Unit name | Loop rows | Number of iterations | JUnit test case |
|---|---|---|---|
|||||
|||||
||||||



