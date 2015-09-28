import java.io.Serializable;

/**
 * @author Writesh Maulik
 *
 */


public class FoodItem implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3222232600479325465L;
	private String name;
	private String nutrition;
	private double price;
	
	/**
	 * creates a food or drink items that have the attributes:
	 * String Name
	 * String nutrition
	 * String Price
	 * 
	 */
	public FoodItem(String aName, String nutritionInfo, double aPrice)
	{
		name = aName;
		nutrition = nutritionInfo;
		price = aPrice;
	}
	
	/**
	 * changes the name of the food or drink item 
	 */
	public void setName(String aName)
	{
		this.name = aName;
	}
	
	/**
	 * gets the name of a food item
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * sets nutrition information
	 */
	public void setNutrition(String nutritionInfo)
	{
		this.nutrition = nutritionInfo;
	}
	
	/**
	 * gets nutrition information
	 */
	public String getNutrition()
	{
		return this.nutrition;
	}
	
	/**
	 * sets price
	 */
	public void setPrice(double aPrice)
	{
		aPrice = this.price;
	}
	
	/**
	 * get price
	 */
	public double getPrice()
	{
		return this.price;
	}
	
	/**
	 * displays all the variables
	 */
	public String toString()
	{
		return "Name: " + this.getName() + "\n"
				+ "Nutrition Information: " + this.getNutrition() + "\n"
				+ "price $" + this.getPrice();
	}
}