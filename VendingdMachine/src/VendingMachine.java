/**
 * @author Writesh Maulik
 *
 */


public class VendingMachine 
{	
	private Dispenser [][] emptyMachine;
	private String location;
	private int time;
	
	public VendingMachine() 
	{
		// TODO Auto-generated constructor stub
		emptyMachine = new Dispenser [5][4];
		location = "";
		time = 600;
	}
	
	/**
	 * fills the vending machine with dispensers
	 */
	public void fillDispenser(Dispenser aDispenser, int row, int column)
	{
		this.emptyMachine[row][column] = aDispenser;
		this.fillLocation(row, column);
	}
	
	/**
	 * sets the location
	 */
	public void fillLocation(int row, int column)
	{
		String aLocation = "";
		if (row == 0)
		{
			aLocation = "A" + (column + 1);
		}
		else if (row == 1)
		{
			aLocation = "B" + (column + 1);
		}
		else if (row == 2)
		{
			aLocation = "C" + (column + 1);
		}
		else if (row == 3)
		{
			aLocation = "D" + (column + 1);
		}
		else
		{
			aLocation = "E" + (column + 1);
		}
		
		this.location = aLocation;
	}
	
	/**
	 * returns the location of a dispenser
	 */
	public String getLocation(int row, int column)
	{
		String location = "";
		if (row == 0)
		{
			location = "A" + (column + 1);
		}
		else if (row == 1)
		{
			location = "B" + (column + 1);
		}
		else if (row == 2)
		{
			location = "C" + (column + 1);
		}
		else if (row == 3)
		{
			location = "D" + (column + 1);
		}
		else
		{
			location = "E" + (column + 1);
		}
		return location;
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
					System.out.print(this.getLocation(row, column) + "-" +
							name);
				}
				else
				{
					System.out.print(this.getLocation(row, column) + "-" +
							name+", ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * checks to see if the location entered by the user is valid
	 * 
	 */
	public boolean validLocation(String location)
	{
		boolean valid = false;
		for (int row = 0; row < 5; row ++)
		{
			for (int column = 0; column < 4; column ++)
			{
				if (location.equals(this.location))
				{
					valid = true;
				}
			}
		}
		return valid;
	}
	
	/**
	 * invokes toString for the dispenser
	 */
	public void getInfo(String location)
	{
		String rowName = location.substring(0,1);
		int row = 0;
		if (rowName.equalsIgnoreCase("a"))
		{
			row = 0;
		}
		else if (rowName.equalsIgnoreCase("b"))
		{
			row = 1;
		}
		else if (rowName.equalsIgnoreCase("c"))
		{
			row = 2;
		}
		else if (rowName.equalsIgnoreCase("d"))
		{
			row = 3;
		}
		else
		{
			row = 4;
		}
		
		int column = 0;
		String columnName = "";
		columnName = location.substring(1);
		column = Integer.parseInt(columnName);
		System.out.println(this.emptyMachine[row][column]);
	}
	
	/**
	 * lets you make purchases
	 */
	public boolean makePurchase(String location, double money)
	{
		double price = 0;
		String rowName = location.substring(0,1);
		int row = 0;
		boolean inValidPurchase = false;
		if (rowName.equalsIgnoreCase("a"))
		{
			row = 0;
		}
		else if (rowName.equalsIgnoreCase("b"))
		{
			row = 1;
		}
		else if (rowName.equalsIgnoreCase("c"))
		{
			row = 2;
		}
		else if (rowName.equalsIgnoreCase("d"))
		{
			row = 3;
		}
		else if (rowName.equalsIgnoreCase("e"))
		{
			row = 4;
		}
		
		int column = 0;
		String columnName = "";
		columnName = location.substring(1);
		column = Integer.parseInt(columnName);
		price = this.emptyMachine[row][column].getPrice();
		try
		{
			if ((money - price) < 0)
			{
				throw new Exception("not enough money");
			}
			this.emptyMachine[row][column].setQuantity(
					this.emptyMachine[row][column].getQuanitity() - 1);
			System.out.println("you have bought " +
					this.emptyMachine[row][column].getName());
			System.out.printf("you paid %.2f%n", money);
			money = money - price;
			System.out.printf("your change is $ %.2f%n", money);
		}
		catch (Exception notEnoughMoney)
		{
			inValidPurchase = true;
			System.out.println(notEnoughMoney.getMessage());
		}
		return inValidPurchase;
	}
	
	/**
	 * sets the time for vending machines
	 */
	public void setTime(int aTime)
	{
		int hour;
		int minutes;
		minutes = aTime % 60;
		hour = (aTime / 60) * 100;
		aTime = hour + minutes;
		
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
			minutes = this.time % 60;
			hour = (aTime / 60) * 100;
			this.time = hour + minutes;
		}
	}
	
	/**
	 * gets the time for vending machines
	 */
	public int getTime()
	{
		return this.time;
	}
	
	/**
	 * turns of machine for idling
	 */
	public boolean turnOff(int time)
	{
		boolean keepOn = true;
		if (time > 60)
		{
			System.out.println("This machine has idled for " + time);
			System.out.println("It is turning off.");
			keepOn = false;
			System.exit(0);
		}
		return keepOn;
	}
}
