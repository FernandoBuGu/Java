package randomMutationsSimulator;

//Counts instances of a type family.

import java.util.*;
import static net.mindview.util.Print.*;
import net.mindview.util.*;

public class TypeCounter extends LinkedHashMap<Class<?>,Integer>{
	/* countClass(Class<?>): updates value for the key-Class and its superClass(es) through recursive call of the method.
	 * count(Object): if Object-class belongs to class provided in constructor, calls countClass.
	 * toString(): returns printable TypeCounter.
	 */
	public Class<?> baseType;
	TypeCounter(Class<?> baseType){
		this.baseType=baseType;
	}
	
	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if(!baseType.isAssignableFrom(type)) {//if pet Class does not belong to baseType 
			throw new RuntimeException(obj + " incorrect type: "+ type + ", should be type or subtype of "+ baseType);
		}
		countClass(type);
	}
	public void countClass(Class<?> type) {
	    Integer quantity = get(type);
	    put(type, quantity == null ? 1 : quantity + 1);
	    Class<?> superClass = type.getSuperclass();
	    if(superClass != null && baseType.isAssignableFrom(superClass))
	      countClass(superClass);
	}
	
	public String toString() {
		StringBuilder mStringBuilder= new StringBuilder("{");
		for(Map.Entry<Class<?>, Integer> pair:entrySet()) {
			mStringBuilder.append(pair.getKey().getSimpleName());
			mStringBuilder.append("= ");
			mStringBuilder.append(pair.getValue());
			mStringBuilder.append(", ");
		}
		mStringBuilder.delete(mStringBuilder.length()-2, mStringBuilder.length());
		mStringBuilder.append("}");
		return mStringBuilder.toString();
	}
	
	public static void main(String[] args) {

	}
	
}
