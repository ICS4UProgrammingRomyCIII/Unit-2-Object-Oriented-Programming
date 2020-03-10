import java.util.*;
public class StackClassPush<T> {
	public List<T> stackModel = new ArrayList<T>();
	public int numStack;
	
	public List<T> push(T pancake) {
		stackModel.add(pancake);
		return stackModel;
	}
}
