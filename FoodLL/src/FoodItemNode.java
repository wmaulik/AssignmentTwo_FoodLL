/**
 * @author Writesh Maulik
 *
 */

import java.io.Serializable;

public class FoodItemNode <T> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3188182954994050318L;
	private T data;
	private FoodItemNode<T> pointer;
	
	public FoodItemNode(T data) 
	{
		// TODO Auto-generated constructor stub
		this.data = data;
		this.pointer = null;
	}
	
	public FoodItemNode(T data, FoodItemNode<T> pointer)
	{
		this.data = data;
		this.pointer = pointer;
	}
	
	/**
	 * returns data
	 */
	public T getData()
	{
		return this.data;
	}
	
	/**
	 * sets data
	 */
	public void setData(T data)
	{
		this.data = data;
	}
	
	/**
	 * returns the pointer
	 */
	public FoodItemNode<T> getPointer()
	{
		return this.pointer;
	}
	
	/**
	 * sets pointer
	 */
	public void setPointer(FoodItemNode<T> pointer)
	{
		this.pointer = pointer;
	}
}
