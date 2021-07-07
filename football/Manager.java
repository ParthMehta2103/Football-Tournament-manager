/**
 * Package containing 5 classes-ITournament,Manager,Member,Player,Team.
 */


package football;

/**
 * Manager class
 */

public class Manager extends Member{
	/**
	 * Experience of the manager.
	 */
	
	private int experience;
	
	/**
	 * Constructor to initialize the data members.
	 * @param age
	 * @param experience
	 */
	
	Manager(int age, int experience){
		super(age);
		this.experience = experience;
	}
	
	/**
	 * 
	 * @return The experience of the manager.
	 */
	
	public int getExperience() {
		return this.experience;
	}
}
