/**
 * @author Writesh Maulik
 *
 */

public class VendingMachineDriver 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		VendingMachine snackMachine = new VendingMachine();
		VendingMachine drinkMachine = new VendingMachine();
		
		Dispenser Pretzel = new Dispenser("Preztel", "fatty", 0.95, "A1");
		snackMachine.fillDispenser(Pretzel, 0, 0);
		snackMachine.fillDispenser(Pretzel, 0, 1);
		snackMachine.readMachine();

	}
}
