/**
 * Home class
 * Authors: Logan Jenny, Rich Williams, Jake Owens, Isaiah Miller
 * version 1.0
 * 12/2018
 */
package application;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Random;


/**
 * Date: 10/20/18
 * Editor: Isaiah Miller
 *
 */
public class Home extends AbstractExportable {
	/**
	 * HOME_PATH
	 */
	public static final String HOME_PATH = "save" + File.separatorChar + "home.json";

	/** Costs of the home fields. */
	/**
	 * myElectricBill
	 */
	float myElectricBill; 
	/**
	 * myGasBill
	 */
	float myGasBill; 
	/**
	 * myWaterBill
	 */
	float myWaterBill;

	/** Heating and cooling fields. */
	/**
	 * myMainHeatGas
	 */
	boolean myMainHeatGas; // EnergyStar gas furnace will save $75 per year
	/**
	 * myMainHeatElect
	 */
	boolean myMainHeatElect;
	/**
	 * myMainHeatRadiant
	 */
	boolean myMainHeatRadiant;
	/**
	 * myFurnanceMultStage
	 */
	boolean myFurnanceMultStage;
	/**
	 * myHouseFan
	 */
	boolean myHouseFan;
	/**
	 * myProgThermostat
	 */
	boolean myProgThermostat;

	/** Water Heater fields. * */
	/**
	 * myGasWaterHeater
	 */
	boolean myGasWaterHeater;
	/**
	 * myElectWaterHeat
	 */
	boolean myElectWaterHeat;
	/**
	 * myOnDemand
	 */
	boolean myOnDemand;
	/**
	 * myWaterHeaterAge
	 */
	int myWaterHeaterAge; //

	/** Lights within the home field. */
	/**
	 * myTotalLight
	 */
	int myTotalLight;
	/**
	 * myIncandLight
	 */
	boolean myIncandLight;
	/**
	 * myLEDLight
	 */
	boolean myLEDLight;
	/**
	 * myHalLight
	 */
	boolean myHalLight;
	/**
	 * myFlorLight
	 */
	boolean myFlorLight;

	/** Electricity usage field. */
	/**
	 * mySolarPanel
	 */
	boolean mySolarPanel; //

	/** Windows and Door fields. */
	/**
	 * myWeatherProofedDoor
	 */
	boolean myWeatherProofedDoor;
	/**
	 * myNumWindow
	 */
	int myNumWindow;
	/**
	 * myNumWindowBad
	 */
	int myNumWindowBad;
	/**
	 * myNumWindowLowE
	 */
	int myNumWindowLowE; //

	/** Insulations information fields. */
	/**
	 * myInsulationWall
	 */
	boolean myInsulationWall;
	/**
	 * myInsulationCeiling
	 */
	boolean myInsulationCeiling;
	/**
	 * myInsulationFloor
	 */
	boolean myInsulationFloor;

	/** Irrigation fields. */
	/**
	 * myIrrigation
	 */
	boolean myIrrigation; //
	/**
	 * myIrrigationSensor
	 */
	boolean myIrrigationSensor;

	/** Appliance fields. */
	/**
	 * myEStarRefrig
	 */
	boolean myEStarRefrig;
	/**
	 * myEStarDishWash
	 */
	boolean myEStarDishWash; // $35 per year to run. 250 gal. water saved per year
	/**
	 * myEStarClothWash
	 */
	boolean myEStarClothWash;
	/**
	 * myEStarDryer
	 */
	boolean myEStarDryer;


	/**
	 * Home Constructor
	 */
	public Home() {
	    myMainHeatElect = true;
	    myFurnanceMultStage = true;
	    myProgThermostat = true;
	    myOnDemand = true;
	    myHalLight = true;
	    myTotalLight = 13;
	    myNumWindow = 8;
	    myNumWindowBad = 8;
	    myInsulationCeiling = true;
	    myEStarRefrig = true;
	    myIrrigation = true;

	}

	
	/**
	 * This method produceds a home with random values and exports it to a default save file.
	 * @author Isaiah Miller
	 * @param isDefault this paramater is ignored. 
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Home(final boolean isDefault) throws IllegalArgumentException, IllegalAccessException {
		
		final Field[] fields = this.getClass().getDeclaredFields();
		//final Class<Boolean> boolClass = Boolean.TYPE;     //dunno why this is here.. Isaiah...
		final int spreadRandInt = 10000;
		final int spreadRandFloat = 10000;
		for(Field field: fields) {
			final Random rand = new Random();
			//System.out.println(field.getType());
			if(field.getType().equals(Boolean.TYPE)) {
				field.set(this, rand.nextBoolean());
			} else if (field.getType().equals(Integer.TYPE)) {
				field.set(this, rand.nextInt(spreadRandInt));
			} else if(field.getType().equals(Float.TYPE)) {
				field.set(this, rand.nextFloat() * spreadRandFloat);
			} 
			}
//		File test = new File("");
//		
//		System.out.println("path is: " + test.getAbsolutePath());
		exportJSON(new File("src" + File.separatorChar + "application" + File.separatorChar + "save" + File.separatorChar + "homeDefault.json"));
		
	}
	
	/**
	 * @return electric bill
	 */
	public float getMyElectricBill() {
		return myElectricBill;
	}


	/**
	 * @param theElectricBill
	 */
	public void setMyElectricBill(float theElectricBill) {
		this.myElectricBill = theElectricBill;
	}

	/**
	 * @return gas bill
	 */
	public float getMyGasBill() {
		return myGasBill;
	}

	/**
	 * @param myGasBill
	 */
	public void setMyGasBill(float myGasBill) {
		this.myGasBill = myGasBill;
	}

	/**
	 * @return water bill
	 */
	public float getMyWaterBill() {
		return myWaterBill;
	}

	/**
	 * @param myWaterBill
	 */
	public void setMyWaterBill(float myWaterBill) {
		this.myWaterBill = myWaterBill;
	}

	/**
	 * @return gas heat bool
	 */
	public boolean isMyMainHeatGas() {
		return myMainHeatGas;
	}

	/**
	 * @param myMainHeatGas
	 */
	public void setMyMainHeatGas(boolean myMainHeatGas) {
		this.myMainHeatGas = myMainHeatGas;
	}

	/**
	 * @return electric heat bool
	 */
	public boolean isMyMainHeatElect() {
		return myMainHeatElect;
	}

	/**
	 * @param myMainHeatElect
	 */
	public void setMyMainHeatElect(boolean myMainHeatElect) {
		this.myMainHeatElect = myMainHeatElect;
	}

	/**
	 * @return rad heat bool
	 */
	public boolean isMyMainHeatRadiant() {
		return myMainHeatRadiant;
	}

	/**
	 * @param myMainHeatRadiant
	 */
	public void setMyMainHeatRadiant(boolean myMainHeatRadiant) {
		this.myMainHeatRadiant = myMainHeatRadiant;
	}

	/**
	 * @return furnance mult bool
	 */
	public boolean isMyFurnanceMultStage() {
		return myFurnanceMultStage;
	}

	/**
	 * @param myFurnanceMultStage
	 */
	public void setMyFurnanceMultStage(boolean myFurnanceMultStage) {
		this.myFurnanceMultStage = myFurnanceMultStage;
	}

	/**
	 * @return house fan bool
	 */
	public boolean isMyHouseFan() {
		return myHouseFan;
	}

	/**
	 * @param myHouseFan
	 */
	public void setMyHouseFan(boolean myHouseFan) {
		this.myHouseFan = myHouseFan;
	}

	/**
	 * @return prog thermostat bool
	 */
	public boolean isMyProgThermostat() {
		return myProgThermostat;
	}

	/**
	 * @param myProgThermostat
	 */
	public void setMyProgThermostat(boolean myProgThermostat) {
		this.myProgThermostat = myProgThermostat;
	}

	/**
	 * @return gas water bool
	 */
	public boolean isMyGasWaterHeater() {
		return myGasWaterHeater;
	}

	/**
	 * @param myGasWaterHeater
	 */
	public void setMyGasWaterHeater(boolean myGasWaterHeater) {
		this.myGasWaterHeater = myGasWaterHeater;
	}

	/**
	 * @return electric water heat bool
	 */
	public boolean isMyElectWaterHeat() {
		return myElectWaterHeat;
	}

	/**
	 * @param myElectWaterHeat
	 */
	public void setMyElectWaterHeat(boolean myElectWaterHeat) {
		this.myElectWaterHeat = myElectWaterHeat;
	}

	/**
	 * @return on demand water bool
	 */
	public boolean isMyOnDemand() {
		return myOnDemand;
	}

	/**
	 * @param myOnDemand
	 */
	public void setMyOnDemand(boolean myOnDemand) {
		this.myOnDemand = myOnDemand;
	}

	/**
	 * @return water heater age int
	 */
	public int getMyWaterHeaterAge() {
		return myWaterHeaterAge;
	}

	/**
	 * @param myWaterHeaterAge
	 */
	public void setMyWaterHeaterAge(int myWaterHeaterAge) {
		this.myWaterHeaterAge = myWaterHeaterAge;
	}

	/**
	 * @return total lights int
	 */
	public int getMyTotalLight() {
		return myTotalLight;
	}

	/**
	 * @param myTotalLight
	 */
	public void setMyTotalLight(int myTotalLight) {
		this.myTotalLight = myTotalLight;
	}

	/**
	 * @return inc lights bool
	 */
	public boolean getMyIncandLight() {
		return myIncandLight;
	}

	/**
	 * @param myIncandLight
	 */
	public void setMyIncandLight(boolean myIncandLight) {
		this.myIncandLight = myIncandLight;
	}

	/**
	 * @return led lights bool
	 */
	public boolean getMyLEDLight() {
		return myLEDLight;
	}

	/**
	 * @param myLEDLight
	 */
	public void setMyLEDLight(boolean myLEDLight) {
		this.myLEDLight = myLEDLight;
	}

	/**
	 * @return hal lights bool
	 */
	public boolean getMyHalLight() {
		return myHalLight;
	}

	/**
	 * @param myHalLight
	 */
	public void setMyHalLight(boolean myHalLight) {
		this.myHalLight = myHalLight;
	}

	/**
	 * @return flor lights bool
	 */
	public boolean getMyFlorLight() {
		return myFlorLight;
	}

	/**
	 * @param myFlorLight
	 */
	public void setMyFlorLight(boolean myFlorLight) {
		this.myFlorLight = myFlorLight;
	}

	/**
	 * @return solar panel bool
	 */
	public boolean isMySolarPanel() {
		return mySolarPanel;
	}

	/**
	 * @param mySolarPanel
	 */
	public void setMySolarPanel(boolean mySolarPanel) {
		this.mySolarPanel = mySolarPanel;
	}

	/**
	 * @return good door bool
	 */
	public boolean getMyWeatherProofedDoor() {
		return myWeatherProofedDoor;
	}

	/**
	 * @param myWeatherProofedDoor
	 */
	public void setMyWeatherProofedDoor(boolean myWeatherProofedDoor) {
		this.myWeatherProofedDoor = myWeatherProofedDoor;
	}

	/**
	 * @return windows int
	 */
	public int getMyNumWindow() {
		return myNumWindow;
	}

	/**
	 * @param myNumWindow
	 */
	public void setMyNumWindow(int myNumWindow) {
		this.myNumWindow = myNumWindow;
	}

	/**
	 * @return bad windows int
	 */
	public int getMyNumWindowBad() {
		return myNumWindowBad;
	}

	/**
	 * @param myNumWindowBad
	 */
	public void setMyNumWindowBad(int myNumWindowBad) {
		this.myNumWindowBad = myNumWindowBad;
	}

	/**
	 * @return low e windows int
	 */
	public int getMyNumWindowLowE() {
		return myNumWindowLowE;
	}

	/**
	 * @param myNumWindowLowE
	 */
	public void setMyNumWindowLowE(int myNumWindowLowE) {
		this.myNumWindowLowE = myNumWindowLowE;
	}

	/**
	 * @return wall insulation bool
	 */
	public boolean isMyInsulationWall() {
		return myInsulationWall;
	}

	/**
	 * @param myInsulationWall
	 */
	public void setMyInsulationWall(boolean myInsulationWall) {
		this.myInsulationWall = myInsulationWall;
	}

	/**
	 * @return ceiling insulation bool
	 */
	public boolean isMyInsulationCeiling() {
		return myInsulationCeiling;
	}

	/**
	 * @param myInsulationCeiling
	 */
	public void setMyInsulationCeiling(boolean myInsulationCeiling) {
		this.myInsulationCeiling = myInsulationCeiling;
	}

	/**
	 * @return floor insulation bool
	 */
	public boolean isMyInsulationFloor() {
		return myInsulationFloor;
	}

	/**
	 * @param myInsulationFloor
	 */
	public void setMyInsulationFloor(boolean myInsulationFloor) {
		this.myInsulationFloor = myInsulationFloor;
	}

	/**
	 * @return irrigation bool
	 */
	public boolean isMyIrrigation() {
		return myIrrigation;
	}

	/**
	 * @param myIrrigation
	 */
	public void setMyIrrigation(boolean myIrrigation) {
		this.myIrrigation = myIrrigation;
	}

	/**
	 * @return irrigation sensor bool
	 */
	public boolean isMyIrrigationSensor() {
		return myIrrigationSensor;
	}

	/**
	 * @param myIrrigationSensor
	 */
	public void setMyIrrigationSensor(boolean myIrrigationSensor) {
		this.myIrrigationSensor = myIrrigationSensor;
	}

	/**
	 * @return estar frig bool
	 */
	public boolean isMyEStarRefrig() {
		return myEStarRefrig;
	}

	/**
	 * @param myEStarRefrig
	 */
	public void setMyEStarRefrig(boolean myEStarRefrig) {
		this.myEStarRefrig = myEStarRefrig;
	}

	/**
	 * @return dish bool
	 */
	public boolean isMyEStarDishWash() {
		return myEStarDishWash;
	}

	/**
	 * @param myEStarDishWash
	 */
	public void setMyEStarDishWash(boolean myEStarDishWash) {
		this.myEStarDishWash = myEStarDishWash;
	}

	/**
	 * @return washer bool
	 */
	public boolean isMyEStarClothWash() {
		return myEStarClothWash;
	}

	/**
	 * @param myEStarClothWash
	 */
	public void setMyEStarClothWash(boolean myEStarClothWash) {
		this.myEStarClothWash = myEStarClothWash;
	}

	/**
	 * @return dryer bool
	 */
	public boolean isMyEStarDryer() {
		return myEStarDryer;
	}

	/**
	 * @param myEStarDryer
	 */
	public void setMyEStarDryer(boolean myEStarDryer) {
		this.myEStarDryer = myEStarDryer;
	}

	@Override
	public String toString() {
		final StringBuilder res = new StringBuilder(100);
		res.append("myNum Window is: " + myNumWindow);
		return res.toString();
	}

}
