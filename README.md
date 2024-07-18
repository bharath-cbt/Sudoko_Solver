# Sudoko_Solver

This project implements a Sudoku solver using a backtracking algorithm in Java. The solver takes a 9x9 Sudoku puzzle as input and outputs the solved puzzle if a solution is found. The solution leverages dynamic dispatch to explore possible numbers for each cell in the grid, ensuring that all Sudoku rules are followed.

Features:-
Sudoku Board Initialization: Initialize the Sudoku board with a given puzzle.
Backtracking Algorithm: Uses a recursive backtracking approach to solve the puzzle.
Safety Check: Ensures that each number placed in the grid follows the Sudoku rules (no duplicate numbers in any row, column, or 3x3 sub-grid).
Solution Display: Prints the solved Sudoku board to the console once a solution is found.

How It Works:-
Input Board: The program starts with a partially filled 9x9 grid.
Backtracking: It recursively tries to fill each empty cell with numbers 1-9, checking the validity of each number placement.
Safety Check: Before placing a number, the Is_Safe method ensures it doesn't violate Sudoku rules.
Solution Output: Once a valid number placement is found for all cells, the solved board is printed.
