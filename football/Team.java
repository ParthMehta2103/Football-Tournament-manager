/**
 * Package containing 5 classes-ITournament,Manager,Member,Player,Team.
 */


package football;

/**
 *Team class.
 */

public class Team {
	
	/**
	 * Unique ID of the team.
	 */
	
	private int teamID;
	
	/**
	 * Name of the team.
	 */
	
	private String teamName;
	
	/**
	 * Number of players currently part of the team.
	 */
	
	private int numberOfPlayers;
	
	/**
	 * Array of Players of the team.
	 */
	
	private Player[] teamPlayersArray;
	
	/**
	 * Maximum number of players which a team can have. Initialize it to 5.
	 */
	
	private static final int MAX_PLAYERS = 5;

	/**
	 * Manager of the team.
	 */
	
	private Manager teamManager;
	
	/**
	 * Team constructor to initialise all data members.
	 * @param teamID
	 * @param teamName
	 * @param managerAge
	 * @param managerExperience
	 */
	
	public Team(int teamID, String teamName, int managerAge, int managerExperience) {
		this.teamID = teamID;
		this.teamName = teamName;
		
		this.numberOfPlayers = 0;
		this.teamPlayersArray = new Player[Team.MAX_PLAYERS];
		
		this.teamManager = new Manager(managerAge, managerExperience);
		
	}
	
	/**
	 * 
	 * @return ID of the team.
	 */
	
	public int getTeamID() {
		return this.teamID;
	}
	
	/**
	 * 
	 * @return The team name.
	 */
	
	public String getTeamName() {
		return this.teamName;
	}
	
	/**
	 * 
	 * @return The number of players currently part of the team.
	 */
	
	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}
	
	/**
	 * 
	 * @return The array of Players of the team.
	 */
	
	public Player[] getTeamPlayersArray() {
		return this.teamPlayersArray;
	}
	
	/**
	 * 
	 * @return  The Manager of the Team.
	 */
	
	public Manager getTeamManager() {
		return this.teamManager;
	}
	
	/**
	 *Add a player to the team.
	 *Players who are not fit are also added to the Team if possible. 
	 *A player cannot be added if the player slots are filled.
	 * @return True if the Player is added to the Team successfully, false otherwise.
	 * @param age
	 * @param isFit
	 * @param rating
	 *
	 */
	
	public boolean addPlayer(int age, boolean isFit, int rating) {
		if(this.numberOfPlayers >= Team.MAX_PLAYERS) {
			return false;
		}
		this.teamPlayersArray[this.numberOfPlayers++] = new Player(age, isFit, rating);
		return true;
	}
	
	/**
	 * 
	 * @return The skill of the team, which is the sum of the ratings of the Players in the team added to twice the experience of the Manager.
	 */
	
	public int calculateTeamSkill() {
		int teamSkill;
		teamSkill = 2*this.teamManager.getExperience();
		for(int i = 0; i<this.numberOfPlayers; i++) {
			teamSkill += this.teamPlayersArray[i].getRating();
		}
		return teamSkill;
	}
	
	/**
	 * The team is valid if all of the following are satisfied:
	 *  1. The number of players are exactly equal to the Maximum number of players which a team can have. 
	 *  2. The experience of the manager is greater than or equal to minimumManagerExperience. 
	 *  3. All the players are fit. 
	 *  4. The age of each player is greater than or equal to minimumPlayerAge. 
	 * @param minimumPlayerAge
	 * @param minimumManagerExperience
	 * @return The validity of the team.
	 *  
	 */
	
	public boolean verifyTeamValidity(int minimumPlayerAge, int minimumManagerExperience) {
		if(this.numberOfPlayers != Team.MAX_PLAYERS) {
			return false;
		}
		if(this.teamManager.getExperience() < minimumManagerExperience) {
			return false;
		}
		for(int i = 0; i<this.numberOfPlayers; i++) {
			Player currentPlayer = this.teamPlayersArray[i];
			if(currentPlayer.getFitnessState()==false || currentPlayer.getAge() < minimumPlayerAge) {
				return false;
			}
		}
		return true;
	}
}