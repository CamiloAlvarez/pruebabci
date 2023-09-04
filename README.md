# pruebabci

- Importar proyecto en eclipse como proyecto maven
- Run Project
- Con postman crear requests de prueba:
  
  Lista Usuarios:
  
  url: [server]:8080/usuarios
  
  response: [
              {
                  "id": 2,
                  "name": "Juan Rodriguez",
                  "email": "juan@rodriguez.org",
                  "pass": "hunter2",
                  "created": "09-03-2023 21:58:41",
                  "modified": "09-03-2023 21:58:41",
                  "isActive": 1
              },
                  "id": 3,
                  "name": "Juan Rodriguez 2",
                  "email": "juan2@rodriguez.org",
                  "pass": "hunter",
                  "created": "09-03-2023 21:58:41",
                  "modified": "09-03-2023 21:58:41",
                  "isActive": 1
          ]

  Crear Usuario:
  
  url: [server]:8080/crearUsuario

  request:

  {
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.orgo",
    "pass": "hunter",
    "phones": [
    {
        "number": "1234567",
        "citycode": "1",
        "countrycode": "57"
    }
    ]
  }

  response:

  {
    "id": 2,
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.orgo",
    "pass": "hunter",
    "created": "09-03-2023 21:58:41",
    "modified": "09-03-2023 21:58:41",
    "isActive": 1,
  }

  Editar Usuario:

  url: [server]:8080/editarUsuario

  request:

  {
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.orgo",
    "pass": "hunter",
    "phones": [
    {
        "number": "1234567",
        "citycode": "1",
        "countrycode": "57"
    }
    ]
  }

  response:

  {
    "id": 2,
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.orgo",
    "pass": "hunter",
    "created": "09-03-2023 21:58:41",
    "modified": "09-03-2023 21:58:41",
    "isActive": 1,
  }

  Eliminar Usuario:

  url: [server]:8080/eliminarUsuario/1
