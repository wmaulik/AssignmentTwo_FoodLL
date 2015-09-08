/**
 * @author Writesh Maulik
 *
 */

public class Dispenser extends FoodInfo
{
	private int quantity;
	
	/**
	 * constructor for dispenser item;
	 * dispenser doesn't need location
	 */
	public Dispenser(String aName, String nutritionInfo, double aPrice)
	{
		super(aName, nutritionInfo, aPrice);
		quantity = 20;
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
		return super.toString() + "location: " + "remaining " + this.getName() + "s: " 
				+ this.getQuanitity();
	}
	
}
