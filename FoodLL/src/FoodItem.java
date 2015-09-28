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
	private double price;
	private int quantity;
	private String description;
	private int size;
	private boolean specialOrder;
	
	/**
	 * creates a food or drink items that have the attributes:
	 * String Name
	 * String nutrition
	 * String Price
	 * 
	 */
	public FoodItem(String aName, String newDescription, double aPrice, int aSize)
	{
		this.name = aName;
		this.description = newDescription;
		this.price = aPrice;
		this.quantity = 0;
		this.size = aSize;
		this.specialOrder = false;
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
	public void setDescription(String aDescription)
	{
		this.description = aDescription;
	}
	
	/**
	 * gets nutrition information
	 */
	public String getDescription()
	{
		return this.description;
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
	 * sets quantity
	 */
	public void setQuantity(double aQuantity)
	{
		aQuantity = this.quantity;
	}
	
	/**
	 * get quantity
	 */
	public int getQuantity()
	{
		return this.quantity;
	}
	
	/**
	 * set size
	 */
	public void setSize(int aSize)
	{
		this.size = aSize;
	}
	
	/**
	 * get size
	 */
	public int getSize()
	{
		return this.size;
	}
	
	/**
	 * set special order
	 */
	public void setSpeicalOrder(boolean aSpecialOrder)
	{
		this.specialOrder = aSpecialOrder;
	}
	
	/**
	 * get special order
	 */
	public boolean getSpecialOrder()
	{
		return this.specialOrder;
	}
	
	/**
	 * displays all the variables
	 */
	public String toString()
	{
		return "Name: " + this.getName() + "\n"
				+ "Nutrition Information: " + this.getDescription() + "\n"
				+ "price $" + this.getPrice() + "\n"
				+ "quantity " + this.getQuantity();
	}
}