/**
 * Package containing 5 classes-ITournament,Manager,Member,Player,Team.
 */


package football;

/**
 * Player class.
 */

public class Player extends Member{
	
	/**
	 * Current fitness state of the player.
	 */
	
	private boolean isFit;
	
	/**
	 * Rating of the player.
	 */
	private int rating;
	
	/**
	 * Player constructor that initializes the data members.
	 * @param age
	 * @param isFit
	 * @param rating
	 */
	
	Player(int age, boolean isFit, int rating){
		super(age);
		this.isFit = isFit;
		this.rating = rating;
	}
	
	/**
	 * 
	 * @return The current fitness state of the player.
	 */
	
	public boolean getFitnessState() {
		return this.isFit;
	}
	
	/**
	 * 
	 * @return The rating of the player.
	 */
	
	public int getRating() {
		return this.rating;
	}	
}
