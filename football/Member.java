/**
 * Package containing 5 classes-ITournament,Manager,Member,Player,Team.
 */


package football;

/**
 * Member class.
 */

public abstract class Member {
	
	/**
	 * Age of the member. 
	 */
	protected int age;
	
	/**
	 * Member constructor that initializes data member.
	 */
	
	Member(int age){
		this.age = age;
	}
	
	/**
	 * 
	 * @return The age of the team member. 
	 */
	
	public int getAge() {
		return this.age;
	}
}
