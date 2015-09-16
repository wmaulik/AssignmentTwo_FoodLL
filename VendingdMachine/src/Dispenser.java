/**
 * @author Writesh Maulik
 *
 */

import java.io.Serializable;

public class Dispenser extends FoodInfo implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2147409446373824895L;
	private int quantity;

	/**
	 * constructor for dispenser item;
	 * 
	 */
	public Dispenser(String aName, String nutritionInfo, double aPrice)
	{
		super(aName, nutritionInfo, aPrice);
		this.quantity = 20;
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
		return super.toString() + "\n" +
				"in stock: " + this.getQuanitity();
	}
	
}
