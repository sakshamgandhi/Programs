package hash.logic;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {

	public static void main(String[] args) {
		Map<Entity, Integer> map  = new HashMap<>();
		Entity e = new Entity(1,"ritesh");
		Entity e1 = new Entity(2,"ritesh2");
		Entity e2 = new Entity(3,"ritesh3");
		map.put(e,1 );
		map.put(e1,2);
		map.put(e2,3);
		System.out.println(map.get(e) +":"+ e.hashCode());
		System.out.println(map.get(e1) +":"+ e1.hashCode());
		System.out.println(map.get(e2) +":"+ e2.hashCode());
	}

}
