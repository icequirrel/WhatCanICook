import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.ComboBoxModel;

/*
 * This is effectively the service class
 */
public class RecipeSearch {
       
	
	
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    
    
	//private ArrayList<String> recipes = new ArrayList<>(); // ALL recipes in recipe.txt
	private ArrayList<String> recipes2 = new ArrayList<>();
    private ArrayList<Recipe> recipesO = new ArrayList<>(); // recipes splitted & grouped in objects
   // ArrayList<Recipe> recipesO2 = new ArrayList<>();
   // private ArrayList<Integer> indices = new ArrayList<>(); // cooking times in all recipes list 
    private ArrayList<Integer> indices2 = new ArrayList<>(); // trying to store all indices
    private String fileWriterText = new String(); //String to store what gets written to the text file
    private boolean recipeSearchCreated = false; 
    private int nextIndexCount = 1; 
    
    private List<String> ingr; // ingredients separated by recipe
    
    //tested
    public RecipeSearch() { 
    	
    	recipeSearchCreated = true;
    	 // create recipes - all lines together
    	
    	/*
        try (Scanner scanner = new Scanner(Paths.get("recipes.txt"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (row.isEmpty()) {
                    continue;
                }
                recipes.add(row);
            }
            
        }
        catch (Exception e) {
            System.out.println("An error occured..");
        }
        */
        
        /*
         * May DELETE THIS
         * 
         */
        try (Scanner scanner2 = new Scanner(Paths.get("recipes2.txt"))) {
            while (scanner2.hasNextLine()) {
                String row = scanner2.nextLine();
                if (row.isEmpty()) {
                    continue;
                }
                recipes2.add(row);
            }
            
        }
        catch (Exception e) {
            System.out.println("An error occured..");
        }
        
        /*
        // find cooking times (integers) in file
        for (String r: recipes) {
            if (isInteger(r)) {
                indices.add(recipes.indexOf(r));
            }
            
            
        }
        */
                
        for(int index = 0; index < recipes2.size(); index++) { 
        	String r2 = recipes2.get(index);
        	if(r2.contains("~@~RECIPEENTRY_")){ 
        		String r2Temp = r2.substring(15);
        		//System.out.println(r2 + " :" + r2Temp);
        		if(isInteger(r2Temp)) { 
        			//System.out.println(index);
        			indices2.add(index);
        			nextIndexCount++;
        		}
        	}
        }
        
       
        
        /*
        // split and group recipes
        for (int i = 0; i < indices.size() - 1; i++) {
           
            int time = Integer.valueOf(recipes.get(indices.get(i)));
            String name = recipes.get(indices.get(i) - 2);
            String directions = recipes.get(indices.get(i) - 1);
        
            recipesO.add(new Recipe(name, time, directions, recipes.subList(indices.get(i) + 1, indices.get(i + 1) - 2)));
        }
        
        int j = indices.size() - 1;
        
        int time = Integer.valueOf(recipes.get(indices.get(j)));
        String name = recipes.get(indices.get(j) - 2);
        String directions = recipes.get(indices.get(j) - 1);
        
        recipesO.add(new Recipe(name, time, directions, recipes.subList(indices.get(j) + 1, recipes.size())));
        */
        
        /*
         * May DELETE
         */
     // split and group recipes
        for (int i = 0; i < indices2.size() - 1; i++) {
           
            int time2 = Integer.valueOf(recipes2.get(indices2.get(i)+3));
            String name2 = recipes2.get(indices2.get(i) +1);
            String directions2 = recipes2.get(indices2.get(i) +2);
        
            recipesO.add(new Recipe(name2, time2, directions2, recipes2.subList(indices2.get(i) + 4, indices2.get(i + 1))));
        }
        
        int j2 = indices2.size() - 1;
        
        int time2 = Integer.valueOf(recipes2.get(indices2.get(j2)+3));
        String name2 = recipes2.get(indices2.get(j2) +1);
        String directions2 = recipes2.get(indices2.get(j2) +2);
        
        recipesO.add(new Recipe(name2, time2, directions2, recipes2.subList(indices2.get(j2) + 4, recipes2.size())));
        
       
    }
    
    // included in test
    public boolean getRecipeSearchCreated() { 
    	return this.recipeSearchCreated;
    }
    
    
    //tested all paths but* recipe creation because writing to the file will only work once before it says "Name Already In Use!" 
    public String addNewRecipe(String name, String time, String directions, String ingr) { 
    	
    	String notification = new String(); 
    	
    	
    	if(name.equals("") || time.equals("") || directions.equals("") || ingr.equals("")) { 
    		notification = "Incomplete Recipe";
    	}
    	else if(isInteger((time))){ 
    		
    		int cookTime = Integer.parseInt(time);
    		String arrayIngr [] = ingr.split("\n"); 
    		List<String> ingrList = new ArrayList<String>();
    		ingrList = Arrays.asList(arrayIngr);
    		
    		String processedDirections = directions.replaceAll("\n", "@@@@@");
    		
    		
    		for(Recipe r: recipesO) { 
    			if(name.equals(r.getName())) { 
    				notification = "Name Already In Use!";	
    				
    			}
    			
    		}
    		if(notification.contentEquals("Name Already In Use!" )) { 
    			
    		}
    		else { 
    			recipesO.add(new Recipe(name, cookTime, processedDirections, ingrList)); 
            	fileWriterText = "~@~RECIPEENTRY_"+ nextIndexCount + "\n" + name + "\n" + processedDirections + "\n" + time;
            	for (String s: ingrList) { 
            		fileWriterText += "\n" + s; 
            	}
            	notification = this.writeToRecipeFile();
    		}
    		
    		
    		
    	}
    	else { 
    		notification = "Invalid Cook Time";
    	}
    	
    	return notification; 
    	
    }
    

    //not tested because test would fail after 1st write to file
	private String writeToRecipeFile() { 
    	try(FileWriter fw = new FileWriter("Recipes2.txt", true);
    		    BufferedWriter bw = new BufferedWriter(fw);
    		    PrintWriter out = new PrintWriter(bw))
    		{
    		    out.println(fileWriterText);
    		    nextIndexCount++;
    		    return "Recipe Created Successfully";
    		    
    		    //more code
    		    
    		} catch (IOException e) {
    		    
    			return "Recipe not Created";
    		}
    }
    
	//tested
    public String searchByName(String search) {
    	String searchResults = "Matching Recipes: \n\n";
        for (Recipe r: recipesO) {
            if (r.getName().contains(search)) {
                searchResults += r.getName() + "\n   Total Time to Make: " + r.getTime() +  "\n\n";
            }
        }
        searchResults += "\nEnd of List";

        return searchResults;
         
    	
    }
    
    //tested
    public String searchByIngredients(String search) {
    	String searchResults = "Matching Recipes: \n\n";
        ArrayList<Recipe> temp = recipesO;

        String ingredient[] = search.split("\\r?\\n");
        
        for (String s: ingredient) { 
        	ArrayList<Recipe> partialTemp = new ArrayList<Recipe>();
        	for (Recipe t: temp) { 
        		if(t.getIngr().contains(s)) { 
        			partialTemp.add(t);
        		}
        	}
        	temp = partialTemp;        
        }	
        	
        for (Recipe r: temp) {
        	searchResults += r.getName() + "\n   Total Time to Make: " + r.getTime() + "\n\n";
        }

        searchResults += "\nEnd of List";

        return searchResults; 	
    }
    
    //tested
    public String searchByBoth(String name, String search) {
    	String searchResults = "Matching Recipes: \n\n";
        ArrayList<Recipe> temp = recipesO;

        String ingredient[] = search.split("\\r?\\n");
        
        for (String s: ingredient) { 
        	ArrayList<Recipe> partialTemp = new ArrayList<Recipe>();
        	for (Recipe t: temp) { 
        		if(t.getIngr().contains(s)) { 
        			partialTemp.add(t);
        		}
        	}
        	temp = partialTemp;        
        }	
        	
        for (Recipe r: temp) {
        	if (r.getName().contains(name)) {
                searchResults += r.getName() + "\n   Total Time to Make: " + r.getTime() +  "\n\n";
            }
        }

        searchResults += "\nEnd of List";

        return searchResults; 	
    }
    
    //not tested because it will fail as the application is used and new recipes are stored. 
	public String[] returnAllRecipeNames() { 
    	//ArrayList<String> recipeNames = new ArrayList<String>(); 
		String[] recipeNames = new String[recipesO.size()+1];
		recipeNames[0] = "--Select a Recipe--";
    	int index = 1;    
		
    	for(Recipe r: recipesO) { 
    		recipeNames[index] = r.getName();
    		index++;
    	}
    	
    	return recipeNames;
    }
	
	//tested
	public String getRecipeIngredients(String recipeName) { 
		String recipeIngredients = new String();
		for(Recipe r: recipesO) { 
			if(r.getName().equals(recipeName)) { 
				//System.out.println("MyRecipeRecognized: " + recipeName);
				for(String s: r.getIngr()) { 
				//	System.out.println("MyIngredients: " + s);
					recipeIngredients += s + "\n"; 
				}
			//System.out.println("test out of if");
			break;
			}
			
		}
		
		return recipeIngredients; 
	}
	
	//tested
	public String getRecipeDirections(String recipeName) { 
		String recipeDirections = new String(); 
		for(Recipe r: recipesO) { 
			if(r.getName().equals(recipeName)) { 
				recipeDirections = r.getDirections().replaceAll("@@@@@", "\n");
			break;
			}
		}
		return recipeDirections;
	}
	
	//tested
	public String getCookTime(String recipeName) { 
		int cookTime = 0; 
		for(Recipe r: recipesO) { 
			if(r.getName().equals(recipeName)) { 
				cookTime = r.getTime();
			break;
			}
		}
		return "" + cookTime;
	}
}