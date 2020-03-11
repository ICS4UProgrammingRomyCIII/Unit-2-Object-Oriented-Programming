import java.util.ArrayList;
import java.util.List;

// This Stack push class will accept a generic object.
// This allows a stack to be created with any type of object (int, String, Double, etc.)
public class StackClass<T> {
	public List<T> stackModel = new ArrayList<T>(); // A Generic list for the stack.
	
	// A Function that accepts a generic object and returns a generic list.
	public List<T> push(T pancake) { // When the function is called...
		stackModel.add(pancake);	 // Add the generic object to the end of the stack.
		return stackModel;			 // Return the list with the new object.
	}
	
	// A Function has no arguments and returns a generic list.
	public List<T> pop(){						 // When the function is called...
		stackModel.remove(stackModel.size() -1); // Remove the last object in the stack.
		return stackModel;						 // Return the list without the last object.
	}
	
	// A Function has no arguments and returns a generic.
	public String peek(){
		String out = stackModel.get(stackModel.size() - 1).toString(); // Gets the object at the top of the stack.
		return out;													 // Returns the peeked value
	}
	
	// A Function has no arguments and returns a generic list.
	public List<T> clear(){
		stackModel.removeAll(stackModel); // Removes all objects in the stack.
		return stackModel;				  // Returns the cleared stack.
	}
}