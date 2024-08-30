
Get Employees
GET http://localhost:8080/api/employees

******************

Save Employess
POST http://localhost:8080/api/employees

{
  "employeeId": "E123",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumbers": ["1234567890", "0987654321"],
  "doj": "2023-05-16",
  "salary": 50000
}

*****************

Get Employee Tax By Id
http://localhost:8080/api/employees/E122/tax -> No Tax
http://localhost:8080/api/employees/E123/tax -> Taxable





