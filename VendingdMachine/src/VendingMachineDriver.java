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
		//VendingMachine drinkMachine = new VendingMachine();
		
		Dispenser Pretzel = new Dispenser("Preztel", "fatty", 0.95);
		snackMachine.fillDispenser(Pretzel, 0, 0);
		snackMachine.fillDispenser(Pretzel, 0, 1);
		Dispenser Chip = new Dispenser("Chip", "really fatty", 0.65);
		snackMachine.fillDispenser(Chip, 0, 2);
		snackMachine.fillDispenser(Chip, 0, 3);
		snackMachine.fillDispenser(Pretzel, 1, 0);
		snackMachine.fillDispenser(Pretzel, 1, 1);
		snackMachine.fillDispenser(Chip, 1, 2);
		snackMachine.fillDispenser(Chip, 1, 3);
		snackMachine.readMachine();
	}
}
