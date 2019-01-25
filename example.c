#include <iostream>
#include <stdio.h>

int main(){
	int a = 0;
	a = 3;
	int b = a + 2;
	printf("Value of b: %d", b);
	return 0;
}



/*
TRANSLATED PYTHON CODE FOR THIS SHOULD BE THE FOLLOWING:
if __name__ == "__main__":
	a = 0
	a = 3
	b = a + 2
	print("Value of b:",b)
*/

/* Algorithm for translating C-style printf statements to Python-style print statements
-------------------------------------------------------------------------------------
(1) print out "print(
(2) Skip to the left parenthesis, read the printf statement and look for the following:
	(i)	Any percentage signs
	(ii) Any \n or \t characters. By default, python includes a \n while C does not in print statements.
	Keep this is mind.
(3) If the c-style printf statements contains ONLY a percentage sign along followed by a character (or this repeated sereral times),
Then we will want to find out what variables are being printed out and simply print them out in the python code.

*/