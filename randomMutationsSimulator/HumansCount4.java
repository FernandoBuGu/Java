package randomMutationsSimulator;

import static net.mindview.util.Print.print;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import net.mindview.util.MapData;



public class HumansCount4 {
	
	public static void main(String[] args) {
		try {
			Class<?> mclass = Class.forName("randomMutationsSimulator.Human");
			TypeCounter m_HumanCounter = new TypeCounter(mclass);
			//m_HumanCounter has .count method, that counts number of objects from each class
			//All classes considered belong to mclass and are fit into HumanCreator via LiteralHumanCreator using Humans wrapper
			ArrayList<Human> Human_array = Human.arrayList(500);//types (Class-list) used by HumanCreator will come from LiteralHumanCreator
			for(Human Human:Human_array) {
				m_HumanCounter.count(Human);
			}
			print(m_HumanCounter);//Some Cats popup, as Mutt-objects, for instance are created (and mutt belongs to dog)
		} catch (ClassNotFoundException cnf){
			print("class was not found");
			throw new RuntimeException();
		}
	}
}
