Añadir un filtro por IP, para ello se tendrá que crear una tabla de AUTHORIZED_IPS

Añadir a los claims del JWT tanto la IP como la localización del usuario (Habrá que cambiar la entrada del login para
que reciba HttpServletRequest en vez de AuthRequestDTO)

Añadir el rol del usuario al JWT

Añadir un nuevo controller con un endpoint que devuelva el listado de usuarios con la siguiente condición:

- Si el usuario tiene rol ADMIN devuelve el listado entero
- Si el usuario tiene rol GESTION devuelve el listado entero sin los administradores
- Si el usuario tiene rol CONSULTA devuelve únicamente su usuario

Añadir un botón en hello y helloAdmin que redirija a una pantalla nueva que muestre la tabla con los usuarios que
puede consultar (Consumiendo el controller del paso anterior)
