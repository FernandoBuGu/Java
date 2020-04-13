package randomMutationsSimulator;

import static net.mindview.util.Print.*;
import java.util.*;


import typeinfo.factory.Factory;

class Human{
	
	static Random rand = new Random();
	
	static List<Factory<? extends Human>> Human_factory_list = new ArrayList<Factory<? extends Human>>();
	
	public String toString(){
		return getClass().getSimpleName();
	}
	
	static {
		Human_factory_list.add(new Black.Factory());
		Human_factory_list.add(new Asian.Factory());
		Human_factory_list.add(new AsianMale.Factory());
		
		Human_factory_list.add(new TawianFemale.Factory());
		Human_factory_list.add(new AsianFemale.Factory());
		Human_factory_list.add(new Jewish.Factory());
		Human_factory_list.add(new White.Factory());
		
		Human_factory_list.add(new SouthAmerican.Factory());
		Human_factory_list.add(new BlackFemale.Factory());
		Human_factory_list.add(new BlackMale.Factory());
		Human_factory_list.add(new WhiteFemale.Factory());
	}
	
	public static Human create_random_Human() {
		int idx = rand.nextInt(Human_factory_list.size());
		return Human_factory_list.get(idx).create();
	}
	public static Human[] createArray(int array_list_size) {
		Human[] Human_array = new Human[array_list_size];
		for(int i=0; i<Human_array.length;i++) {
			Human_array[i]=create_random_Human();
		}
		return Human_array;
	}
	public static ArrayList<Human> arrayList(int array_list_size){
		ArrayList<Human> Human_array_list = new ArrayList<Human>(Arrays.asList(createArray(array_list_size)));
		return Human_array_list;
	}
}


//-------------------------------------------------
public class RegisteredFactories {
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			print(Human.create_random_Human());
		}
	}
}
