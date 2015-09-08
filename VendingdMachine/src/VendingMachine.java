/**
 * @author Writesh Maulik
 *
 */

public class VendingMachine
{	
	private Dispenser [][] emptyMachine;
	
	public VendingMachine() 
	{
		// TODO Auto-generated constructor stub
		emptyMachine = new Dispenser [5][4];
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
}
