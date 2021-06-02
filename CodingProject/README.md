# EvolentTest
Please use postman to test the code.
To add a contact:
POST: http://localhost:8082/addOrUpdateContact
sample request: { "firstName": "def","lastName": "prasad","email": "durga@gmail.com","phoneNo": 1234567890,"status": "Active"}
To list all Contacts:
GET: http://localhost:8082/contacts/
To find a contact:
GET: http://localhost:8082/contacts/{name}
To delete a contact:
GET: http://localhost:8082/contacts/delete/{name}
