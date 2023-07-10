# Batalla_Naval
MiniProyecto Batalla Naval

Practica academica de programacion en Java

**Profesor:**
Carlos Felipe Montoya Rincon

Universidad del Valle - Junio 26 2023


**Alumnos**:

Jose Erley Murillo Torres

Santiago nunez Ramirez

Julian Arley Mosquera Cuesta

Federico Barbetti Ruiz

# Batalla Naval
Batalla Naval es un juego tradicional de estrategia y suerte, que involucra a dos participantes (para este caso un jugador vs el computador). El objetivo del juego es ser el primero en hundir los barcos del oponente.

# Tableros
Cada jugador tiene 2 tableros compuesto por 10 filas y 10 columnas:

Tablero de posición: Representa tu territorio, en él distribuirás tu flota antes de comenzar la partida y sólo será de observación. Verás la posición de tus barcos y los disparos de tu oponente en tu territorio, pero no podrás realizar ningún cambio ni disparo en él.

Tablero principal: Representa el territorio del enemigo, donde tiene desplegada su flota. Será aquí donde se desarrollen los movimientos (disparos) del jugador tratando de hundir los barcos enemigos. Este tablero aparecerá en la pantalla del jugador una vez comience la partida y en él quedarán registrados todos sus movimientos, reflejando tanto los disparos al agua como los barcos tocados y hundidos hasta el momento.

# Flota
Cada jugador tiene una flota de 9 barcos de diferente tamaño, por lo que cada uno ocupará un número determinado de casillas en el tablero:

1 portaaviones: ocupa 4 casillas
2 submarinos: ocupan 3 casillas cada uno.
3 destructores: ocupan 2 casillas cada uno
4 fragatas: ocupan 1 casilla cada uno
Cada barco puede ser ubicado de manera horizontal o vertical en el tablero de posición.

# Terminología y movimientos
Agua: cuando se dispara sobre una casilla donde no está colocado ningún barco enemigo. En el tablero principal del jugador aparecerá una X. Pasa el turno a tu oponente.

Tocado: cuando se dispara en una casilla en la que está ubicado un barco enemigo que ocupa 2 o más casillas y se destruye sólo una parte del barco. En el tablero del jugador aparecerá esa parte del barco con una marca indicativa de que ha sido tocado. El jugador vuelve a disparar.

Hundido: si se dispara en una casilla en la que está ubicado una fragata (1 casilla) u otro barco con el resto de casillas tocadas, se habrá hundido, es decir, se ha eliminado ese barco del juego. Aparecerá en el tablero principal del jugador, el barco completo con la marca indicativa de que ha sido hundido. El jugador puede volver a disparar, siempre y cuando no hayas hundido toda la flota de su enemigo, en cuyo caso habrá ganado.

# Juego del computador
Para este juego, se debe emular el juego del computador (quien será el oponente). Para ello, se podrán aleatoriamente los barcos en el tablero del territorio, siguiendo las reglas y se selecciona al azar cada casilla de tiro.




