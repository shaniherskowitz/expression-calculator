Shani Herskowitz 321658387

The simplifications i did are as follows:

	• (x^y)^z => x^(y*z)

in order to accomplish this in simplify in the pow class i made an if statement checking if num one was of type “pow”, if it was i return a new pow with num one as the first parameter and num two * num one.two

	• ((5x) + (2x)) => 7*x

 I went to the plus class and checked if both parameters were of type “mult”, if they where i needed to check if they had any variables in common. I did this using 4 if statements.I made sure that if they had something in common it was a variable and not a number.
if they had something in common i returned a plus of the expressions that they did not have in common multiplied by the expression that they did have in common.

	• ((5x) - (2x)) => 3*x

Simlier to the simplification above but in the minus class. if i found that both expressions had the same variable i returned a minus of the expressions that they did not have in common multiplied by the expression that they did have in common.

	• ((x * 4.0) + 5.0 + (6.0 * x) + y) 
      => ((10.0 * x) + (y + 5.0))

	• ((x * 2.0) + (x * 4.0) + (6.0 * x) + (x * 1.0))
 	   => (13.0 * x)

	• ((x * 2.0) + 5.0 + (6.0 * x) + (6.0 * x))
	   => ((14.0 * x) + 5.0)

In order to do this simplification i had to create 
another class and another abstract class to support it.
this class can handle four different expressions 
connected by plus signs. That way i can go through
a complex expression and find the expressions it
has in common in order to simplify
it.

This class performs just like the 
Plus class but connects four different expressions.

In simplify i needed to check for any combinations
of the four expressions that they could have in 
common. I created an array of 0s, and went over each
pair to check if they were of type “mult” and held
the same variables. if they did i changed the number 
in the array to one. Then using the array i went over
all possible combinations within the pairs to match
the common expressions. 
once i found the 
common code i sent a new plus of the 
expression they did not have in common with the 
expressions multiplied by the common expression.
i made sure the return was right for all combinations.

This gave me the ability to combine any 
common expressions within the four expressions.

	• ((x * 7.0) + 5.0 + (x * 7.0))
      => ((14.0 * x) + 5.0)

	•  (((x^7.0) * (x^6.0)) + 5.0) 
      => ((x^13.0) + 5.0)

Very similar to what i did above but using three 
expressions instead of four so there were fewer 
options to check in terms of finding common
expressions. other then that was done the same way.
using a new class and new abstract class.
this allows me to find common code with
expression that hold three expressions inside them.

	•  ((x^9.0) * (x^7.0))
      => (x^16.0)

In the mult class i check if the first and second 
expression are of type “pow” using instance of.
if they are i check if the base of the pow is
the same if it is i create a new pow using
the expression they have in common, and multiplying 
the second numbers
  