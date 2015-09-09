/**
 * @author Writesh Maulik
 *
 */


public class VendingMachine 
{	
	private Dispenser [][] emptyMachine;
	private int time;
	
	public VendingMachine() 
	{
		// TODO Auto-generated constructor stub
		emptyMachine = new Dispenser [5][4];
		time = 600;
	}
	
	/**
	 * fills the vending machine with dispensers
	 */
	public void fillDispenser(Dispenser aDispenser, int row, int column)
	{
		this.emptyMachine[row][column] = aDispenser;
	}
	
	/**
	 * checks the vending machine
	 */
	public void readMachine()
	{
		String name = "";
		for (int row = 0; row < 5; row ++)
		{
			for (int column = 0; column < 4; column ++)
			{
				name = emptyMachine[row][column].getName();
				if (column == 3)
				{
					System.out.print(name);
				}
				else
				{
					System.out.print(name+", ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * sets the time for vending machines
	 */
	public void setTime(int aTime)
	{
		if (this.time + aTime > 2400)
		{
			int remainingTime = 2400 - this.time;
			aTime = aTime - remainingTime;
			this.time = 0000;
			this.time = aTime;
		}
		else
		{
			this.time = this.time + aTime;
		}
	}
	
	/**
	 * gets the time for vending machines
	 */
	public int getTime()
	{
		return this.time;
	}
}
