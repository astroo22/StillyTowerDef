# StillyTowerDef
This project is a simple android tower defense game. 
We hope to have the most basic of sprite animations with help from an art student. 
updates are relatively slow at the moment due to course loads
We use a ! to distinguish features that are time dependent. 
Currently this game is still in its very early stages as we are working to create alot of the back end logic and game structure. 

We only update files after a feature or idea has been created to at least a basic working state. 

Features we plan to include:
* !Endless waves that are generated by the game until the user dies. (We hope to include at least 3 levels as a start) 
* Enemies that make pathing decisions based on the current state/location of walls.
* The ability for users to create structures: Walls, towers, !traps.
* !The ability to upgrade structures.  
* Leaderboard that updates scores from anybody who plays. 
* Account based system that will allow you to pull your current game to a different device. 
* At least 3 types of enemies to start. (Tank (slow but hits hard and high health), Zombie (medium stats all around), "Name debated atm"(Fast speed, low health)
* Game will have a basic menue.

Current list of things in game:
 * Basic infastructure. 
 * Squares that represent by color our 3 types of enemies. Green - zombie, red - tank, blue - "fast thing"
 * Spawn system (system is not completely random about spawn location yet and spawns in a diagonal line on startup on todo list)
 * Basic movement for 3 enemies. 
 * Wall spawning(This is very basic and is currently the priority)

Currently working on:
 * Enemy wall interaction and walking logic based on walls. 
 * Threading the spawning algorithm to allow for spawing of enemies with delays after each spawn and a more randomized spawn system.
 * Enemy logic for wall interactions: Where they walk, position to stop at, and whether to attack them or not.
 * Front end start up menue and creating a new game.(this one will be done after we condence game functionality into a single NewGame call)

