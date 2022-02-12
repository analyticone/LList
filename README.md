# Warmup
Edit the LList class.  Implement all of the methods below.  Please make sure that the signatures of all of the methods exactly match the specifications of the assignment.  The signature includes the method name, the return type, and the number of parameters and their types. Indicate at the top of your file the names o the methods that you think do not work.  You must include all of the methods to enable the tester to run.  If you cannot implement a method, just have it return null or false or 0.  Write a tester in a main method in this class to enable you to test all of the methods with whatever data you want in any order. 


### The assignment
Method Signature 	  | Description
|----------------------------------------------------------|---|
+LList()	|	Constructor
+LList(other: LList)	|	Copy Constructor
+LList(other: T[])	|	A constructor that takes an array of items of type T and creates a linked list containing all of the items in other
+add(item:T):void	|	Add to front of list
+addToEnd(item:T):void	|	Add to the end of the list
+removeFromFront():T	|	Delete the node at the front of the list and return the item that was in it or null if the list is empty
+getIndex(item:T):int	|	Get position (index) of an item of type T, return -1 if not there
-getPredecessor(item:T):Node	|	Return the address of the node that comes just before item or null if it is not present (As a private helper method)
+size():int	|	Return the length of the list
+count(item:T):int	|	Return the number of occurrences of a given object of type T in the linked list. 
+delete(item:T):T	|	Delete item from the list and return a reference to that object or null if the deletion did not take place
+insertAt(index:int,item:T):boolean	|	Insert an item at position index, where index is passed to the method. Return true if the insertions took place and false if not (e.g., index out of bounds)
+toArray():T[]	|	Return an array of Ts that contains all of the Ts in the list 
+replace(oldItem:T,newItem:T):boolean	|	Replace the first occurrence of a given T oldItem with another given T newItem. Return true if the value was replaced.
+replaceAll(oldItem:T,newItem:T):boolean	|	Replace all occurrences of a given T oldItem with another given T newItem. Return true if any values were replaced. 
+reverse():LList	|	Return a copy of your linked list but in reverse order
+toString():String	|	toString but in this format [1,2,3] with the commas and brackets in the right place
 
### Setup command
N/A

### Run command
`gradle test`

### Notes
- The JDK is installed on GitHub Actions machines, so you're also able to directly invoke `javac`, `java`, or any other CLI command included in the JDK. 


