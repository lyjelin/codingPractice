
import java.util.*;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
        
        // Scores in descending order
        // Names by alphabetically 
        if (a.score > b.score) return -1;
        else if (a.score < b.score) return 1;
        else return (a.name).compareTo(b.name);
        
        
    
    }
}

