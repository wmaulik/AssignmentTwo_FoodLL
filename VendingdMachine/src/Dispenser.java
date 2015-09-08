/**
 * @author Writesh Maulik
 *
 */

public class Dispenser extends FoodInfo
{
	private char row;
	private char column;
	private int quantity;
	
	/**
	 * constructor for dispenser item;
	 * 
	 */
	public Dispenser(String aName, String nutritionInfo, double aPrice, String location)
	{
		super(aName, nutritionInfo, aPrice);
		this.column = location.charAt(0);
		this.row = location.charAt(1);
		quantity = 20;
	}
	
	/**
	 * sets the location
	 */
	public void setLocation(String location)
	{
		this.column = location.charAt(0);
		this.row = location.charAt(1);
	}
	
	/**
	 * gets the location 
	 */
	public String getLocation()
	{
		String location = "";
		location = "" + this.column + this.row;
		return location;
	}
	
	/**
	 * sets the quantity
	 */
	public void setQuantity(int aQuantity)
	{
		if (aQuantity > 20 || aQuantity < 1)
		{
			System.out.println("This dispenser holds between 1 and 20 " + 
					super.getName() + "s.");
		}
		else
		{
			this.quantity = aQuantity;
		}
	}
	
	/**
	 * gets the quantity remaining
	 */
	public int getQuanitity()
	{
		return this.quantity;
	}
	
	/**
	 * displays information about the dispenser
	 */
	public String toString()
	{
		return super.toString() + "location: " + this.getLocation() +
				"remaining " + this.getName() + "s: " + this.getQuanitity();
	}
	
}
