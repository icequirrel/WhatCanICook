
public class Recipe {

	//variable to store info on if a recipe was created
	private boolean testRecipeCreation = false; 
	
	//Constructor for my recipe class
	public Recipe() { 
		testRecipeCreation = true;
		
	} 
	
	//added to return the status of if a recipe was created
	public boolean getTestRecipeCreation() { 
		return testRecipeCreation; 
	}
	
}
