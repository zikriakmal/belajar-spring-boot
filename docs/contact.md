# Contact API Spec


## Create Contact

Endpoint : POST /api/contacts

Request Header:
- X-API-TOKEN : Token (Mandatory)

Request Body:
```json
 {
  "firstName" : "Zikri Akmal",
  "lastName" : "Santoso",
  "email": "zikriakmale@gmail.com",
  "phone"  : "085363502837"
}
```

Response Body (Success): 
```json
 {
  "data": {
    "id" : "random string",
    "firstName": "Zikri Akmal",
    "lastName": "Santoso",
    "email": "zikriakmale@gmail.com",
    "phone": "085363502837"
  }
}
```

Response Body (Failed): 
```json
{
  "errors": "Email format invalid, phone format invalid, etc"
}
```

## Update Contact

Endpoint : PUT /api/contacts/{idContact}

Request Header:
- X-API-TOKEN : Token (Mandatory)

Response Body (Success):
```json
 {
  "data": {
    "id" : "random string",
    "firstName": "Zikri Akmal",
    "lastName": "Santoso",
    "email": "zikriakmale@gmail.com",
    "phone": "085363502837"
  }
}
```

Response Body (Failed):
```json
{
  "errors": "Email format invalid, phone format invalid, etc"
}
```

## Get Contact

Endpoint : GET /api/contacts/{idContact}

Request Header:
- X-API-TOKEN : Token (Mandatory)

Request Body:


Response Body (Success):
```json
 {
  "data": {
    "id" : "random string",
    "firstName": "Zikri Akmal",
    "lastName": "Santoso",
    "email": "zikriakmale@gmail.com",
    "phone": "085363502837"
  }
}
```

Response Body (Failed, 404):
```json
{
  "errors": "Contact is not found"
}
```

## Search Contact

Endpoint : GET /api/contacts

Query Param: 
- name : String, contact firstName or lastName, using like query (optional)
- phone : String, contact phone, using like query (optional)
- email : String, contact email, using like query (optional)
- page : Integer, start from 0 (default 0)
- size : Integer,(default 0) 

Request Header:
- X-API-TOKEN : Token (Mandatory)

Response Body (Success):
```json
 {
  "data": [
    {
      "id": "random string",
      "firstName": "Zikri Akmal",
      "lastName": "Santoso",
      "email": "zikriakmale@gmail.com",
      "phone": "085363502837"
    },
    {
      "id": "random string",
      "firstName": "Zikri Akmal",
      "lastName": "Santoso",
      "email": "zikriakmale@gmail.com",
      "phone": "085363502837"
    }
  ],
  "paging": {
    "currentPage": 0,
    "totalPage": 10,
    "size": 10
  }
}
```


Response Body (Failed, 401):
```json
{
  "errors": "Unauthorized"
}
```

## Remove Contact

Endpoint : DELETE /api/contacts/{idContact}

Request Header:
- X-API-TOKEN : Token (Mandatory)


Response Body (Success):
```json
{
  "data": "OK"
}
```

Response Body (Failed, 404):
```json
{
  "errors": "Contact is not found"
}
```