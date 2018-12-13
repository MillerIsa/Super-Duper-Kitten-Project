/**
 * project list class
 * Authors: Logan Jenny, Rich Williams, Jake Owens, Isaiah Miller
 * version 1.0
 * 12/2018
 */
package application;

import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class ProjectList{
	/**
	 * myProjects
	 */
	public ObservableList<project> myProjects;

	/**
	 *  constructs a list of all the projects
	 */
	public ProjectList(){
		//look at picture to find the outline for this class...
		super();
		myProjects =FXCollections.observableArrayList (
		(new AppliancesProject()),
		(new LightBulbProject()),
		(new HeatProject()),
		(new WindowsDoorsProject()),
		(new InsulationProject()),
		(new IrrigationProject()),
		(new SolarProject()),
		(new ThermostatProject())
		);
	}
	
	
	/**
	 * returns a list of projects
	 * @return list of projects
	 */
	public ObservableList<project> getPros() {
		return this.myProjects;
	}
	
	
	
	/**
	 * sorts by cost
	 */
	public void sortCost() {
		Collections.sort(myProjects, new SortbyCost());
		
	}
	
	/**
	 * sorts by difficulty
	 */
	public void sortDifficulty() {
		Collections.sort(myProjects,  new SortbyDifficulty());
	}
	
	/**
	 * sorts by energy savings
	 */
	public void sortEnergySavings() {
		Collections.sort(myProjects, new SortbyEnergySavings());
	}
	
	
	/**
	 * Inner class for sorting by project Energy Savings.
	 */
	class SortbyEnergySavings implements Comparator<project> {
		public int compare(project a, project b) {
			return b.getSavings() - a.getSavings();
		}
	}
	
	
	/**
	 * Inner class for sorting by project difficulty.
	 * @author richw253
	 */
	class SortbyDifficulty implements Comparator<project> {
		public int compare(project a, project b) {
			return a.getDifficulty() - b.getDifficulty();
		}
	}
	
	
	/**
	 * Inner class for sorting by project cost.
	 * @author richw253
	 *
	 */
	class SortbyCost implements Comparator<project> {
		public int compare(project a, project b) {
			return a.getCost() - b.getCost();
		}
	}
	
	
	
}
