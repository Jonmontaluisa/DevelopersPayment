# DevelopersPayment
DevelopersPayment calculate the salary a developer should receive based on the hours worked.

## Specs provided by ioet

The company ACME offers their employees the flexibility to work the hours they want. They will pay for the hours worked based on the day of the week and time of day, according to the following table: <br/>
Monday - Friday <br/>
00:01 - 09:00 25 USD <br/>
09:01 - 18:00 15 USD <br/>
18:01 - 00:00 20 USD <br/>
Saturday and Sunday <br/>
00:01 - 09:00 30 USD <br/>
09:01 - 18:00 20 USD <br/>
18:01 - 00:00 25 USD <br/>
The goal of this exercise is to calculate the total that the company has to pay an employee, based on the hours they worked and the times during which they worked. The following abbreviations will be used for entering data:  
MO: Monday <br/>
TU: Tuesday <br/>
WE: Wednesday <br/>
TH: Thursday <br/>
FR: Friday <br/>
SA: Saturday <br/>
SU: Sunday <br/>


## Testing

Input: the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data.  
Output: indicate how much the employee has to be paid  
For example:  
Case 1:  
INPUT   
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
OUTPUT:   
The amount to pay RENE is: 215 USD   
Case 2:  
INPUT  
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00  
OUTPUT:  
The amount to pay ASTRID is: 85 USD
