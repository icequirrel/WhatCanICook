/*
 * This is my controller class.. it wraps around recipe search to separate out the domain from the UI layers
 */
public class RecipeController {
	
	private RecipeSearch rs; 

	public RecipeController() { 
		this.rs = new RecipeSearch();
	}
	
	public String addNewRecipe(String name, String time, String directions, String ingr) {
		return rs.addNewRecipe(name, time, directions, ingr); 	
	}
	
	public String searchByName(String search) { 
		return rs.searchByName(search);
	}
	
	 public String searchByIngredients(String search) { 
		 return rs.searchByIngredients(search);
	 }
	 
	 public String searchByBoth(String name, String search) { 
		 return rs.searchByBoth(name, search);
	 }
	 
	 public String[] returnAllRecipeNames() { 
		 return rs.returnAllRecipeNames();
	 }
	 
	 public String getRecipeIngredients(String recipeName) { 
		 return rs.getRecipeIngredients(recipeName);
	 }
	 
	 public String getRecipeDirections(String recipeName) { 
		 return rs.getRecipeDirections(recipeName);
	 }
	 
	 public String getCookTime(String recipeName) { 
		 return rs.getCookTime(recipeName);
	 }
}
