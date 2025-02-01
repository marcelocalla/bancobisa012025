/*(1)  servicio creaBlog */
curl --location 'http://localhost:8090/api/v1/blog/createBlog' \
--header 'Content-Type: application/json' \
--data '{
    "author": {
        "id": 1,
        "nombres": "Chelo",
        "apellidoPaterno": "Calla",
        "apellidoMaterno": "Valeriano",
        "fechaNacimiento": "2000-04-06",
        "paisResidencia": "Bulgaria",
        "correo": "chelito"
    },
    "blog": {
        "titulo":"PLATACION DE PAPAS",
        "tema":"INVERNADERO",
        "comentarios":true,
        "codigoPeriodicidad":"SEMANAL",
        "contenido":{
            "data":"NUEVA POLINIZACION"
        }
    }
}'

/*(2) createComentario */

curl --location 'http://localhost:8090/api/v1/com/createComentario' \
--header 'Content-Type: application/json' \
--data-raw '{
    "auth":{
        "nombres":"Chelo",
        "paisResidencia":"Bulgaria",
        "correo":"chelito@mmc.com"
    },
    "tituloBlog":"PLATACION DE PAPAS",
    "comentario":{
        "comentario":"NUEVA VIDA EN OTRO PLANETA",
        "puntuacion":10
    }
}'


/*(3) Actualiza comentarios */

curl --location 'http://localhost:8090/api/v1/com/editComentario/1738440573597' \
--header 'Content-Type: application/json' \
--data-raw '{
    "auth":{
        "nombres":"Chelo",
        "paisResidencia":"Bulgaria",
        "correo":"chelito@mmc.com"
    },
    "tituloBlog":"PLATACION DE PAPAS",
    "comentario":{
        "comentario":"otra nueva vida en otro lugar con la naturaleza",
        "puntuacion":5
    }
}'


/*(4) consulta por un datos por id */

curl --location 'http://localhost:8090/api/v1/blog/consultaBlogByid/1738438519918' \
--header 'Content-Type: application/json'


/*(5) consulta todos los registros */
curl --location 'http://localhost:8090/api/v1/blog/consultaBlog' \
--header 'Content-Type: application/json'





