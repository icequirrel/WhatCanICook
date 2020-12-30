import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestRecipeSearch {

	//test to see if a recipesearch object was created
	@Test
	public void testRecipeSearchConstructor() {
		//fail("Not yet implemented");
		RecipeSearch rs = new RecipeSearch(); 		
		assertEquals(rs.getRecipeSearchCreated(), true);		
	}
	
	//test to see if the searchByName method works
	@Test
	public void testSearchByName() {
		//fail("Not yet implemented");
		RecipeSearch rs = new RecipeSearch(); 	
		String test = rs.searchByName("Tea with Honey"); 
		String resultVerification = "Matching Recipes: \n\n";
		resultVerification += "Tea with Honey" + "\n   Total Time to Make: " + 35 +  "\n\n";
		resultVerification += "\nEnd of List";
		
		assertEquals(test, resultVerification);		
	}
	
	//test to see if the searchByIngredients method works for searches with individual ingredients
	@Test
	public void testSearchByIngredientsSingle() {
		//fail("Not yet implemented");
		RecipeSearch rs = new RecipeSearch(); 	
		String test = rs.searchByIngredients("tea bag"); 
		String resultVerification = "Matching Recipes: \n\n";
		resultVerification += "Tea with Honey" + "\n   Total Time to Make: " + 35 +  "\n\n";
		resultVerification += "\nEnd of List";
			
		assertEquals(test, resultVerification);		
	}
	
	//test to see if the searchByIngredients method works for searches with multiple ingredients
	@Test
	public void testSearchByIngredientsMultiple() {
		//fail("Not yet implemented");
		RecipeSearch rs = new RecipeSearch(); 	
		String test = rs.searchByIngredients("tea bag\nhoney"); 
		String resultVerification = "Matching Recipes: \n\n";
		resultVerification += "Tea with Honey" + "\n   Total Time to Make: " + 35 +  "\n\n";
		resultVerification += "\nEnd of List";
				
		assertEquals(test, resultVerification);		
	}
	
	//test to see if the searchByBoth method works as intended
	@Test
	public void testSearchByBoth() {
		//fail("Not yet implemented");
		RecipeSearch rs = new RecipeSearch(); 	
		String test = rs.searchByBoth("Tea with Honey", "tea bag\nhoney"); 
		String resultVerification = "Matching Recipes: \n\n";
		resultVerification += "Tea with Honey" + "\n   Total Time to Make: " + 35 +  "\n\n";
		resultVerification += "\nEnd of List";
				
		assertEquals(test, resultVerification);		
	}
	
	//test to see if the getRecipeIngredients() method works
	@Test
	public void testGetRecipeIngredients() { 
		RecipeSearch rs = new RecipeSearch(); 
		String recipeName= "TESTRECIPE";
		String test = rs.getRecipeIngredients(recipeName); 
		//System.out.println(test);
		String resultVerification = "ingredient1\ningredient2\n";
		//System.out.println(resultVerification);
		assertEquals(resultVerification,test);
	}
	
	//test to see if the getRecipeIngredients() method works
	@Test
	public void testGetRecipeDirections() { 
		RecipeSearch rs = new RecipeSearch(); 
		String recipeName= "TESTRECIPE";
		String test = rs.getRecipeDirections(recipeName); 
		//System.out.println(test);
		String resultVerification = "Some Directions Here";
		//System.out.println(resultVerification);
		assertEquals(resultVerification,test);
		}
	
	//test to see if the getCookTime() method works
	@Test
	public void testGetCookTime() { 
		RecipeSearch rs = new RecipeSearch(); 
		String recipeName= "TESTRECIPE";
		String test = rs.getCookTime(recipeName); 
		//System.out.println(test);
		String resultVerification = "3";
		//System.out.println(resultVerification);
		assertEquals(resultVerification,test);
		}

	//test to see if a the AddNewRecipe() method displays an "Incomplete Recipe" message if the cook time parameter isn't filled in
	@Test
	public void testAddNewRecipeMissingCookTime() { 
		RecipeSearch rs = new RecipeSearch(); 
		String test = rs.addNewRecipe("MyRecipe", "", "Just Wing it", "pizza"); 
		String resultVerification = "Incomplete Recipe";
		
		assertEquals(test, resultVerification);
	
	}
	
	//test to see if a the AddNewRecipe() method displays an "Incomplete Recipe" message if the Name parameter isn't filled in
	@Test
	public void testAddNewRecipeMissingName() { 
		RecipeSearch rs = new RecipeSearch(); 
		String test = rs.addNewRecipe("", "13", "Just Wing it", "pizza"); 
		String resultVerification = "Incomplete Recipe";
		
		assertEquals(test, resultVerification);
	
	}
	
	//test to see if a the AddNewRecipe() method displays an "Incomplete Recipe" message if the Ingredients parameter isn't filled in
	@Test
	public void testAddNewRecipeMissingIngredients() { 
		RecipeSearch rs = new RecipeSearch(); 
		String test = rs.addNewRecipe("MyRecipe", "13", "Just Wing it", ""); 
		String resultVerification = "Incomplete Recipe";
		
		assertEquals(test, resultVerification);
	
	}
	
	//test to see if a the AddNewRecipe() method displays an "Incomplete Recipe" message if the Directions parameter isn't filled in
	@Test
	public void testAddNewRecipeMissingDirections() { 
		RecipeSearch rs = new RecipeSearch(); 
		String test = rs.addNewRecipe("MyRecipe", "13", "", "pizza"); 
		String resultVerification = "Incomplete Recipe";
		
		assertEquals(test, resultVerification);
	
	}
	
	//test to see if a the AddNewRecipe() method displays an "Name Already In Use!" message if the recipe name is a duplicate
	@Test
	public void testAddNewRecipeSameName() { 
		RecipeSearch rs = new RecipeSearch(); 
		String test = rs.addNewRecipe("Tea with Honey", "13", "Just Wing it", "pizza"); 
		String resultVerification = "Name Already In Use!";
		
		assertEquals(test, resultVerification);
	
	}
	
	//test to see if a the AddNewRecipe() method displays an "Invalid Cook Time" message if the recipe cook time isn't an integer
	@Test
	public void testAddNewRecipeInvalidCookTime() { 
		RecipeSearch rs = new RecipeSearch(); 
		String test = rs.addNewRecipe("Tea with Honey", "a13", "Just Wing it", "pizza"); 
		String resultVerification = "Invalid Cook Time";
			
		assertEquals(test, resultVerification);
		
	}
	


}
