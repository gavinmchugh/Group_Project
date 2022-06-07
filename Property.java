/* Software Development & Testing - Assignment 1
Property Class for EstateAgentGUI

Daire Gordon
L00162124 */


public class Property
{
   //INSTANCE VARIABLES
   private int propertyNo;    //Unique property number
   private String address;    //Property address
   private int noBeds;        //Number of bedrooms in property
   private int noBaths;       //Number of bathrooms in property
   private int noReceptions;  //Number of receptions in property 
   private double price;      //Price of property
   private String propType;       //Type of property (Semi detached, detached, terrace etc.)
   private static int nextPropertyNo = 1; //Static counter for generating unique property numbers starting at 1
   
   
   //CONSTRUCTORS
   //First constructor assigns property number & takes property address as parameter
   public Property(String add)
   {
      //Not using this constructor for GUI so no need for Exception Handling here
      propertyNo = nextPropertyNo++; //After the property number is assigned the value of nextPropertyNo, it is then incremented for the next assigning
      address = add; //Parameter add assigned to Property address variable
      noBeds = 0; //All other variables initialised to default
      noBaths = 0;
      noReceptions = 0;
      price = 0.00;
      propType = " ";
   }
   //Second constructor takes all property details as parameters and assigns appropriately
   public Property(String add, int beds, int baths, int receptions, double value, String type) throws IllegalArgumentException
   {
      //If room or property price values are equal to or less than 0 (Except receptions), throw IllegalArgumentException, object wont be created
      if(beds <= 0 || baths <= 0 || receptions < 0 || value <= 0)
      {
         throw new IllegalArgumentException();
      }
      //If values all legal, creates property object
      else
      {
         propertyNo = nextPropertyNo++;
         address = add;
         noBeds = beds;
         noBaths = baths;
         noReceptions = receptions;
         price = value;
         propType = type;
      }
   }
   
   
   //METHODS
   //Get Methods
   //Returns all property details to be printed as a string
   public String toString()
   {
      return "Property Number: "+propertyNo+", Address: "+address+", Beds: "+noBeds+", Receptions: "+noReceptions+", Baths: "+noBaths+", Type: "+propType+", Price: "+price;
   }
   //Returns property Number
   public int getPropertyNo()
   {
      return propertyNo;
   }
   //Returns property address
   public String getAddress()
   {
      return address;
   }
   //Returns number of beds in property
   public int getBeds()
   {
      return noBeds;
   }
   //Returns number of bathrooms in property
   public int getBaths()
   {
      return noBaths;
   }
   //Returns number of receptions in property
   public int getReceptions()
   {
      return noReceptions;
   }
   //Returns property value
   public double getPrice()
   {
      return price;
   }
   //Returns property Type
   public String getType()
   {
      return propType;
   }
   
   //Other Methods
   //Returns amount of property tax due
   public double propertyTax()
   {
      //Value of property tax categorised based on property value
      if(price >= 0 && price <= 100000)
      {
         return 90;
      }
      else if(price > 100000 && price <= 200000)
      {
         return 225;
      }
      else if(price > 200000 && price <= 500000)
      {
         return 405;
      }
      else if(price > 500000 && price <= 1000000)
      {
         return 1500;
      }
      else
      {
         return 3000;
      } //End of if-else if-else
   }
   //Checks customers eligibility for a mortgage taking customers annual salary as parameter
   public String checkMortgage(double salary)
   {
      //If value of property is less than or equals to 3 times the customers salary, customer is eligible for mortgage
      if(price <= (3 * salary))
      {
         return "Customer qualifies for a Mortgage";
      }
      else
      {
         return "Unfortunately Customer does not qualify for a Mortgage";
      } //End of if-else
   }
   //Takes mortgage term in years and calculates monthly repayments @ interest rate of 4%
   //25 year limit implemented in GUI program so no if-else needed here
   public double calcRepayment(int years)
   {
      //Adding 4% of the property price onto the original price, then dividing by number of months over mortgage term
      return (price + (0.04 * price)) / (12 * years);
   }
   
   //Set Methods
   //Set new property number, only used for updating property numbers after property removed from ArrayList
   public void setPropertyNo(int num)
   {
      propertyNo = num;
   }
   //Set property address
   public void setAddress(String add)
   {
      address = add;
   }
   //Set number of beds, throws IllegalArgumentException if num is equal or less than 0
   public void setBeds(int num) throws IllegalArgumentException
   {
      if(num <= 0)
      {
         throw new IllegalArgumentException();
      }
      else
      {
         noBeds = num;
      }
   }
   //Set number of bathrooms, throws IllegalArgumentException if num is equal or less than 0
   public void setBaths(int num) throws IllegalArgumentException
   {
      if(num <= 0)
      {
         throw new IllegalArgumentException();
      }
      else
      {
         noBaths = num;
      }
   }
   //Set number of receptions, throws IllegalArgumentException if num is less than 0 (Presuming properties can have 0 receptions)
   public void setReceptions(int num)
   {
      if(num < 0)
      {
         throw new IllegalArgumentException();
      }
      else
      {
         noReceptions = num;
      }
   }
   //Set property price, throws IllegalArgumentException if num is equal or less than 0
   public void setPrice(double value)
   {
      if(value <= 0)
      {
         throw new IllegalArgumentException();
      }
      else
      {
         price = value;
      }
   }
   //Set property Type
   public void setType(String type)
   {
      propType = type;
   }
   
   //Decrease counter value by 1, had to make method static to be able to call without creating an object
   //Used after property removed from ArrayList to maintain continuous assigning of property numbers
   public static void reduceCounter()
   {
      nextPropertyNo = (nextPropertyNo - 1);
   }
}
         
   
   