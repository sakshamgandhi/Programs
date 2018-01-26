
//Hackkerrank Question

import java.util.*;
import java.util.PriorityQueue;
import java.util.Collections;

    public class City implements Comparable {
	int pop;
	int count;
	int avg;

	public City (int pop) {
	    this.pop = pop;
	    this.count = 1;
	    this.avg = pop;
	}

	public void addClinic () {
	    count += 1;
	    avg = pop / count;
	    if (pop % count != 0) avg += 1;
	}


	public int compareTo (Object o) {
	    City c = (City) o;
	    if (this.avg > c.avg) return 1;
	    else if (this.avg < c.avg) return -1;
	    else return 0;
	}

	public static void main (String[] args) {
	    PriorityQueue <City> pq = new PriorityQueue <> (11, Collections.reverseOrder ());
        Scanner sc = new Scanner (System.in);
        int N = sc.nextInt ();
        int clinic = sc.nextInt ();
        clinic = clinic - N;
        for (int i = 0; i< N; i += 1) {
	       pq.add (new City (sc.nextInt ()));
        }
	    while (clinic > 0) {
		City tmp = pq.poll ();
		tmp.addClinic ();
		pq.add (tmp);
		clinic -= 1;
	    }
	    System.out.println ((pq. poll ()).avg);
	}

    }
