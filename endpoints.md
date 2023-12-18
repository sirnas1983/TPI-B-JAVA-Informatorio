### Usuarios

##### Creando un usuario
metodo: POST
path: URL/api/v1/usuarios
Request body: {
"nombre" : nombre,
"nombreUsuario" : nombre de usuario,
"listasReproduccionDTO" : []
}

##### Perfil de usuario
metodo: GET
path: URL/api/v1/usuarios/id de usuario

##### Todos los Usuarios
metodo: GET
path: URL/api/v1/usuarios

### Canciones

##### Cargando una cancion
metodo: POST
path: URL/api/v1/canciones
Request body: {
"nombre" : nombre,
"duracion" : duracion (double),
"artistaDTO" : {
"nombre" : nombre de artista
},
"album" : nombre de album,
"ranking" : ranking (int),
"generosDTO" : [
{"nombre" : nombre},
{"nombre" : nombre2},
{"nombre" : nombreN}
]
}

##### Filtrado de caciones por titulo, artista, genero y/o album
metodo: PUT
path: URL/api/v1/canciones/id de cancion
Parametros:
titulo (optativo) - Filtra por nombre de cancion
artista (optativo) - Filtra por nombre de artista
genero (optativo) - Filtra por genero
album (optativo) - Filtra por album

### Artistas

##### Informacion del Artista
metodo: GET
path: URL/api/v1/artistas/id de artista

### Listas de Reproduccion:

##### Trae todas las listas de reproduccion (solamente a fines de prueba, no fue solicitado en el TPI)
metodo: GET
path: URL/api/v1/listas-reproduccion

##### Mostrar listas de reproduccion para un usuario
metodo: GET
path: URL/api/v1/listas-reproduccion/id de usuario

##### Crear lista de reproduccion para un usuario
metodo: POST
path: URL/api/v1/listas-reproduccion/id de usuario
Request body: [
id de cancion 1,
id de cancion 2,
.................,
id de cancion n
]

##### Modificar lista de reproduccion
metodo: PUT
path: URL/api/v1/listas-reproduccion/id de lista de reproduccion
Parametros:
publica (optativo) - booleano
repetir (optativo) - booleano
aleatorio (optativo) - booleano
Request body: [
id de cancion 1,
id de cancion 2,
.................,
id de cancion n
] 
nota: en caso de ya existir la cancion en la lista esta sera removida, en caso de no existir sera agregada





