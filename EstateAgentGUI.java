/* Software Development & Testing - Assignment 1
LYIT Estate Agents GUI

Daire Gordon
L00162124  */

//importing everything needed for GUI creation
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;  //importing all from control
import javafx.scene.layout.*;  //Importing all from layout
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EstateAgentGUI extends Application
{
   //Create ArrayList propList to store new objects of the Property class
   ArrayList<Property> propList = new ArrayList<>();
   //Declaring controls outside of start method so other methods can see them
   //TextFields
   TextField txtStreet;
   TextField txtTown;
   TextField txtCounty;
   TextField txtBeds;
   TextField txtReceptions;
   TextField txtBaths;
   TextField txtType;
   TextField txtPrice;
   //TextFields scene2
   TextField txtPropNo;
   TextField txtSalary;
   TextField txtYears;
   //TextFields scene3
   TextField txtPropNo2;
   TextField txtStreet2;
   TextField txtTown2;
   TextField txtCounty2;
   TextField txtBeds2;
   TextField txtReceptions2;
   TextField txtBaths2;
   TextField txtType2;
   TextField txtPrice2;
   //TextFields scene4
   TextField txtPropNo3;
   //Buttons
   Button btnAddProperty;
   Button btnViewAll;
   Button btnSearchType;
   Button btnSearchBeds;
   Button btnSearchPrice;
   Button btnCalcMortgage;
   Button btnUpdateDetails;
   Button btnRemoveProperty;
   //Buttons scene2
   Button btnCalculate;
   Button btnReturn;
   //Buttons scene3
   Button btnSelect;
   Button btnUpdate;
   Button btnReturn2;
   //Buttons scene4
   Button btnRemove;
   Button btnReturn3;
   //TextArea
   TextArea txtOutput;
   //TextArea scene2
   TextArea txtOutput2;
   //Alert
   Alert a = new Alert(AlertType.NONE);
   //Integer to store property number referenced in both scene3 update methods
   int updatePropNo;
   
   
   //START METHOD
   public void start(Stage stage)
   {
      //MAIN SCENE
      //Creating Labels
      //Detail Titles
      Label lblAddress = new Label("Address:");
      Label lblRooms = new Label("Rooms:");
      Label lblOther = new Label("Other:");
      //Property Details
      Label lblStreet = new Label("Street");
      Label lblTown = new Label("Town");
      Label lblCounty = new Label("County");
      Label lblBeds = new Label("Beds");
      Label lblReceptions = new Label("Receptions");
      Label lblBaths = new Label("Baths");
      Label lblType = new Label("Type");
      Label lblPrice = new Label("Price");
      //Main Titles
      Label lblDetails = new Label("--PROPERTY DETAILS--");
      Label lblSearch = new Label("--PROPERTY SEARCH--");
      Label lblFunctions = new Label("--OTHER FUNCTIONS--");
      
      //Creating TextFields
      txtStreet = new TextField();
      txtTown = new TextField();
      txtCounty = new TextField();
      txtBeds = new TextField();
      txtReceptions = new TextField();
      txtBaths = new TextField();
      txtType = new TextField();
      txtPrice = new TextField();
      //Setting Max Widths
      txtStreet.setMaxWidth(100);
      txtTown.setMaxWidth(100);
      txtCounty.setMaxWidth(100);
      txtBeds.setMaxWidth(40);
      txtReceptions.setMaxWidth(40);
      txtBaths.setMaxWidth(40);
      txtType.setMaxWidth(80);
      txtPrice.setMaxWidth(80);
      
      //Creating Buttons
      btnAddProperty = new Button("Add Property");
      btnViewAll = new Button("View All Properties");
      btnSearchType = new Button("Search by Type");
      btnSearchBeds = new Button("Search by No. Beds");
      btnSearchPrice = new Button("Search by Price Range");
      btnCalcMortgage = new Button("Calculate Mortgage");
      btnUpdateDetails = new Button("Update Property Details");
      btnRemoveProperty = new Button("Remove Property");
      //Creating Lambda expressions for some of the buttons, rest have to be created later
      btnAddProperty.setOnAction(e -> addProperty(e));
      btnViewAll.setOnAction(e -> viewAll(e));
      btnSearchType.setOnAction(e -> searchType(e));
      btnSearchBeds.setOnAction(e -> searchBeds(e));
      btnSearchPrice.setOnAction(e -> searchPrice(e));
      
      //Creating TextArea for output text
      txtOutput = new TextArea();
      //Setting max size
      txtOutput.setMaxSize(650,300);
      //Making the TextArea non-editable
      txtOutput.setEditable(false);
      
      //Creating HBoxes for grouping property details Labels with TextFields
      HBox street = new HBox(10);  //10px buffer between HBox nodes
      street.getChildren().addAll(lblStreet, txtStreet);  //Using getChildren().addAll() to add multiple nodes to HBox at once
      HBox town = new HBox(10);
      town.getChildren().addAll(lblTown, txtTown);
      HBox county = new HBox(10);
      county.getChildren().addAll(lblCounty, txtCounty);
      HBox beds = new HBox(10);
      beds.getChildren().addAll(lblBeds, txtBeds);
      HBox receptions = new HBox(10);
      receptions.getChildren().addAll(lblReceptions, txtReceptions);
      HBox baths = new HBox(10);
      baths.getChildren().addAll(lblBaths, txtBaths);
      HBox type = new HBox(10);
      type.getChildren().addAll(lblType, txtType);
      HBox price = new HBox(10);
      price.getChildren().addAll(lblPrice, txtPrice);
      
      //Creating VBoxes for grouping property details into 3 columns
      //Address VBox with adress Label & HBoxes
      VBox boxAddress = new VBox(5);
      boxAddress.getChildren().addAll(lblAddress, street, town, county);
      //Rooms VBox with room Label & HBoxes
      VBox boxRooms = new VBox(5);
      boxRooms.getChildren().addAll(lblRooms, beds, receptions, baths);
      //Other VBox with other Label & HBoxes
      VBox boxOther = new VBox(5);
      boxOther.getChildren().addAll(lblOther, type, price);
      
      //Creating rest of HBoxes
      //HBox containing 3 property detail VBoxes
      HBox details = new HBox(30);
      details.getChildren().addAll(boxAddress, boxRooms, boxOther);
      details.setAlignment(Pos.CENTER);  //Setting box alignment to center
      //HBox containing search buttons
      HBox search = new HBox(30);
      search.getChildren().addAll(btnViewAll, btnSearchType, btnSearchBeds, btnSearchPrice);
      search.setAlignment(Pos.CENTER);
      //HBox containing 3 extra functions buttons
      HBox functions = new HBox(30);
      functions.getChildren().addAll(btnCalcMortgage, btnUpdateDetails, btnRemoveProperty);
      functions.setAlignment(Pos.CENTER);
      
      //Creating root VBox, adding children, setting alignment
      VBox root = new VBox(20);
      root.getChildren().addAll(lblDetails, details, btnAddProperty, lblSearch, search, lblFunctions, functions, txtOutput);
      root.setAlignment(Pos.CENTER);
      
      //Creating Scene, adding root to scene and setting size
      Scene scene = new Scene(root, 700, 700);
      stage.setScene(scene);  //Setting stage scene
      stage.setTitle("LYIT Estate Agents");  //Setting stage title
      stage.show();  //Displaying stage
      
      
      
      //SCENE 2 - MORTGAGE CALCULATOR
      //Creating Labels
      Label lblPropNo = new Label("Property No.");
      Label lblSalary = new Label("Salary");
      Label lblYears = new Label("Years");
      Label lblMortgageCalc = new Label("--MORTGAGE CALCULATOR--");
      
      //Creating TextFields & setting max widths
      txtPropNo = new TextField();
      txtSalary = new TextField();
      txtYears = new TextField();
      txtPropNo.setMaxWidth(50);
      txtSalary.setMaxWidth(100);
      txtYears.setMaxWidth(50);
      
      //Creating Buttons & lambda expressions
      btnCalculate = new Button("Calculate");
      btnReturn = new Button("Return");
      btnCalculate.setOnAction(e -> mortgageCalc(e));  //When Calculate pressed, calls mortgageCalc method
      btnReturn.setOnAction(e -> stage.setScene(scene));  //When return pressed, main scene shows
      
      //Creating TextArea for output text, setting size, making non-editable
      txtOutput2 = new TextArea();
      txtOutput2.setMaxSize(400,150);
      txtOutput2.setEditable(false);
      
      //Creating HBoxes to group TextFields with Labels & Setting alignments to CENTER
      HBox propNo = new HBox(10);
      propNo.getChildren().addAll(lblPropNo, txtPropNo);
      propNo.setAlignment(Pos.CENTER);
      HBox salary = new HBox(10);
      salary.getChildren().addAll(lblSalary, txtSalary);
      salary.setAlignment(Pos.CENTER);
      HBox years = new HBox(10);
      years.getChildren().addAll(lblYears, txtYears);
      years.setAlignment(Pos.CENTER);
      
      //Creating VBoxes, Adding children, setting alignments
      VBox mortDetails = new VBox(5);
      mortDetails.getChildren().addAll(propNo, salary, years);
      mortDetails.setAlignment(Pos.CENTER);
      VBox root2 = new VBox(20);
      root2.getChildren().addAll(lblMortgageCalc, mortDetails, btnCalculate, txtOutput2, btnReturn);
      root2.setAlignment(Pos.CENTER);
      
      //Creating scene2, adding root2, setting size
      Scene scene2 = new Scene(root2, 450, 500);
      
      //Lambda expression for btnCalcMortgage must be after scene 2 is created to work
      btnCalcMortgage.setOnAction(e -> stage.setScene(scene2));
      
      
      
      //SCENE 3 - PROPERTY UPDATE
      //Creating labels
      Label lblPropNo2 = new Label("Property No.");
      Label lblPropUpdate = new Label("--PROPERTY UPDATE--");
      //Detail Titles (Copies of main scene)
      Label lblAddress2 = new Label("Address:");
      Label lblRooms2 = new Label("Rooms:");
      Label lblOther2 = new Label("Other:");
      //Property Details (Copies of main scene)
      Label lblStreet2 = new Label("Street");
      Label lblTown2 = new Label("Town");
      Label lblCounty2 = new Label("County");
      Label lblBeds2 = new Label("Beds");
      Label lblReceptions2 = new Label("Receptions");
      Label lblBaths2 = new Label("Baths");
      Label lblType2 = new Label("Type");
      Label lblPrice2 = new Label("Price");
      //Main Titles (Copies of main scene)
      Label lblDetails2 = new Label("--PROPERTY DETAILS--");
      
      //Creating TextFields, mostly copies of property details on main scene
      txtStreet2 = new TextField();
      txtTown2 = new TextField();
      txtCounty2 = new TextField();
      txtBeds2 = new TextField();
      txtReceptions2 = new TextField();
      txtBaths2 = new TextField();
      txtType2 = new TextField();
      txtPrice2 = new TextField();
      txtPropNo2 = new TextField();
      //Setting Max Widths
      txtStreet2.setMaxWidth(100);
      txtTown2.setMaxWidth(100);
      txtCounty2.setMaxWidth(100);
      txtBeds2.setMaxWidth(40);
      txtReceptions2.setMaxWidth(40);
      txtBaths2.setMaxWidth(40);
      txtType2.setMaxWidth(80);
      txtPrice2.setMaxWidth(80);
      txtPropNo2.setMaxWidth(60);
      
      //Creating Buttons & Lambda expressions
      btnSelect = new Button("Select Property");
      btnUpdate = new Button("Update");
      btnReturn2 = new Button("Return");
      btnSelect.setOnAction(e -> fillDetails(e));  //Pressing select fills TextFields with that property's info
      btnUpdate.setOnAction(e -> updateDetails(e));  //Pressing update overwrites original info with whats in TextFields
      btnReturn2.setOnAction(e -> stage.setScene(scene));  //Return to go back to main scene
      
      //Creating HBox to group property number Label, TextField & Select Button
      HBox select = new HBox(10);
      select.getChildren().addAll(lblPropNo2, txtPropNo2, btnSelect);
      select.setAlignment(Pos.CENTER);
      //Creating HBoxes for grouping property details (copies of main scene)
      HBox street2 = new HBox(10); 
      street2.getChildren().addAll(lblStreet2, txtStreet2);
      HBox town2 = new HBox(10);
      town2.getChildren().addAll(lblTown2, txtTown2);
      HBox county2 = new HBox(10);
      county2.getChildren().addAll(lblCounty2, txtCounty2);
      HBox beds2 = new HBox(10);
      beds2.getChildren().addAll(lblBeds2, txtBeds2);
      HBox receptions2 = new HBox(10);
      receptions2.getChildren().addAll(lblReceptions2, txtReceptions2);
      HBox baths2 = new HBox(10);
      baths2.getChildren().addAll(lblBaths2, txtBaths2);
      HBox type2 = new HBox(10);
      type2.getChildren().addAll(lblType2, txtType2);
      HBox price2 = new HBox(10);
      price2.getChildren().addAll(lblPrice2, txtPrice2);
      
      //Creating VBoxes for grouping property detail copies into 3 columns (Copies of main scene)
      VBox boxAddress2 = new VBox(5);
      boxAddress2.getChildren().addAll(lblAddress2, street2, town2, county2);
      VBox boxRooms2 = new VBox(5);
      boxRooms2.getChildren().addAll(lblRooms2, beds2, receptions2, baths2);
      VBox boxOther2 = new VBox(5);
      boxOther2.getChildren().addAll(lblOther2, type2, price2);
      
      //HBox containing 3 property detail columns (Copy of main scene)
      HBox details2 = new HBox(30);
      details2.getChildren().addAll(boxAddress2, boxRooms2, boxOther2);
      details2.setAlignment(Pos.CENTER);
      
      //Creating root3 VBox, adding children, setting alignment
      VBox root3 = new VBox(20);
      root3.getChildren().addAll(lblPropUpdate, select, lblDetails2, details2, btnUpdate, btnReturn2);
      root3.setAlignment(Pos.CENTER);
      
      //Creating scene3, adding root3 and setting size
      Scene scene3 = new Scene(root3, 600, 500);
      
      //Adding Lambda expression for main scene button after scene creation
      btnUpdateDetails.setOnAction(e -> stage.setScene(scene3));  //Pressing button on main scene opens update scene
      
      
      
      //SCENE 4 - DELETE PROPERTY
      //Creating Labels
      Label lblRemoveProp = new Label("--REMOVE PROPERTY--");
      Label lblRemoveInfo = new Label("Please enter the Property Number of the property you wish to remove from the system");
      Label lblPropNo3 = new Label("Property No.");
      
      //Creating TextField & Setting max width
      txtPropNo3 = new TextField();
      txtPropNo3.setMaxWidth(60);
      
      //Creating Buttons & Lambda expressions
      btnRemove = new Button("Remove");
      btnReturn3 = new Button("Return");
      btnRemove.setOnAction(e -> removeProperty(e));  //remove button calls removeProperty method, removing property & updating remaining propNo's
      btnReturn3.setOnAction(e -> stage.setScene(scene));  //return button goes back to main scene
      
      //Creating HBox to store input nodes, adding nodes & setting alignment
      HBox remove = new HBox(10);
      remove.getChildren().addAll(lblPropNo3, txtPropNo3, btnRemove);
      remove.setAlignment(Pos.CENTER);
      
      //Creating root4 VBox, adding nodes & setting alignment
      VBox root4 = new VBox(20);
      root4.getChildren().addAll(lblRemoveProp, lblRemoveInfo, remove, btnReturn3);
      root4.setAlignment(Pos.CENTER);
      
      //Creating scene4 and adding root4
      Scene scene4 = new Scene(root4, 600, 300);
      
      //Adding Lambda expressions for main scene button
      btnRemoveProperty.setOnAction(e -> stage.setScene(scene4));  //Pressing button on main scene opens remove scene  
   } //End of start
   
   
   
   
   //STANDARD METHODS
   //addProperty Method to add Property object to ArrayList
   public void addProperty(ActionEvent e)
   {
      //try-catch block to catch any possible exceptions and display error messages
      try
      {
         //Clearing TextArea
         txtOutput.clear();
         
         //Check if any TextFields are empty
         if(txtStreet.getText().isEmpty() || txtTown.getText().isEmpty() || txtCounty.getText().isEmpty() || txtBeds.getText().isEmpty() || txtReceptions.getText().isEmpty() || txtBaths.getText().isEmpty() || txtType.getText().isEmpty() || txtPrice.getText().isEmpty())
         {
            txtOutput.appendText("Please make sure all property details are filled in");
         }
         //If all TextFields filled in, else is executed
         else
         {
            //Clearing TextArea
            txtOutput.clear();
            
            //Acquiring constructor parameters
            String address = String.join(", ", txtStreet.getText(), txtTown.getText(), txtCounty.getText());  //Joining Street, Town, County TextFields to define address variable (Got from w3Schools)
            int beds = Integer.parseInt(txtBeds.getText());  //Parsing txtBeds to Integer and assigning to beds variable
            int receptions = Integer.parseInt(txtReceptions.getText());  //Parsing txtReceptions to Integer and assigning to receptions variable
            int baths = Integer.parseInt(txtBaths.getText());  //Parsing txtBaths to Integer and assigning to baths variable
            double price = Double.parseDouble(txtPrice.getText());  //Parsing txtPrice to Double and assigning to price variable
            String type = txtType.getText();  //Assigning text in txtType to type variable
            
            //Creating Property object & adding to ArrayList propList
            propList.add(new Property(address, beds, baths, receptions, price, type));
            //Displaying message for successful execution
            txtOutput.appendText("Property Added Successfully!");
            
            //Clearing TextFields
            txtStreet.clear();
            txtTown.clear();
            txtCounty.clear();
            txtBeds.clear();
            txtReceptions.clear();
            txtBaths.clear();
            txtType.clear();
            txtPrice.clear();
         }
      }
      //NumberFormatException for when letters are entered to a field that requires numbers, or decimals to a field that requires an integer
      catch(NumberFormatException ex)
      {
         txtOutput.appendText("Error: Beds, Receptions, Baths, Price all require numeric values\nApart from Price, these cannot be decimal values");
      }
      //IllegalArgumentException for when 0 or less is entered for any value (Apart from receptions which is allowed to be 0)
      catch(IllegalArgumentException ex)
      {
         txtOutput.appendText("Error: Beds, Receptions, Baths, Price all must have positive values");
      }
   }
   
   //viewAll Method to view all properties
   public void viewAll(ActionEvent e)
   {
      //Clearing the TextArea
      txtOutput.clear();
      //for each to iterate through propList ArrayList
      for(Property p: propList)
      {
         //Display details of each object in TextArea on seperate lines
         txtOutput.appendText(p + "\n");
      }
   }
   
   //searchType Method to search properties by property Type
   public void searchType(ActionEvent e)
   {
      //Clearing the TextArea
      txtOutput.clear();
      
      //Getting property Type from user
      String searchType = txtType.getText();
      
      //Initialising boolean as false to determine if search was successful or not
      boolean isFound = false;
      //for loop to search through the ArrayList propList
      for(int i=0; i < propList.size(); i++)
      {
         //if searchType String matches type of current property in loop
         if(searchType.equalsIgnoreCase(propList.get(i).getType()))  //Cannot simply use '==' for Strings, must use .equals, IgnoreCase makes it not case sensitive
         {
            //Prints property details in TextArea & changes boolean to true
            txtOutput.appendText(propList.get(i) + "\n");
            isFound = true;
         }
      }
      //if boolean still false after searching the ArrayList for matches
      if(isFound == false)
      {
         //Print message in TextArea
         txtOutput.appendText("No properties found matching Type searched");
      }
   }
   
   //searchBeds Method to search properties by no. bedrooms
   public void searchBeds(ActionEvent e)
   {
      //Clearing the TextArea
      txtOutput.clear();
      
      //Getting no. Beds from user
      int searchBeds = Integer.parseInt(txtBeds.getText());  //Must parse String in TextField to an Integer for search
      
      //Initialising boolean as false to determine if search was successful or not
      boolean isFound = false;
      //for loop to search through the ArrayList propList
      for(int i=0; i < propList.size(); i++)
      {
         //if property has same no. of Beds as searched
         if(searchBeds == propList.get(i).getBeds())
         {
            //Prints property details in TextArea & changes boolean to true
            txtOutput.appendText(propList.get(i) + "\n");
            isFound = true;
         }
      }
      //if boolean still false after searching the ArrayList for matches
      if(isFound == false)
      {
         //Print message in TextArea
         txtOutput.appendText("No properties found with selected Bedrooms");
      }
   }
   
   //searchPrice Method to search properties by price range
   public void searchPrice(ActionEvent e)
   {
      //Clearing the TextArea
      txtOutput.clear();
      
      //Getting Price from user
      double searchPrice = Double.parseDouble(txtPrice.getText());  //Must parse String in TextField to a Double for search
      
      //Initialising boolean as false to determine if search was successful or not
      boolean isFound = false;
      //for loop to search through the ArrayList propList
      for(int i=0; i < propList.size(); i++)
      {
         //if property is cheaper or same price as searched
         if(searchPrice >= propList.get(i).getPrice())
         {
            //Prints property details in TextArea & changes boolean to true
            txtOutput.appendText(propList.get(i) + "\n");
            isFound = true;
         }
      }
      //if boolean still false after searching the ArrayList for matches
      if(isFound == false)
      {
         //Print message in TextArea
         txtOutput.appendText("No properties found in selected Price range");
      }
   }
   
   
   
   //CUSTOM METHODS
   //mortgageCalc method to verify mortgage eligibility and calculate repayments
   public void mortgageCalc(ActionEvent e)
   {
      //try-catch block to catch any exceptions and display error messages
      try
      {
         //Clearing TextArea
         txtOutput2.clear();
         
         //Parsing Textfields into Integers & Doubles to use in calculation
         int propNo = Integer.parseInt(txtPropNo.getText());
         double salary = Double.parseDouble(txtSalary.getText());
         int years = Integer.parseInt(txtYears.getText());
         double price = propList.get(propNo - 1).getPrice();  //Must reduce propNo by 1 when retrieving from ArrayList as index starts at 0
         
         //Checking if any values entered are <= 0
         if(propNo <= 0 || salary <= 0 || years <= 0)
         {
            //Display error message
            txtOutput2.appendText("Error: Entered values must all be greater than 0");
         }
         //If all values positive, execute rest of code
         else
         {
            //If property value is over 3 times users salary print message
            if(price > (3 * salary))
            {
               txtOutput2.appendText("Sorry, you are not eligible for a mortgage\nSalary must be at least 1/3 of the property value");
            }
            //Or if mortgage term is over 25 years, print message
            else if(years > 25)
            {
               txtOutput2.appendText("Sorry, maximum mortgage term is 25 years\nPlease reduce number of years");
            }
            //If both conditions above false, calculate & show monthly repayments
            else
            {
               txtOutput2.appendText("Monthly repayments @ 4% interest rate is: €"+ propList.get(propNo - 1).calcRepayment(years));  //Using calcRepayment method from Property class to get value based on propNo entered
            }
         }
      }
      //IndexOutOfBoundsException for trying to access ArrayList index value which doesnt exist
      catch(IndexOutOfBoundsException ex)
      {
         txtOutput2.appendText("Error: Property No. must exist on the system");
      }
      //NumberFormatException for when letters are entered to a field that requires numbers, or decimals to a field that requires an integer
      catch(NumberFormatException ex)
      {
         txtOutput2.appendText("Error: Property No. & Years require positive Integer values\nSalary can be a positive Integer or decimal");
      }
   }
   
   //Updating Property Details Methods
   //fillDetails to load in selected property details to the TextFields to be edited
   public void fillDetails(ActionEvent e)
   {
      //try-catch block to catch any exceptions and display error messages
      try
      {
         //Parsing property number from txtPropNo TextField, defining as variable declared before start method so user cannot update details of property that is not 'selected' first
         updatePropNo = Integer.parseInt(txtPropNo2.getText());
         //Splitting property address String into a list of 3 Strings corresponding to Street, Town, County (Got this from w3schools)
         String[] addParts = propList.get(updatePropNo - 1).getAddress().split(",");  //Defining the comma ',' as the character to be split around
         
         //Setting property detail TextFields as current details using parsing & getMethods
         txtStreet2.setText(addParts[0]);  //Setting txtStreet2 TextField as first element in list of split address, corresponding to the Street
         txtTown2.setText(addParts[1]);  //Same as above but for second element which corresponds to the Town, same below for County
         txtCounty2.setText(addParts[2]);
         txtBeds2.setText(Integer.toString(propList.get(updatePropNo - 1).getBeds()));  //Need to parse integer back to String to be able to set in TextField
         txtReceptions2.setText(Integer.toString(propList.get(updatePropNo - 1).getReceptions()));  //Same as above for rest of the values
         txtBaths2.setText(Integer.toString(propList.get(updatePropNo - 1).getBaths()));
         txtType2.setText(propList.get(updatePropNo - 1).getType());
         txtPrice2.setText(Double.toString(propList.get(updatePropNo - 1).getPrice()));
      }
      //IndexOutOfBoundsException for trying to access ArrayList index value which doesnt exist
      catch(IndexOutOfBoundsException ex)
      {
         a.setAlertType(AlertType.ERROR);  //Setting type of alert box to Error
         a.setContentText("Property No. must exist on the system");  //Setting text inside alert box
         a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);  //Got this line from StackOverflow, resizes Alert to fit whatever text is inside
         a.show();  //Show alert box
      }
      //NumberFormatException for when letters are entered to a field that requires numbers, or decimals to a field that requires an integer
      catch(NumberFormatException ex)
      {
         a.setAlertType(AlertType.ERROR);
         a.setContentText("Property No. requires an Integer value only");
         a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);  //Got this line from StackOverflow, resizes Alert to fit whatever text is inside
         a.show();
      }
   }
   //updateDetails method to update selected property details with ones typed in TextFields
   public void updateDetails(ActionEvent e)
   {
      try
      {
         //Check if any TextFields are empty
         if(txtStreet2.getText().isEmpty() || txtTown2.getText().isEmpty() || txtCounty2.getText().isEmpty() || txtBeds2.getText().isEmpty() || txtReceptions2.getText().isEmpty() || txtBaths2.getText().isEmpty() || txtType2.getText().isEmpty() || txtPrice2.getText().isEmpty())
         {
            a.setAlertType(AlertType.ERROR);
            a.setContentText("Please make sure all property details are filled in");
            a.show();
         }
         //If all TextFields filled in, else is executed
         else
         {
            //Rejoining the 3 address components into a single String called address (Got from w3schools)
            String address = String.join(", ", txtStreet2.getText(), txtTown2.getText(), txtCounty2.getText());
            //Setting property details to whatever is currently typed in TextFields using setMethods
            //Using updatePropNo from previous method and not re-parsing txtPropNo, so user cannot update property details without loading info into TextFields first
            propList.get(updatePropNo - 1).setAddress(address);
            propList.get(updatePropNo - 1).setBeds(Integer.parseInt(txtBeds2.getText()));  //Parsing TextField back to integer setMethod parameter
            propList.get(updatePropNo - 1).setReceptions(Integer.parseInt(txtReceptions2.getText()));
            propList.get(updatePropNo - 1).setBaths(Integer.parseInt(txtBaths2.getText()));
            propList.get(updatePropNo - 1).setType(txtType2.getText());
            propList.get(updatePropNo - 1).setPrice(Double.parseDouble(txtPrice2.getText()));  //Parsing into Double for setMethod parameter
            
            //Showing Alert after updating details
            a.setAlertType(AlertType.INFORMATION);
            a.setContentText("Property #"+updatePropNo+"'s Details Updated");
            a.show();
         }
      }
      //IllegalArgumentException for when 0 or less is entered for any value (Apart from receptions which is allowed to be 0)
      //Since NumberFormatException falls under this, it will catch letters/decimals written where they shouldn't be aswell
      catch(IllegalArgumentException ex)
      {
         a.setAlertType(AlertType.ERROR);
         a.setContentText("Beds, Receptions, Baths must all have positive Integer values\nPrice can be a positive Integer or decimal value");
         a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);  //Got this line from StackOverflow, resizes Alert to fit whatever text is inside
         a.show();
      }
      catch(IndexOutOfBoundsException ex)
      {
         a.setAlertType(AlertType.ERROR);
         a.setContentText("Load in existing Property No. before updating");
         a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);  //Got this line from StackOverflow, resizes Alert to fit whatever text is inside
         a.show();
      }
      
   }  
      
   //removeProperty Method
   //Realised after completing that updating and shifting property numbers after removal may not be a good idea from a business/database view but decided to leave it in just to show how it could be done
   public void removeProperty(ActionEvent e)
   {
      try
      {
         //Parsing the property number TextField to an integer, subtracting 1, and assigning to a variable index
         int index = (Integer.parseInt(txtPropNo3.getText()) - 1);
         
         //Removing the selected property from ArrayList propList using index value
         propList.remove(index);
         
         //Shifting all properties with index value above 'index' back 1 place so property numbers remain continuous
         for(int i=index; i < propList.size(); i++)  //Instead of 0, here 'i' starts at 'index' value
         {
            //Setting property number as current property number - 1
            propList.get(i).setPropertyNo(propList.get(i).getPropertyNo() - 1);
         }
         
         //Calls static method that reduces property number counter in Property Class by 1 so new properties added after dont skip a number
         Property.reduceCounter();
         
         //Showing alert after removal and repositiioning
         a.setAlertType(AlertType.INFORMATION);
         a.setContentText("Property #"+(index + 1)+" Removed from System");
         a.show();
      }
      catch(IndexOutOfBoundsException ex)
      {
         a.setAlertType(AlertType.ERROR);
         a.setContentText("Property No. must exist on the system");
         a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);  //Got this line from StackOverflow, resizes Alert to fit whatever text is inside
         a.show();
      }
      catch(NumberFormatException ex)
      {
         a.setAlertType(AlertType.ERROR);
         a.setContentText("Property No. requires an Integer value only");
         a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);  //Got this line from StackOverflow, resizes Alert to fit whatever text is inside
         a.show();
      }
   }
   
   //Main method
   public static void main(String [] args)
   {
      launch(args);
   }
}