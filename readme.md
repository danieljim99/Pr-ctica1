En mi programa he utilizado listas para organizar todos los elementos que se manejan en este, en la clase Category hay una lista estática de categorías,
de esta forma se almacenarán todas las categorías que se vayan creando y estarán unidas todas ellas, del mismo modo los productos, cada categoría
cuenta con una lista de productos que pertenecen a esa categoría, así almacenamos todos los productos cada uno a la categoría a la que pertenecen, así
estarán relacionados productos y categorías. Para el almacenamiento de usuarios también he usado listas, en la clase User hay una lista estática de
usuarios, ya que en mi programa está la opción de crear varios usuarios y loguearse, así cada usuario tiene su carrito diferente, para almacenar los carritos
cada usuario tiene una lista de Strings que almacena los nombres de cada producto que tiene en el carrito.

He utilizado ficheros de texto para poder almacenar todos los datos necesarios en el programa, como categorías, productos, usuarios y carritos, todos con
toda la información necesaria guardada en el fichero, así cada vez que se salga del programa todos los ficheros se actualizan antes de cerrarse por completo,
y cuando se vuelve a ejecutar se precargan todos los datos, volviendo a tener así todas las categorías, productos, usuarios y carritos creados en anteriores
ejecuciones. El formato de estos ficheros sería cada elemento de un objeto de la lista separado por '#' y al final de cada objeto se usa '$' y para el final
del fichero se usa el '!', los elementos de cada objeto se guardan normalmente en el orden en el que se introducen como parámetros en el constructor, en las
funciones reboot que son las que sirven para precargar todo se van recogiendo los elementos de cada objeto almacenando los valores en Strings, y cuando 
encuentra '$' crea el objeto, y al encontrar '!' es que ya no quedan mas objetos por precargar.

Al iniciar el programa nos encontramos con un menú en el que podemos registrarnos, logearnos o salir, si es la primera vez que se ejecuta el programa
no habrá ningún objeto creado, por lo que antes de registrarse se recomienda que nos logueemos como administrador (por defecto admin/admin), con esta cuenta
podremos crear categorías y productos mediante el menú que se muestra en la pantalla, también podremos eliminar productos y categorías, renombrar categorías
y mostrar un índice de categorías con sus productos llamado "Storage tree", donde podremos consultar los nombres e IDs necesarios para crear productos.
No se podrán crear dos productos con el mismo nombre, ni dos categorías con el mismo nombre, si al crear un producto le asignamos el ID de una categoría
inexistente se creará automáticamente una categoría con el nombre "Undefinedcategory(<ID>)" y el producto se añadirá a esta, los IDs de las categorías y de los
productos se asignan automáticamente mediante un entero a modo de contador, de este modo evitamos repetidos, ya que el administrador necesita usar los IDs
para referirse a productos y categorías. Al eliminar una categoría también se borrarán todos los productos que contiene, es una forma rápida de eliminar
un grupo de productos, de esta forma también, si alguno de esos productos estaba en algún carrito de algún usuario será eliminado también. Si elegimos la
opción de salir del menú de administrador volveremos al menú inicial anterior.

Al registrarnos nos pedirán que introduzcamos un nombre de usuario y una contraseña, ambos deben tener al menos 8 caracteres, y no se puede utilizar
un nombre de usuario que ya esté en uso, por lo que admin tampoco estará disponible, la contraseña se cifra mediante una serie de operaciones que se le aplica
a cada caracter que la compone, de forma que la cadena de caracteres resultante no tiene nada que ver con la contraseña original, y esta cadena cifrada
será la que se almacene en el fichero de texto, y no la original. Una vez nos hayamos registrados con éxito entraremos en el menú de usuario, en este menú
podemos elegir entre varias opciones como mostrar todas las categorías, mostrar todos los productos de una categoría indicando su nombre, mostrar la
información del producto que nosotros indiquemos, añadir un producto a nuestro carrito, mostrar nuestro carrito y por último, eliminar un producto del carrito.
Al añadir un producto al carrito, su stock disminuirá en una unidad, por lo que al eliminarlo de nuestro carrito volverá a aumentar en una unidad. No se
puede añadir un producto que ya esté en nuestro carrito, ni tampoco un producto que tenga un stock a cero. Al seleccionar la opción de salir volveremos al menú 
principal anterior. Si ya tenemos un usuario registrado podemos loguearnos, nos pedirá un nombre de usuario y una contraseña, ambos deben coincidir con los
que ya estan registrados en la lista de usuarios, compara el nombre de usuario introducido con el que hay guardado y la contraseña introducida cifrada con
la cadena cifrada que ya hay guardada, si todo coincide como es debido nos llevará de nuevo al menú de usuario.

Los métodos se basan sobretodo en el uso de bucles for para buscar elementos en las listas correspondientes y en el uso de los métodos de los que
disponen las listas como add(Object), remove(index) o get(index); también he utilizado los métodos del tipo get y set de las clases ya sea para buscar,
comprobar o modificar atributos de los objetos. En los constructores he utilizado un boolean para indicar si el objeto que estoy creando será un
objeto que deba permanecer guardado como por ejemplo un producto que crea el administrador, o uno que sea solo temporal para buscar otros productos,
la diferencia entre ellos es que uno se añade al fichero de texto y el otro solo ocupa memoria mientras el programa se ejecuta hasta que se detiene.

