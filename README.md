# Assembly Language
This Java program simulates an assembly language execution. It allows the user to interactively enter commands and perform operations on registers.

## Getting Started
1. Clone the repository or download the source code files.

2. Open the project in your preferred Java development environment.

3. Compile and run the Main.java file to start the program.

## Usage
1. Upon running the program, a menu of commands will be displayed.
2. Available commands:
- MV: Make a new variable
 ```
 For e.g:
 MV REG1,#500
 MV REG2,#200
 ```
- ADD: Add the values of registers
```
For e.g:
ADD REG1,REG2
ADD REG1,100
```
- SHOW: See the result of a register
```
For e.g:
SHOW REG1
SHOW REG2
```
- EXIT or QUIT: Terminate the program
3. Enter the desired command and follow the prompts to perform operations on registers.
4. The current register values are stored in a file named register_values.txt.
5. The program will continue running until the user enters the EXIT or QUIT command.

## File Descriptions
- Main.java: Contains the main method and program flow.
- AssemblyProgram.java: Represents the assembly program logic.
- Instruction.java: Defines an assembly instruction with an operation and operands.
- Operation.java: Enumerates the available operations in the assembly program.
