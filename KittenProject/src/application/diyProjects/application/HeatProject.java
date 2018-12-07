package application;

/**
 * Heating project
 * @author richw253
 * @version Dec 6
 */
public class HeatProject extends project {
	
	/** Price of EStar Gas Water Heater. */
	private static final int GAS_WATER_HEATER_COST = 900;
	
	/** Price of EStar High Efficiency Gas Furnace. */
	private static final int GAS_FURNACE_COST = 6000;
	
	/** Price of On-demand system. */
	private static final int ONDEMAND_COST = 3000;
	
	/** Average annual cost of heating water with electric water heater. */
	private static final int ELECT_WATER_HEAT_ENERGY_COST = 437;
	
	/** Average annual cost of gas water heater. */
	private static final int GAS_WATER_HEAT_ENERGY_COST = 164;
	
	/** Average annual cost of heating space with gas. */
	private static final int GAS_SPACE_HEAT_ENERGY_COST = 547;
	
	/** Average annual cost of heating space with electricity. */
	private static final int ELECT_SPACE_HEAT_ENERGY_COST = 838;
	
	/** Average annual cost of gas water heat on demand (tankless). */
	private static final int GAS_WATER_HEAT_ONDEMAND_ENERGY_COST = 102;

	/** Heating and cooling fields. */
	boolean myMainHeatGas; 
	boolean myMainHeatElect;
	boolean myMainHeatRadiant;
	boolean myFurnanceMultStage;
	boolean myHouseFan;
	boolean myProgThermostat;

	/** Water Heater fields. * */
	boolean myGasWaterHeater;
	boolean myElectWaterHeat;
	boolean myOnDemand;
	int myWaterHeaterAge;


	public HeatProject() {
		super();
		
		name = "Heat";
		
		myMainHeatGas = theHome.isMyMainHeatGas();
		myMainHeatElect = theHome.isMyMainHeatElect();
		myMainHeatRadiant = theHome.isMyMainHeatRadiant();
		myFurnanceMultStage = theHome.isMyFurnanceMultStage();
		myHouseFan = theHome.isMyHouseFan();
		myProgThermostat = theHome.isMyProgThermostat();

		/** Water Heater fields. * */
		myGasWaterHeater = theHome.isMyGasWaterHeater();
		myElectWaterHeat = theHome.isMyElectWaterHeat();
		myOnDemand = theHome.isMyOnDemand();
		myWaterHeaterAge = theHome.getMyWaterHeaterAge();
		
		description = "Maybe its time to upgrade the ol' costly bundle of sticks you've been using for heat "
				+ "\nUpgrade your water heater from electric to EStar gas, or better yet install an on-demand "
				+ "gas water heating system.  You can also upgrade that electric baseboard to a gas forced air.";
		difficulty = 7;
		cost = calculateCost();
		savings = calculateSavings();

	}

	private int calculateSavings() {
		int savings = 0;
		
		// getting a gas furnace;
		if (myMainHeatElect) {
			savings += (ELECT_SPACE_HEAT_ENERGY_COST - GAS_SPACE_HEAT_ENERGY_COST);
		}
		// getting a gas water heater
		if (myElectWaterHeat) {
			savings += (ELECT_WATER_HEAT_ENERGY_COST - GAS_WATER_HEAT_ENERGY_COST);
		}
		// getting an ondemand system
		if (myGasWaterHeater) {
			savings += (GAS_WATER_HEAT_ENERGY_COST - GAS_WATER_HEAT_ONDEMAND_ENERGY_COST);
		}
		return savings;
	}

	private int calculateCost() {
		
		int cost = 0;
		if (myMainHeatElect) {
			cost += GAS_WATER_HEATER_COST;
		}
		if (myMainHeatElect) {
			cost += GAS_FURNACE_COST;
		}
		if (myGasWaterHeater) {
			cost += ONDEMAND_COST;
		}
		return cost;
	}

	public boolean isMyMainHeatGas() {
		return myMainHeatGas;
	}

	public void setMyMainHeatGas(boolean myMainHeatGas) {
		this.myMainHeatGas = myMainHeatGas;
	}

	public boolean isMyMainHeatElect() {
		return myMainHeatElect;
	}

	public void setMyMainHeatElect(boolean myMainHeatElect) {
		this.myMainHeatElect = myMainHeatElect;
	}

	public boolean isMyMainHeatRadiant() {
		return myMainHeatRadiant;
	}

	public void setMyMainHeatRadiant(boolean myMainHeatRadiant) {
		this.myMainHeatRadiant = myMainHeatRadiant;
	}

	public boolean isMyFurnanceMultStage() {
		return myFurnanceMultStage;
	}

	public void setMyFurnanceMultStage(boolean myFurnanceMultStage) {
		this.myFurnanceMultStage = myFurnanceMultStage;
	}

	public boolean isMyHouseFan() {
		return myHouseFan;
	}

	public void setMyHouseFan(boolean myHouseFan) {
		this.myHouseFan = myHouseFan;
	}

	public boolean isMyProgThermostat() {
		return myProgThermostat;
	}

	public void setMyProgThermostat(boolean myProgThermostat) {
		this.myProgThermostat = myProgThermostat;
	}

	public boolean isMyGasWaterHeater() {
		return myGasWaterHeater;
	}

	public void setMyGasWaterHeater(boolean myGasWaterHeater) {
		this.myGasWaterHeater = myGasWaterHeater;
	}

	public boolean isMyElectWaterHeat() {
		return myElectWaterHeat;
	}

	public void setMyElectWaterHeat(boolean myElectWaterHeat) {
		this.myElectWaterHeat = myElectWaterHeat;
	}

	public boolean isMyOnDemand() {
		return myOnDemand;
	}

	public void setMyOnDemand(boolean myOnDemand) {
		this.myOnDemand = myOnDemand;
	}

	public int getMyWaterHeaterAge() {
		return myWaterHeaterAge;
	}

	public void setMyWaterHeaterAge(int myWaterHeaterAge) {
		this.myWaterHeaterAge = myWaterHeaterAge;
	}
	
	
	
}
