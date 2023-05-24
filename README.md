El sistema funciona de la siguiente manera: un cliente puede darse de alta de una cuenta en el cajero e iniciar sesion en la
misma para administrar su dinero. Un cliente puede tener varias cuentas y tambien puede no tener ninguna. Puede darse
de baja en cualquier momento pero debera vaciar su cuenta antes de eliminarla, ya sea via transferencia a otra cuenta o
via retirada en efectivo.
Dentro de una cuenta, un cliente puede ingresar dinero en efectivo, retirar dinero en efectivo, hacer una transferencia
bancaria a cualquier otra cuenta y recibir una transferencia bancaria de cualquier otra cuenta. Por el momento el sistema
solamente opera en euros pero se plantea en un futuro añadir cambios de monedas.

Para guardar la información he usado una base de datos MySQL gestionado por PHPMyAdmin en un servidor local XAMPP, el mismo PHPMyAdmin ha generado un .pdf donde se ve la estructura básica de las tablas creadas aunque faltan por documentar las foreign keys:
-En cuentabancaria el nombreBanco hace referencia al atributo nombre de la tabla banco
-En titular el emailPersona hace referencia al atributo email de la tabla persona
-En titular el idCuenta hace referencia al atributo id de la tabla cuenta
-En transferencia el nombreEmisor hace referencia al atributo nombreUsuario de la tabla titular
-En transferencia el nombreReceptor hace referencia al atributo nombreUsuario de la tabla titular
-En transferencia el fechayhora hace referencia al atributo fechayhora de la tabla fechayhora
-En operacion el nombreUsuario hace referencia al atributo nombreUsuario de la tabla titular
-En operacion el fechayhora hace referencia al atributo fechayhora de la tabla fechayhora
-En ingreso el nombreUsuario hace referencia al atributo nombreUsuario de la tabla operacion
-En ingreso el fechayhora hace referencia al atributo fechayhora de la tabla operacion
-En retirada el nombreUsuario hace referencia al atributo nombreUsuario de la tabla operacion
-En retirada el fechayhora hace referencia al atributo fechayhora de la tabla operacion
