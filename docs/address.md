# Address API Spec

## Create Address

Endpoint : POST /api/contacts/{idContact}/addresses 

Request Header : 

- X-API-TOKEN : TOKEN

Request Body : 
```json
{
  "street": "Jalan apa",
  "city": "Medan",
  "province": "Sumatera Utara",
  "country": "Indonesia",
  "postalCode": "20122"
}
```


Response Body (Success) : 
```json
{
  "data": {
    "id": "randomstring",
    "street": "Jalan apa",
    "city": "Medan",
    "province": "Sumatera Utara",
    "country": "Indonesia",
    "postalCode": "20122"
  }
}
```

Response Body (Failed): 
```json
{
  "errors": "Contact is not found"
}
```

## Update Address

Endpoint : PUT /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : TOKEN


Request Body :
```json
{
  "street": "Jalan apa",
  "city": "Medan",
  "province": "Sumatera Utara",
  "country": "Indonesia",
  "postalCode": "20122"
}
```


Response Body (Success) :
```json
{
  "data": {
    "id": "randomstring",
    "street": "Jalan apa",
    "city": "Medan",
    "province": "Sumatera Utara",
    "country": "Indonesia",
    "postalCode": "20122"
  }
}
```

Response Body (Failed):
```json
{
  "errors": "Contact is not found"
}
```

## Get Address

Endpoint : GET /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : TOKEN


Response Body (Success) :
```json
{
  "data": {
    "id": "randomstring",
    "street": "Jalan apa",
    "city": "Medan",
    "province": "Sumatera Utara",
    "country": "Indonesia",
    "postalCode": "20122"
  }
}
```
Response Body (Failed):
```json
{
  "errors": "Address is not found"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : TOKEN

Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Failed):
```json
{
  "errors": "Address not found"
}
```

## List Address

Endpoint : GET /api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : TOKEN


Response Body (Success) :
```json
{
  "data": [
    {
      "id": "randomstring",
      "street": "Jalan apa",
      "city": "Medan",
      "province": "Sumatera Utara",
      "country": "Indonesia",
      "postalCode": "20122"
    },
    {
      "id": "randomstring",
      "street": "Jalan apa",
      "city": "Medan",
      "province": "Sumatera Utara",
      "country": "Indonesia",
      "postalCode": "20122"
    }
  ]
}
```

Response Body (Failed):
```json
{
  "errors": "Contact is not found"
}
```