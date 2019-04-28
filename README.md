# CC3002 - Tarea 1 : Pokemon TCG: Elementos basicos

En esta tarea se implementan los elementos básicos para el juego de cartas Pokemon. Existen las cartas de tipo energía y las de tipo Pokemon. Las cartas energías se usan para añadirlas al Pokemon activo de un entrenador. 
Tanto los Pokemon como las energias pueden ser de 6 tipos distintos: agua, rayo, planta, psíquico, lucha o fuego. 
Cada Pokemon tiene debilidades y resistencias dependiendo de su tipo. 
El entrenador cuenta con una mano con cartas ilimitadas, un Pokemon activo y una banca con un máximo de 5 Pokemon. 

### Prerequisitos

El proyecto fue realizado en IntelliJ, por lo que se necesitará para iniciarlo de manera efectiva. 

### Implementación

Se una interfaz para las cartas (Icard) que es extendida en las interfaces correspondientes a los **Pokemon** *(IPokemon)* y **Energías** *(IEnergy)*. Esto debido a que luego en la banca del entrenador se aceptan solo Pokemon, mientras que los Pokemon tienen energias asociadas. Por esto hay que hacer una diferencia. 
Se crea una clase abstracta para los Pokemon (**AbstractPokemon**) que implementa **IPokemon** y será extendida por los seis tipos de Pokemon. 
El constructor de AbstractPokemon es de la forma: **_AbstractPokemon(int aId, int anHp, ArrayList<IEnergy> anEnergies, ArrayList<IAttack> anAttacks)_** donde se ve que cada Pokemon posee un ID, HP, una lista de energías y una lista de ataques que puede ser de un máximo de 4. 
También cuenta con getters y setter para sus variables, un método para atacar a otro Pokemon y otros para cuando recibe ataques. Dependiendo del tipo de ataque recibido será el daño que reciba, ya que como se mencionó antes los Pokemon tienen resistencias y debilidades. Pero esa diferencia se hace en las clases que implementan la clase abstracta. Entre otros. 

La otra interfaz que se tiene es para los ataques, ya que estos tambien pueden ser de seis tipos distintos. Al igual que Pokemon, se creó un **AbstractAttack** que luego fue extendido por las clases de los distintos tipos de ataques. Tiene un constructor de la forma **_AbstractAttack(String aName, int aBaseDamage, int aCost, String aDescriptiveText)_** donde las variables corresponden al nombre del ataque, el daño base que causa, el costo asociado (cantidad de cartas de energía necesarias para realizar el ataque) y una breve descripción del ataque. Existen getters para cada una de estas variables. 

Finalmente se crea la clase **Trainer** que será el entrenador Pokemon, su constructor es **_Trainer()_** en donde sus variables se setean como _activePokemon = null_ (ya que al principio del juego no hay pokemon activo), _hand = new ArrayList<ICard> ()_ (en donde se irán agregando las cartas a la mano) y _bench = new ArrayList<IPokemon>()_ (en donde se irán agregando Pokemon jugados desde la mano del entrenador).

El patrón de diseño ocupado fue Double Dispatch para el momento en que el entrenador elige una carta para jugar desde su mano, donde hay que ver el tipo de carta (energía o pokemon) y según eso relizar una acción. También se usa para diferenciar entre los tipos de las cartas y los ataques. 
## Iniciando los test

Todos los test del proyecto se encuentran en la carpeta test. Se encuentran separados por tipo del objeto (fire, water, etc) y existe una carpeta solo para el test que corresponde al Trainer. Seleccionando la carpeta test para hacer el run hará que corran todos los test del proyecto. Se intenta testear la gran mayoría de los métodos de cada clase. 

## Autor

* **Catalina Rojas**

## Acknowledgments

Algunas de las funcionalidades fueron basadas en el auxiliar 3 del curso. 

# cc3002-tarea1
