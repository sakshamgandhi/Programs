
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

class Entity implements Comparable <Entity> {
    int v;
    String name;
    
    Entity(int v, String name) {
        this.v = v;
        this.name = name;
    }
    
    public int compareTo (Entity e) {
        if (this.v > e.v) return 1;
        else if (this.v < e.v) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Entity{" + "v=" + v + ", name=" + name + '}';
    }

}


public class AllLinked {
    public static void main(String[] args) {
        LinkedList l = new LinkedList ();
        
        //Add at last
        
        l.add("Hello");
        l.add(0,"HOW");
        l.add(1,"What");
        
        //get element
        System.out.println(l.get(0));
        
        //Reverse
        Collections.reverse(l);
        
        //Copy
        LinkedList <String> c = (LinkedList) l.clone();
        
        //Search
        System.out.println(l.contains("Hello"));
        
        //Sublist
        List sub = l.subList(0, 1);
        
        //Order or Sorting
        Collections.sort(c);
        
        LinkedList <Entity> le = new LinkedList <Entity> ();
        le.add(new Entity(1,"Parth"));
        le.add(new Entity(0,"john"));
        Entity e = new Entity(12,"AD");
        Collections.sort(le);
        
        //Swaping of elements via Index
        Collections.swap(le, 0, 1);
        
        //Removing elements
        le.remove(0);
        le.remove(e);
        
        //Replacing a element
        l.set(0, "WOW");
        
        //Size
        System.out.println (l.size());
        
        for(Entity o : le) {
            System.out.println(o);
        }
        
    }
}
