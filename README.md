# OOP-Battleship-Project
Lewis University SP21-CPSC-24500-003 Final Project

Team Members: 

Joshua Belfor

Kim Johnson

Muhammad Ashfaq

Aaron Skonieczny

# What game are you going to build?
Battleship
What rules will you implement?
We will be implementing all of the rules that are established in How to Play:
•	One player game -vs- AI
•	Two Grids
•	Each ship occupies a certain number of adjacent squares on the grid, horizontally or vertically. The ships cannot overlap.
•	Player 1 and AI alternate strikes.
•	Hits and Misses are recorded on players’ boards after each shot
o	“X” for a hit.
o	“O” for a miss.

# How to Play
The Battleship game board instructs 1 carrier (5 squares), 1 battleship (4 squares), 1 destroyer (3 squares), 1 submarine (3 squares) and 1 cruiser (2 squares).
Battleship game goal
Sink all the opponent’s ships by taking turns at guessing the locations of the other player’s ships on a grid.

# Set up
Each player takes two grids. On one grid, the player arranges ships and records the strikes taken by the opponent. On the other grid the player records their own strikes against their opponent’s ships.

# Each player’s fleet consists of the following ships:
•	1 x Carrier – 5 squares
•	1 x Battleship – 4 squares
•	1 x Cruiser – 3 squares
•	1 x Destroyer – 3 squares
•	1 x Submarine – 2 squares
Each ship occupies a certain number of adjacent squares on the grid, horizontally or vertically.

# Gaming
During the game, the players take turns in taking a shot at the opponent by calling out the coordinates of a square (example: H4). If it hits a ship, the game responds with “hit”, and the corresponding square is marked with an X. If it’s a miss, the corresponding square is marked with an O. When every square of a ship is hit, that ship is considered “sunk”. Player and AI alternate turns until gameplay ends. Gameplay ends when all ships are sunk. The player who sinks all of opponent’s ships is the winner. 

# Summary of the Final Product and Design: 
We are going to implement a command line Battleship game that will be turn based. There will be simple AI that the player will play against. The ships will be placed randomly on the board. Player 1 chooses a place on the board to “strike” the other team. If the strike is a “hit” then that square on the board will become an X; the square will be an O if it is a miss. Hits and misses will be recorded on the corresponding board after each turn. Once all squares of a ship are hit, that ship is sunk. Alternating turns will continue until one player has sunk all of the opponent’s ships. 


