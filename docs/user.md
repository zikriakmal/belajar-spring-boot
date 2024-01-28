# User API Spec

## Register User

- Endpoint : POST /api/users

Request Body :

```json
{
  "name": "string",
  "username": "string",
  "password": "string"
}
```

Response Body (Success) : 
```json
{
  "data": "OK" 

}
```

Response Body (Failed):
```json
{
  "errors": "Username must not blank, ???"
}
```

## Login User

- Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username": "string",
  "password": "string"
}
```

Response Body (Success) :
```json
{
  "data": {
    "token": "TOKEN",
    "expiredAt":2332233
  } 
}
```

Response Body (Failed):
```json
{
  "errors": "Username or password wrong, ???"
}
```

## Get User

- Endpoint : GET /api/users/current

Request Header : 
- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
```

Response Body (Success) :
```json
{
  "data": {
    "username": "zikri",
    "name":"Zikri Akmal Santoso"
  } 
}
```

Response Body (Failed, 401):
```json
{
  "errors": "Unauthorized"
}
```

## Update User

- Endpoint : PATCH /api/users/current

Request Header :
- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "name": "Zikri Akmales",
  "password": "New Password"
}
```

Response Body (Success) :
```json
{
  "data": {
    "username": "zikri",
    "name": "Zikri Akmal Santoso"
  }
}
```

Response Body (Failed, 401):
```json
{
  "errors": "Unauthorized"
}
```

## Logout User

- Endpoint : POST /api/auth/logout

Request Header :
- X-API-TOKEN : Token (Mandatory)

