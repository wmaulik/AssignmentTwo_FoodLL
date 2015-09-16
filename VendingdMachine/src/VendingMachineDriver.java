/**
 * @author Writesh Maulik
 *
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class VendingMachineDriver
{
	
	private static final Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int time = 0;
		String location = "";
		double money = 0;
		boolean inValidPurchase = false;
		int startChoice = 0;
		boolean validStartChoice = false;
		int chooseMachine = 0;
		boolean keepOn = true;
		VendingMachine snackMachine = new VendingMachine();
		VendingMachine drinkMachine = new VendingMachine();
		
		do
		{
			System.out.println("What do you want to do?");
			System.out.println("1. Start Fresh.");
			System.out.println("2. Start from existing file.");
			System.out.println("3. Quit.");
			startChoice = keyboard.nextInt();
			keyboard.nextLine();
			
			switch (startChoice)
			{
				case 1:
				{
					validStartChoice = true;
					snackMachine = fillSnackMachine();
					drinkMachine = fillDrinkMachine();
					time = snackMachine.getTime();
					break;
				}
				case 2:
				{
					ObjectInputStream inputStream = null;
					try
					{
						inputStream = new ObjectInputStream(new FileInputStream
								("vendingMachine.records"));
					}
					catch(IOException e)
					{
						System.out.println("error openning vendingMachine.records");
					}
					snackMachine = null;
					drinkMachine = null;
					try
					{
						snackMachine = (VendingMachine) inputStream.readObject();
						drinkMachine = (VendingMachine) inputStream.readObject();
						inputStream.close();
					}
					catch (Exception e)
					{
						System.out.println("Error reading vendingMachine.records");
					}
					validStartChoice = true;
					break;
				}
				case 3:
				{
					validStartChoice = true;
					System.exit(0);
					break;
				}
				default:
				{
					System.out.println("Enter a valid item from the menu");
					break;
				}
			}
		}while (validStartChoice == false);
		
		while (keepOn == true)
		{
			chooseMachine = ((int) (Math.random()*2) + 1);
			if (chooseMachine == 1)
			{
				time = ((int) (Math.random() * 120) + 1);
				snackMachine.setTime(time);
				drinkMachine.setTime(time);
				System.out.println("You arrive at the snack vending machine at "
						+ snackMachine.getTime() + " hours.");
				System.out.println("This is what the vending Machine offers:");
				snackMachine.readMachine();
				System.out.println("Select which dispener to buy from.");
				location = keyboard.nextLine();
				System.out.println("This is what you have selected.");
				snackMachine.getInfo(location);
				do
				{
					System.out.println("Enter your money");
					money = keyboard.nextDouble();
					keyboard.nextLine();
					inValidPurchase = snackMachine.makePurchase(location, money);
				}while(inValidPurchase == true);
				VendingMachineDriver.turnOff(time, drinkMachine, snackMachine);
			}
			else
			{
				time = ((int) (Math.random() * 120) + 1);
				snackMachine.setTime(time);
				drinkMachine.setTime(time);
				System.out.println("You arrive at the drink vending machine at "
						+ drinkMachine.getTime() + " hours.");
				System.out.println("This is what the vending Machine offers:");
				drinkMachine.readMachine();
				System.out.println("Select which dispener to buy from.");
				location = keyboard.nextLine();
				System.out.println("This is what you have selected.");
				drinkMachine.getInfo(location);
				do
				{
					System.out.println("Enter your money");
					money = keyboard.nextDouble();
					keyboard.nextLine();
					inValidPurchase = drinkMachine.makePurchase(location, money);
				}while(inValidPurchase == true);
				VendingMachineDriver.turnOff(time, drinkMachine, snackMachine);
			}
		}		
	}
	
	/**
	 * fills the vending machine array with an assortment of dispenser objects
	 * all objects are foods
	 */
	public static VendingMachine fillSnackMachine()
	{
		VendingMachine emptyMachine = new VendingMachine();
		
		Dispenser pretzel = new Dispenser("Preztel", "salty", 1.95);
		emptyMachine.fillDispenser(pretzel, 0, 0);
		emptyMachine.fillDispenser(pretzel, 0, 1);
		Dispenser chip = new Dispenser("Chip", "spicy", 1.65);
		emptyMachine.fillDispenser(chip, 0, 2);
		emptyMachine.fillDispenser(chip, 0, 3);
		Dispenser cookie = new Dispenser("Cookie", "good job you earned this", 1.25);
		emptyMachine.fillDispenser(cookie, 1, 0);
		emptyMachine.fillDispenser(cookie, 1, 1);
		Dispenser cupcake = new Dispenser("Cup Cake", "sweet", 2.05);
		emptyMachine.fillDispenser(cupcake, 1, 2);
		emptyMachine.fillDispenser(cupcake, 1, 3);
		Dispenser cracker = new Dispenser("Cracker", "bland", .95);
		emptyMachine.fillDispenser(cracker, 2, 0);
		emptyMachine.fillDispenser(cracker, 2, 1);
		Dispenser cheesePuff = new Dispenser("Cheese Puff", "cheesy", 1.35);
		emptyMachine.fillDispenser(cheesePuff, 2, 2);
		emptyMachine.fillDispenser(cheesePuff, 2, 3);
		Dispenser sourGummy = new Dispenser("Sour Gummy", "really sour", 1.10);
		emptyMachine.fillDispenser(sourGummy, 3, 0);
		emptyMachine.fillDispenser(sourGummy, 3, 1);
		Dispenser chocolateBar = new Dispenser("Chocolate Bar", "rich and creamy", 1.50);
		emptyMachine.fillDispenser(chocolateBar, 3, 2);
		emptyMachine.fillDispenser(chocolateBar, 3, 3);
		Dispenser energyBar = new Dispenser("Energy Bar", "tastes awful", 2.25);
		emptyMachine.fillDispenser(energyBar, 4, 0);
		emptyMachine.fillDispenser(energyBar, 4, 1);
		Dispenser cereal = new Dispenser("Cereal", "don't skip breakfast", 1.75);
		emptyMachine.fillDispenser(cereal, 4, 2);
		emptyMachine.fillDispenser(cereal, 4, 3);
		
		return emptyMachine;
	}
	
	/**
	 * fills the vending machine array with an assortment of dispenser objects
	 * all objects are drinks
	 */
	public static VendingMachine fillDrinkMachine()
	{
		VendingMachine emptyMachine = new VendingMachine();
		
		Dispenser cola = new Dispenser("Cola", "tastes like soda", 1.35);
		emptyMachine.fillDispenser(cola, 0, 0);
		emptyMachine.fillDispenser(cola, 0, 1);
		Dispenser lemonSoda = new Dispenser("Lemon Soda", "lemons and bubbles", 1.35);
		emptyMachine.fillDispenser(lemonSoda, 0, 2);
		emptyMachine.fillDispenser(lemonSoda, 0, 3);
		Dispenser orangeSoda = new Dispenser("Orange Soda", "oranges and bubbles", 1.35);
		emptyMachine.fillDispenser(orangeSoda, 1, 0);
		emptyMachine.fillDispenser(orangeSoda, 1, 1);
		Dispenser rootBeer = new Dispenser("Root Beer", "it's good", 1.45);
		emptyMachine.fillDispenser(rootBeer, 1, 2);
		emptyMachine.fillDispenser(rootBeer, 1, 3);
		Dispenser orangeJuice = new Dispenser("Orange Juice", "healtier than soda", 1.65);
		emptyMachine.fillDispenser(orangeJuice, 2, 0);
		emptyMachine.fillDispenser(orangeJuice, 2, 1);
		Dispenser appleJuice = new Dispenser("Apple Juice", "better than orange juice", 1.65);
		emptyMachine.fillDispenser(appleJuice, 2, 2);
		emptyMachine.fillDispenser(appleJuice, 2, 3);
		Dispenser milk = new Dispenser("Milk", "for breakfast", 2.00);
		emptyMachine.fillDispenser(milk, 3, 0);
		emptyMachine.fillDispenser(milk, 3, 1);
		Dispenser chocolateMilk = new Dispenser("Chocolate milk", "milk but tasty", 2.50);
		emptyMachine.fillDispenser(chocolateMilk, 3, 2);
		emptyMachine.fillDispenser(chocolateMilk, 3, 3);
		Dispenser energyDrink = new Dispenser("Energy Drink", "electrolytes!", 2.25);
		emptyMachine.fillDispenser(energyDrink, 4, 0);
		emptyMachine.fillDispenser(energyDrink, 4, 1);
		Dispenser water = new Dispenser("Water", "it's water", 1.50);
		emptyMachine.fillDispenser(water, 4, 2);
		emptyMachine.fillDispenser(water, 4, 3);
		
		return emptyMachine;
	}
	
	/**
	 * turns off machine for idling
	 */
	public static void turnOff(int time, VendingMachine drinkMachine, 
			VendingMachine snackMachine )
	{
		ObjectOutputStream outputStream = null;
		
		if (time > 60)
		{
			System.out.println("This machine has idled for " + time + " minutes.");
			System.out.println("It is turning off.");
			try
			{
				outputStream = new ObjectOutputStream(
						new FileOutputStream("vendingMachine.records"));
			}
			catch (IOException e)
			{
				System.out.println("Error openning " + "vendingMachine.records");
			}
			try
			{
				outputStream.writeObject(snackMachine);
				outputStream.writeObject(drinkMachine);
				System.out.println("records saved as " + "vendingMachine.records");
				outputStream.close();
			}
			catch(IOException e)
			{
				System.out.println("error writing to " + "vendingMachine.records");
			}
			System.exit(0);
		}
	}
}
