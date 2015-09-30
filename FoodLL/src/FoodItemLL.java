/**
 * @author Writesh Maulik
 */

import java.io.Serializable;

public class FoodItemLL <X> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7080974178964077517L;
	private FoodItemNode <X> head;
	private FoodItemNode <X> tail;
	
	public FoodItemLL() 
	{
		// TODO Auto-generated constructor stub
		this.head = null;	
	}
	
	/**
	 * queues new item to data
	 */
	public void queue(X data)
	{
		FoodItemNode <X> node = new FoodItemNode<X> (data);
		if (this.head == null)
		{
			this.head = node;
		}
		else
		{
			this.tail.setPointer(node);
		}
	}
}
