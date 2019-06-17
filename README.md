# CC3002 - Tarea 2 : Pokemon TCG: Electric Boogaloo

Siguiendo la implementación de la tarea 1, en la tarea 2 se añaden nuevos tipos de cartas, pokemon evolucionados y un controlador para el juego.  

### Prerequisitos

El proyecto fue realizado en IntelliJ, por lo que se necesitará para iniciarlo de manera efectiva. 

### Implementación

A grandes rasgos la mayoría de los nuevos métodos implementados fueron hechos con una clase visitor que, dependiendo de lo que visitaba, deriva lo que se va a hacer en cada caso. 
Tenemos tres tipos de visitor: 

	* EnergyVisitor: visita los distintos tipos de energía
	* PokemonVisitor: visita los distintos tipos de pokemon
	* TrainerCardVisitor: visita las distintas cartas de entrenador. 

	* Cada una de estas clases hace Overrides de algunos métodos de la clase abstracta Visitor.  
	* Cada tipo de carta tiene un método play en su clase abstracta quien es el encargado de aceptar el visitor según el tipo de carta. 

**Entrenador**

	* Tiene un mazo de cartas, una pila de descarte y hasta seis cartas premio, las cuales también son sacadas desde el mazo.
	* Sabe cual es el controlador que se hace cargo de el. 

**Energías**

	* Ahora también pueden agregarse a un pokemon de la banca, por lo que se crea un método para seleccionar el pokemon al que se le agregará la energía antes de jugarla *(setSelectedPokemon)* además puede jugarse una por turno. De esto último estará encargado el controlador del juego que irá viendo los distintos estados según las acciones que se realicen. 

**Evoluciones**

	*Los Pokemon ahora pueden ser Básicos, Fase1 o Fase2. Por esto se crean interfaces para uno y luego clases abstractas según tipo (agua, fuego, etc). El método accept de cada pokemon hace un visit diferente según el tipo. 
	* Se sabe que un pokemon es preevolución de otra porque está estipulado su id en la evolución. Si quiere jugarse una carta fase1 o fase2, el pokemon seleccionado debe ser preevolución de esta.

**Controlador**
	
	* El controlador maneja la lógica de una partida, se asume que se está en medio de un turno. Tienen conocimiento de los entrenadores y de quien es el entrenador actual. 
	* Se hizo un clase **State** (utilizando el State Pattern) que maneja los estados de un turno, tales como si se ha robado una carta, ver que no se juegue más de una energía, ver si se ha ocupado una habilidad o si se ha atacado al pokemon del oponente que hace que termine el turno, etc. 
	* Las acciones que tienen que poder realizarse en un turno son: 
		1. robar carta: se utiliza *drawCard()* en donde se cambia el estado del juego y se permite que se realicen otras acciones en el turno 
		2. Ver las cartas de su mano: se ocupa *lookAtHand()* y devuelve todas las cartas del entrenador actual. 
		3. jugar una carta de su mano: se utiliza el método *play(int index)* con *index* el índice de la carta de su mano que quiere jugarse. Aquí entra en juego el visitor, porque según el tipo de carta es el visitor que se ocupará y la acción que se realizará. 
		3. utilizar alguna habilidad de su pokemon activo: primero hay que usar *selectAbility(int index)* que elige la habilidad a ocupar del pokemon activo y luego *useAbility()* utiliza dicha habilidad y cambia el estado del juego si es que corresponde. 
		4. terminar turno o atacar: se puede usar *endTurn()* para terminar el turno o sino atacar al pokemon del oponente que hará que se acabe en turno de todas formas. 


**Habilidades**

	* Ahora se tienen habilidades y ataques, los ataques son un tipo particular de habilidad y son lo último que puede hacer un jugador antes que se acabe su turno. 

	* Se implementó la habilidad Heal, la cual cura a un pokemon 10 HP si es que sale cara al tirar una moneda. Como puede usarse una vez por turno, el controlador tiene que tener un cambio de estado que avise que ya se ha jugado una habilidad. 
	* Se implementó el ataque ElectricShock, el cual se asumió es un tipo de ataque eléctrico. En este se tira una moneda y si sale sello el pokemon del oponente recibe x de daño. 

**Objetos**

	* Se implementó el objeto Potion, el cual remueve x de daño de un pokemon. 

**Estadios**

	* Se implementó el LuckyStadium, el que perminte que una vez durante su turno, el jugador puede lanzar una moneda. Si sale
	cara, el jugador roba una carta. Para implementarlo se utilizó visitor y state para cambiar el estado del controlador. 

**Soporte**

	Se implementaron las siguientes cartas, ambas utilizando visitor: 
	* Professor Cozmo's Discovery: Lanza una moneda. Si sale cara roba las 3 últimas cartas
	de tu mazo. Si sale sello roba las 2 primeras.
	* Professor Juniper: Descarta tu mano y roba 7 cartas.

## Iniciando los test

Todos los test del proyecto se encuentran en la carpeta test. Se encuentran separados por Pokemon, Ataque, Energía, Entrenador y Controlador. Seleccionando la carpeta test para hacer el run hará que corran todos los test del proyecto. Se intenta testear la gran mayoría de los métodos de cada clase para alcanzar el 90% de coverage. 

## Autor

* **Catalina Rojas**


## Acknowledgments

Algunas de las funcionalidades fueron basadas en el auxiliar 3 del curso. 

# cc3002-tarea2
