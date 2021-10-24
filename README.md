Introduction:
After reading the prompt, we discussed our previous coding experience and which coding language are we most comfortable in using. We decided on choosing Java as the main programming language for the project as we all were proficient in that language. We created a shared project on Github, where we could share and grab codes made by each other easily. Eventually merging all our codes to provide the final product.

Scope of Work:
During our brainstorming period, we discussed who is more comfortable on working with frontend, and who is more comfortable with backend. After learning more about our strengths, we have decided to split the work between us as follows:
•	UI: Ahmad Sabry
•	Backend (Server): Youssef El Khashab, Youssef Mahmoud
•	Reporting: Youssef Mahmoud


Methodology:
Backend:
•	For backend, we created a main Game class that contains the difficulty, width, height, and stones parameters. Also, it initializes a 2D matrix to store the cells data on. This class also contains functions as follows:
1.	check(): A recursive method that checks the chosen cell and calls for the adjacentStones() method.
2.	adjacentStones(): checks the cells that are adjacent to the chosen cell for stones and returns a number for their adjacent stones.
3.	placeStones(): randomly chooses indexes of cells to place the stones on.
4.	restart(): a button that will be provided in the game that restarts the game.

Frontend (UI):
•	Contains the main method which prompts the user to choose between the three sizes of grids that could be implemented.
<img width="417" alt="image" src="https://user-images.githubusercontent.com/88597501/138615160-6fa89799-0fbb-4fee-b3b5-9b04fd4b5936.png">

•	We had to create a Difficulty class that sets the parameters of the game based on the user’s choice of difficulty. This class also contains parameters for the width, height, and stones, where they will be set dynamically in its constructor. 
•	Created an interface where we split the pixels on the screen into clickable buttons. When clicked, the button dims, shows the stone, or shows a number for the number of adjacent stones.
<img width="1028" alt="image" src="https://user-images.githubusercontent.com/88597501/138615179-cd12edf0-0378-46e4-bae4-41694875798d.png">

