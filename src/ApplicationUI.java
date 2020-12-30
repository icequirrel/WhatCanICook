import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ApplicationUI {
	private JFrame frmRecipeMgmt;
	private JPanel containerPanel;
	private CardLayout cardLayout;
	private JPanel mainMenuPanel;
	private JPanel recipeMgmtPanel;
	private JPanel recipeDetailsPanel;

	
	
	private JTextArea txtrRecipeSearchResults;
	private JTextArea txtrRecipeSearchResults2;
	private JTextArea txtrRecipeSearchResults3;
	
	//private JTextField recipeTotalCookTimeField;
	
	private RecipeController rc = new RecipeController(); 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationUI window = new ApplicationUI();
					window.frmRecipeMgmt.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Builds out the application UI
	 */
	
	public ApplicationUI() { 
		cardLayout = new CardLayout();

		//Set up the Frame
		frmRecipeMgmt = new JFrame();
		frmRecipeMgmt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecipeMgmt.setResizable(false);
		frmRecipeMgmt.setSize(new Dimension(727, 420));
		frmRecipeMgmt.setTitle("Recipe Manager");
		frmRecipeMgmt.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//Set up the container panel
		containerPanel = new JPanel();
		frmRecipeMgmt.getContentPane().add(containerPanel);
		containerPanel.setLayout(cardLayout);
		
		//Set up the sub panels
		mainMenuPanel = new JPanel();
		containerPanel.add(mainMenuPanel, "mainMenuScreen");
		mainMenuPanel.setLayout(null);
		
		recipeDetailsPanel = new JPanel();
		containerPanel.add(recipeDetailsPanel, "recipeDetailsScreen");
		recipeDetailsPanel.setLayout(null);
		
		recipeMgmtPanel = new JPanel();
		containerPanel.add(recipeMgmtPanel, "recipeMgmtScreen");
		recipeMgmtPanel.setLayout(null);
		
		
		/*
		 * 
		 * 
		 * 
		 * This code sets up the UI of the RecipeSearch/MainMenu sub-panel		
		 * This is the panel that allows you to input ingredients or a recipe name to find matching recipes 
		 * 
		 * 
		 * 
		 */
		
				
		JLabel lblNavigation = new JLabel("Navigation: ");
		lblNavigation.setBounds(255, 280, 111, 15);
		mainMenuPanel.add(lblNavigation);
		//Navigation button to get to the Recipe Search panel
		
		//Navigation button to get to the Recipe Management panel
		JButton btnRecipeMgmt = new JButton("Go To Recipe Details");
		btnRecipeMgmt.setBounds(255, 315, 200, 25);
		btnRecipeMgmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						//register.finalizeSale();
				rc.returnAllRecipeNames();
				cardLayout.show(containerPanel, "recipeDetailsScreen");
						
			}
		});
		mainMenuPanel.add(btnRecipeMgmt);
		
		JButton btnSearchRecipes = new JButton("Go To Recipe Addition");
		btnSearchRecipes.setBounds(255, 345, 200, 25);
		btnSearchRecipes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//register.finalizeSale();
				cardLayout.show(containerPanel, "recipeMgmtScreen");
				
			}
		});
		mainMenuPanel.add(btnSearchRecipes);
		
		JLabel lblRecipeSearch = new JLabel("Recipe Search");
		lblRecipeSearch.setBounds(305, 12, 111, 15);
		mainMenuPanel.add(lblRecipeSearch);
		
		JLabel lblRecipeName = new JLabel("Recipe Name: ");
		lblRecipeName.setBounds(30, 50, 111, 15);
		mainMenuPanel.add(lblRecipeName);
		
		JTextField recipeNameField = new JTextField();
		recipeNameField.setBounds(30, 70, 200, 25);
		mainMenuPanel.add(recipeNameField);
		recipeNameField.setColumns(10);
		
		
		//This is the search section in the middle
		JLabel lblSearchSection = new JLabel("Search Recipe(s): ");
		lblSearchSection.setBounds(255, 105, 200, 15);
		mainMenuPanel.add(lblSearchSection);
		
		
		
		JButton btnSearchRecipeByName = new JButton("Search by Name");
		btnSearchRecipeByName.setBounds(255, 140, 200, 25);
		btnSearchRecipeByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtrRecipeSearchResults.setText(rc.searchByName(recipeNameField.getText()));
				//cardLayout.show(containerPanel, "searchRecipeScreen");
				
				
			}
		});
		mainMenuPanel.add(btnSearchRecipeByName);
		
		
		
		JLabel lblRecipeIngredients = new JLabel("Recipe Ingredient(s): ");
		lblRecipeIngredients.setBounds(30, 105, 200, 15);
		mainMenuPanel.add(lblRecipeIngredients);
		
		JLabel lblRecipeIngredientsNotice = new JLabel("(1 ingredient per line - lowercase)");
		lblRecipeIngredientsNotice.setBounds(30, 120, 200, 15);
		mainMenuPanel.add(lblRecipeIngredientsNotice);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(30, 140, 200, 230);
		mainMenuPanel.add(scrollPane2);
		
		JTextArea ingredientsInSearch = new JTextArea();
		ingredientsInSearch.setEditable(true);
		scrollPane2.setViewportView(ingredientsInSearch);
		
		JButton btnSearchRecipeByIngredients = new JButton("Search by Ingredient(s)");
		btnSearchRecipeByIngredients.setBounds(255, 170, 200, 25);
		btnSearchRecipeByIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				txtrRecipeSearchResults.setText(rc.searchByIngredients(ingredientsInSearch.getText()));
				//String ingredient[] = ingredientsInSearch.getText().split("\\r?\\n");
				
				//for(String s: ingredient) { 
				//	System.out.println(s);
				//}
			}
		});
		mainMenuPanel.add(btnSearchRecipeByIngredients);
		
		
		JButton btnSearchRecipeByBoth = new JButton("Search by Both");
		btnSearchRecipeByBoth.setBounds(255, 200, 200, 25);
		btnSearchRecipeByBoth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//txtrRecipeSearchResults.setText(rs.searchByIngredients(ingredientsInSearch.getText()));
				
				txtrRecipeSearchResults.setText(rc.searchByBoth(recipeNameField.getText(), ingredientsInSearch.getText()));
				
			}
		});
		mainMenuPanel.add(btnSearchRecipeByBoth);
		
		
		//This section displays the recipes that match the search results
		JLabel lblRecipeResults = new JLabel("Matching Recipe(s): ");
		lblRecipeResults.setBounds(487, 70, 200, 15);
		mainMenuPanel.add(lblRecipeResults);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(487, 90, 200, 280);
		mainMenuPanel.add(scrollPane1);
		
		txtrRecipeSearchResults = new JTextArea();
		txtrRecipeSearchResults.setEditable(false);
		scrollPane1.setViewportView(txtrRecipeSearchResults);
		
		/*
		 * 
		 * 
		 * 
		 * This section codes the Recipe Details Panel
		 * The panel where you can review the ingredients and instructions for any stored Recipe
		 *
		 *
		 *
		 */
		
		JLabel lblRecipeEdit = new JLabel("Recipe Details");
		lblRecipeEdit.setBounds(305, 12, 111, 15);
		recipeDetailsPanel.add(lblRecipeEdit);
		
		JLabel lblRecipeDirections = new JLabel("Recipe Directions: ");
		lblRecipeDirections.setBounds(255, 50, 200, 15);
		recipeDetailsPanel.add(lblRecipeDirections);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(255, 70, 440, 200);
		recipeDetailsPanel.add(scrollPane3);
		
		txtrRecipeSearchResults2 = new JTextArea();
		txtrRecipeSearchResults2.setEditable(false);
		scrollPane3.setViewportView(txtrRecipeSearchResults2);
		
		
		JLabel lblRecipeName2 = new JLabel("Select a Recipe: ");
		lblRecipeName2.setBounds(30, 50, 111, 15);
		recipeDetailsPanel.add(lblRecipeName2);
		
		JLabel lblRecipeIngredients2 = new JLabel("Recipe Ingredient(s): ");
		lblRecipeIngredients2.setBounds(30, 150, 200, 15);
		recipeDetailsPanel.add(lblRecipeIngredients2);
		
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(30, 165, 200, 205);
		recipeDetailsPanel.add(scrollPane4);
		
		JTextArea ingredientsInRecipe = new JTextArea();
		ingredientsInRecipe.setEditable(false);
		scrollPane4.setViewportView(ingredientsInRecipe);
		
		JLabel lblTotalCookTime = new JLabel("Total Cook Time (minutes): ");
		lblTotalCookTime.setBounds(30, 105, 200, 15);
		recipeDetailsPanel.add(lblTotalCookTime);
		
		JTextField recipeTotalCookTimeField = new JTextField();
		recipeTotalCookTimeField.setEditable(false);
		recipeTotalCookTimeField.setBounds(30, 120, 200, 25);
		recipeDetailsPanel.add(recipeTotalCookTimeField);
		recipeTotalCookTimeField.setColumns(10);
		   	 	
		JComboBox<String> jcbRecipeList = new JComboBox<String>(rc.returnAllRecipeNames());
		jcbRecipeList.setEditable(false);
		jcbRecipeList.setBounds(30, 70, 200, 25);
		jcbRecipeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				txtrRecipeSearchResults2.setText(rc.getRecipeDirections((String)jcbRecipeList.getSelectedItem()));
				ingredientsInRecipe.setText(rc.getRecipeIngredients((String)jcbRecipeList.getSelectedItem()));
				//System.out.println((String)jcbRecipeList.getSelectedItem());
				recipeTotalCookTimeField.setText(rc.getCookTime((String)jcbRecipeList.getSelectedItem()));
				//String ingredient[] = ingredientsInSearch.getText().split("\\r?\\n");
				//for(String s: ingredient) { 
				//	System.out.println(s);
				//}
			}
		});
		recipeDetailsPanel.add(jcbRecipeList);
		
		JLabel lblNavigation2 = new JLabel("Navigation: ");
		lblNavigation2.setBounds(255, 280, 111, 15);
		recipeDetailsPanel.add(lblNavigation2);
		
		JButton btnMainMenu = new JButton("Go To Recipe Search");
		btnMainMenu.setBounds(255, 315, 200, 25);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//register.finalizeSale();
				rc.returnAllRecipeNames();
				jcbRecipeList.removeAllItems();
				for(String s: rc.returnAllRecipeNames()) { 
					jcbRecipeList.addItem(s);
				}; 
				cardLayout.show(containerPanel, "mainMenuScreen");
				
			}
		});
		recipeDetailsPanel.add(btnMainMenu);
		
		JButton btnRecipeMgmt2 = new JButton("Go To Recipe Addition");
		btnRecipeMgmt2.setBounds(255, 345, 200, 25);
		btnRecipeMgmt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//register.finalizeSale();
				cardLayout.show(containerPanel, "recipeMgmtScreen");
				
			}
		});
		recipeDetailsPanel.add(btnRecipeMgmt2);
				
		/*
		 * 
		 * 
		 * 
		 * This section codes the Recipe Mgmt Panel
		 * The panel where you can create, edit, or delete recipes
		 *
		 *
		 *
		 */
		
		JLabel lblRecipeCreate = new JLabel("Add Recipes");
		lblRecipeCreate.setBounds(305, 12, 111, 15);
		recipeMgmtPanel.add(lblRecipeCreate);
		
		JLabel lblRecipeName3 = new JLabel("Recipe Name: ");
		lblRecipeName3.setBounds(30, 50, 111, 15);
		recipeMgmtPanel.add(lblRecipeName3);
		
		JTextField recipeNameField3 = new JTextField();
		recipeNameField3.setBounds(30, 70, 200, 25);
		recipeMgmtPanel.add(recipeNameField3);
		recipeNameField3.setColumns(10);
		
		JLabel lblTotalCookTime3 = new JLabel("Total Cook Time (minutes): ");
		lblTotalCookTime3.setBounds(30, 105, 200, 15);
		recipeMgmtPanel.add(lblTotalCookTime3);
		
		JTextField recipeTotalCookTimeField3 = new JTextField();
		recipeTotalCookTimeField3.setEditable(true);
		recipeTotalCookTimeField3.setBounds(30, 120, 200, 25);
		recipeMgmtPanel.add(recipeTotalCookTimeField3);
		recipeTotalCookTimeField3.setColumns(10);
		
		JLabel lblRecipeIngredients3 = new JLabel("Recipe Ingredient(s): ");
		lblRecipeIngredients3.setBounds(30, 150, 200, 15);
		recipeMgmtPanel.add(lblRecipeIngredients3);
		
		JLabel lblRecipeIngredientsNotice3 = new JLabel("(1 ingredient per line - lowercase)");
		lblRecipeIngredientsNotice3.setBounds(30, 165, 200, 15);
		recipeMgmtPanel.add(lblRecipeIngredientsNotice3);
		
		JScrollPane scrollPane5 = new JScrollPane();
		scrollPane5.setBounds(30, 185, 200, 185);
		recipeMgmtPanel.add(scrollPane5);
		
		JTextArea ingredientsInSearch3 = new JTextArea();
		ingredientsInSearch3.setEditable(true);
		scrollPane5.setViewportView(ingredientsInSearch3);
		
		JLabel lblRecipeDirections3 = new JLabel("Recipe Directions: ");
		lblRecipeDirections3.setBounds(255, 50, 200, 15);
		recipeMgmtPanel.add(lblRecipeDirections3);
		
		JScrollPane scrollPane6 = new JScrollPane();
		scrollPane6.setBounds(255, 70, 440, 200);
		recipeMgmtPanel.add(scrollPane6);
		
		txtrRecipeSearchResults3 = new JTextArea();
		txtrRecipeSearchResults3.setEditable(true);
		scrollPane6.setViewportView(txtrRecipeSearchResults3);
		
		JLabel lblRecipeFunctions = new JLabel("Functionality: ");
		lblRecipeFunctions.setBounds(487, 280, 200, 15);
		recipeMgmtPanel.add(lblRecipeFunctions);
		
		JTextField recipeCreationNotice = new JTextField();
		recipeCreationNotice.setBounds(487, 345, 200, 25);
		recipeCreationNotice.setEditable(false);
		recipeMgmtPanel.add(recipeCreationNotice);
		recipeCreationNotice.setColumns(10);
		
		JButton btnRecipeCreate = new JButton("Create Recipe");
		btnRecipeCreate.setBounds(487, 315, 200, 25);
		btnRecipeCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nameRecipeCreation = recipeNameField3.getText();
				String timeRecipeCreation = recipeTotalCookTimeField3.getText();
				String ingredientRecipeCreation = ingredientsInSearch3.getText();
				String directionsRecipeCreation = txtrRecipeSearchResults3.getText();
				
				String notification = rc.addNewRecipe(nameRecipeCreation, timeRecipeCreation, directionsRecipeCreation, ingredientRecipeCreation);
				recipeCreationNotice.setText(notification);
				
				if(notification.equals("Recipe Created Successfully")) { 
					recipeNameField3.setText("");
					recipeTotalCookTimeField3.setText("");
					ingredientsInSearch3.setText("");
					txtrRecipeSearchResults3.setText("");
					
				}
				
				
			}
		});
		recipeMgmtPanel.add(btnRecipeCreate);
		
		
		
		
		JLabel lblNavigation3 = new JLabel("Navigation: ");
		lblNavigation3.setBounds(255, 280, 111, 15);
		recipeMgmtPanel.add(lblNavigation3);
		
		JButton btnMainMenu2 = new JButton("Go To Recipe Search");
		btnMainMenu2.setBounds(255, 315, 200, 25);
		btnMainMenu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				rc.returnAllRecipeNames();
				jcbRecipeList.removeAllItems();
				for(String s: rc.returnAllRecipeNames()) { 
					jcbRecipeList.addItem(s);
				}; 
				
				cardLayout.show(containerPanel, "mainMenuScreen");
				
			}
		});
		recipeMgmtPanel.add(btnMainMenu2);
		
		JButton btnRecipeDetails2 = new JButton("Go To Recipe Details");
		btnRecipeDetails2.setBounds(255, 345, 200, 25);
		btnRecipeDetails2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rc.returnAllRecipeNames();
				jcbRecipeList.removeAllItems();
				for(String s: rc.returnAllRecipeNames()) { 
					jcbRecipeList.addItem(s);
				}; 
				
				cardLayout.show(containerPanel, "recipeDetailsScreen");
				
			}
		});
		recipeMgmtPanel.add(btnRecipeDetails2);
				
		
	}
}
