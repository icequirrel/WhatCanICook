
import java.util.ArrayList;
import java.util.List;

/* 
 * Primary Domain class
 */
public class Recipe {
    private String name;
    private int time;
  //  private int ovenTemp; 
    private List<String> ingr;
    private String directions;
    private boolean created = false; 
    
    //tested
    public Recipe(String name, int time, String directions, List<String> ingr) {
        this.name = name;
        this.time = time;
        this.directions = directions;
        //this.ovenTemp = ovenTemp; 
        this.ingr = ingr;
        this.created = true;
    }
    
    public boolean getCreationStatus() { 
    	return this.created; 
    }
    
    //tested
    public String getName() {
        return this.name;
    }
    
    //tested
    public int getTime() {
        return this.time;
    }
    
    //tested
    public String getDirections() { 
    	return this.directions;
    }
    
 //   public int getOvenTemp() { 
  //  	return this.ovenTemp; 
  //  }
    
    //tested
    public List<String> getIngr() {
        return this.ingr;
    }
    
    //tested
    public void setName(String name) {
        this.name = name;
    }
    
    //tested
    public void setTime(int time) {
        this.time = time;
    }
    
    //tested
    public void setDirections(String directions) { 
    	this.directions = directions;
    }
    
   // public void setTemp(int ovenTemp) { 
   // 	this.ovenTemp = ovenTemp; 
  //  }
    
    //tested
    public void setIngr(ArrayList<String> ingr) {
        this.ingr = ingr;
    }
    
    //tested
    @Override
    public String toString() {
        return this.name + ", cooking time: " + this.time ;
    }
}