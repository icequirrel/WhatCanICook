import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestRecipe {

	//test to see if a recipe was created
			@Test
			public void testRecipeConstructor() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				assertEquals(r.getCreationStatus(), true);		
			}
			
			//test to see if the Recipe.getName() method works
			@Test
			public void testGetNameMethod() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				assertEquals(r.getName(), "test recipe");		
			}
			
			//test to see if the Recipe.getDirections() method works
			@Test
			public void testGetDirectionsMethod() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				assertEquals(r.getDirections(), "test directions");		
			}
			
			//test to see if the Recipe.getTime() method works
			@Test
			public void testGetTimeMethod() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				assertEquals(r.getTime(), 10);		
			}
			
			//test to see if the Recipe.getIngredients() method works
			@Test
			public void testGetIngrMethod() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				List<String> testingr = new ArrayList<String>();
				
				testingr.add("water"); 
				testingr.add("flour");
				
				assertEquals(r.getIngr(), testingr);		
			}

			//test to see if the Recipe.setName() method works
			@Test
			public void testSetNameMethod() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				assertEquals(r.getName(), "test recipe");		
				
				name = "new name"; 
				r.setName(name);
				
				assertEquals(r.getName(), "new name");
				
			}
			
			//test to see if the Recipe.setDirections() method works
			@Test
			public void testSetDirectionsMethod() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				assertEquals(r.getDirections(), "test directions");	
				
				directions = "updated directions"; 
				r.setDirections(directions);
				assertEquals(r.getDirections(), "updated directions");	
			}
			
			//test to see if the Recipe.setTime() method works
			@Test
			public void testSetTimeMethod() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				assertEquals(r.getTime(), 10);		
				
				time = 30; 
				r.setTime(time);
				
				assertEquals(r.getTime(), 30);		
			}
			
			//test to see if the Recipe.setIngredients() method works
			@Test
			public void testSetIngrMethod() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				List<String> testingr = new ArrayList<String>();
				
				testingr.add("water"); 
				testingr.add("flour");
				
				assertEquals(r.getIngr(), testingr);	
				
				ArrayList<String> ingrALT = new ArrayList<String>();
				
				ingrALT.add("eggs"); 
				ingrALT.add("milk");
				
				r.setIngr(ingrALT);
				
				List<String> testingrALT = new ArrayList<String>();
				
				testingrALT.add("eggs"); 
				testingrALT.add("milk");
				
				assertEquals(r.getIngr(), testingrALT);
				
			}
			
			//test to see if the Recipe.toString() override method works
			@Test
			public void testToStringMethod() {
				//fail("Not yet implemented");
				String name = "test recipe"; 
				int time = 10; 
				String directions = "test directions"; 
				List<String> ingr = new ArrayList<String>();
				
				ingr.add("water"); 
				ingr.add("flour");
				Recipe r = new Recipe(name, time, directions, ingr); 
				
				assertEquals(r.toString(), "test recipe, cooking time: 10");		
						
			}

}
