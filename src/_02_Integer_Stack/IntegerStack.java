package _02_Integer_Stack;

public class IntegerStack {
	//1. create a private array of integers
	private int[] intArray;
	//2. complete the constructor by initializing the member array
	//   to a new array of length 0. This prevents null pointer exceptions.
	public IntegerStack() {
		intArray = new int[0];
	}
	
	//3. Complete the steps in the push method.
	public void push(int v) {
		//A. create a new array that is one element larger than the member array
		int[] newArray = new int[intArray.length+1];
		//B. set the last element of the new array equal to the integer passed into the method
		newArray[intArray.length] = v;
		//C. iterate through the member array and copy all the elements into the new array
		for (int i = 0; i < intArray.length; i++) {
			newArray[i] = intArray[i];
		}
		//D. set the member array equal to the new array.
		intArray = newArray;
	}
	
	//4. Complete the steps in the pop method.
	public int pop() {
		//A. create an integer variable and initialize it to the
		//   last element of the member array.
		int number = intArray[intArray.length-1];
		//B. create a new array that is one element smaller than the member array
		int[] newArray = new int[intArray.length-1];
		//C. iterate through the new array and copy every element from the
		//   member array to the new array
		for (int i = 0; i < newArray.length; i++) {
			newArray[i]= intArray[i];
		}
		//D. set the member array equal to the new array
		intArray = newArray;
		//E. return the variable you created in step A
		return number;
	}
	
	//5. Complete the clear method to set the
	//   member array to a new array of length 0
	public void clear() {
		int[] newArray = new int[0];
		intArray = newArray;
	}
	
	//6. Complete the size array to return 
	//   the length of the member array
	public int size() {
		int size = 0;
		size = intArray.length;
		return size;
	}
}
