/** 
 * Package containing 2 classes-Event and FootballEvent.
 */


package eventmanagement;

import football.*;
import infrastructure.*;

/**
 * FootbalEvent class.
 */

public class FootballEvent extends Event implements ITournament{
	
	/**
	 * The number of teams currently enrolled for the event.
	 */
	private int numberOfTeamsEnrolled;
	/**
	 * An array of teams currently enrolled in the event.
	 */
	private Team[] teamsEnrolledArray;
	/**
	 * An array of points corresponding to the teamsEnrolledArray.
	 */
	private int[] pointsArray;
	/**
	 * The number of stadiums currently associated with the event.
	 */
	private int numberOfStadiums;
	/**
	 * The maximum number of stadiums that can be associated with the event. The value is 4.
	 */
	private static final int MAX_NUMBER_OF_STADIUMS = 4;
	/**
	 * An array of stadiums currently associated with the event.
	 */
	private Stadium[] stadiumsArray;
	/**
	 * Minimum age of players who can take part in this event/tournament.
	 */
	
	private int minimumPlayerAge;
	/**
	 * Minimum experience which a manager needs to have in order to take part in this event/tournament.
	 */
	private int minimumManagerExperience;
	
	/**
	 * Initialize the data members.
	 * @param amountInvestedOnEvent 
	 * @param sponsorshipAmount
	 */
	
	public FootballEvent(int amountInvestedOnEvent, int sponsorshipAmount, int minimumPlayerAge, int minimumManagerExperience) {
		super(amountInvestedOnEvent, sponsorshipAmount);
		
		this.numberOfTeamsEnrolled = 0;
		this.teamsEnrolledArray = new Team[NUMBER_OF_TEAMS];
		this.pointsArray = new int[NUMBER_OF_TEAMS];
		
		this.numberOfStadiums = 0;
		this.stadiumsArray = new Stadium[FootballEvent.MAX_NUMBER_OF_STADIUMS];
		
		this.minimumPlayerAge = minimumPlayerAge;
		this.minimumManagerExperience = minimumManagerExperience;
	}
	
	/**
	 * 
	 * @return The number of teams currently enrolled for the event.
	 */
	
	public int getNumberOfTeamsEnrolled() {
		return this.numberOfTeamsEnrolled;
	}
	
	/**
	 * 
	 * @return The array of teams currently enrolled in the event.
	 */
	
	public Team[] getTeamsEnrolledArray() {
		return this.teamsEnrolledArray;
	}
	
	/**
	 * 
	 * @return The number of stadiums currently associated with the event.
	 */
	
	public int getNumberOfStadiums() {
		return this.numberOfStadiums;
	}
	
	/**
	 * @return The array of stadiums currently associated with the event.
	 */
	
	public Stadium[] getStadiumsArray() {
		return this.stadiumsArray;
	}
	
	/**
	 * 
	 * @return The minimum age of players who can take part in this event/tournament.
	 */
	
	public int getMinimumPlayerAge() {
		return this.minimumPlayerAge;
	}
	
	/**
	 * 
	 * @return The minimum experience which a manager needs to have in order to take part in this event/tournament.
	 */
	
	public int getMinimumManagerExperience() {
		return this.minimumManagerExperience;
	}
	/**
	 * 
	 * @param teamID
	 * @param teamName
	 * @param managerAge
	 * @param managerExperience
	 * @return False if the team cannot be added to this event - i.e., only when there are no free slots left in this event,true if the team is added to the event.
	 */
	
	public boolean addEmptyTeam(int teamID, String teamName, int managerAge, int managerExperience) {
		if(this.numberOfTeamsEnrolled >= FootballEvent.NUMBER_OF_TEAMS) {
			return false;
		}
		Team newTeam = new Team(teamID, teamName, managerAge, managerExperience);
		this.teamsEnrolledArray[this.numberOfTeamsEnrolled++] = newTeam;
		return true;
	}
	
	/**
	 * 
	 * @param teamID
	 * @param age
	 * @param isFit
	 * @param rating
	 * @return False if the given team is not a part of the event, else, returns true or false depending on whether the player can be added to the team with the given teamID.
	 * No need to verify team validity here
	 */
	
	public boolean addPlayerToTeam(int teamID, int age, boolean isFit, int rating) {
		for(int i = 0; i<this.numberOfTeamsEnrolled; i++) {
			if(this.teamsEnrolledArray[i].getTeamID()==teamID) {
				return this.teamsEnrolledArray[i].addPlayer(age, isFit, rating);
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param stadiumID
	 * @param homeTeamName
	 * @return False if the stadium (with no stalls initially) cannot be added to this event - i.e., only when there are no free slots left in this event, true if the stadium is added to the event.
	 */
	
	public boolean addEmptyStadium(int stadiumID, String homeTeamName) {
		if(this.numberOfStadiums >= FootballEvent.MAX_NUMBER_OF_STADIUMS) {
			return false;
		}
		Stadium newStadium = new Stadium(stadiumID, homeTeamName);
		this.stadiumsArray[this.numberOfStadiums++] = newStadium;
		return true;
	}
	
	/**
	 * 
	 * @param stadiumID
	 * @param revenueGenerated
	 * @return False if the given stadium is not a part of the event, else, returns true or false depending on whether the stall can be added to the stadium with the given stadiumID.
	 */
	
	public boolean addStallToStadium(int stadiumID, int revenueGenerated) {
		for(int i = 0; i<this.numberOfStadiums; i++) {
			if(this.stadiumsArray[i].getStadiumID()==stadiumID) {
				return this.stadiumsArray[i].addStall(revenueGenerated);
			}
		}
		return false;
	}
	
	/**
	 * Tournament is valid if all of the following are satisfied:
	 * 1. number of teams enrolled should be equal to the number of teams which will participate in one tournament
	 * 2. there should be atleast one stadium associated with this event
	 * 3. all the teams enrolled should be valid
	 * @return True or false as per above conditions.
	 */
	
	public boolean verifyTournamentValidity() {
		if(this.numberOfTeamsEnrolled != NUMBER_OF_TEAMS) {
			return false;
		}
		if(this.numberOfStadiums == 0) {
			return false;
		}
		for(int i = 0; i<this.numberOfTeamsEnrolled; i++) {
			if(this.teamsEnrolledArray[i].verifyTeamValidity(minimumPlayerAge, minimumManagerExperience)==false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Given 2 teams and the stadium in which the match will be played.
	 * The stadium can result in three cases:
	 *  1. The match is played in the home stadium of team1. 
	 *  2. The match is played in the home stadium of team2. 
	 *  3. The match is played in a neutral venue. 
	 *  
	 *  If a team plays a match in its home stadium, its skill level is temporarily increased by 10 for that particular match only. 
	 *  Assume there will be no draws - i.e. assume the resultant team skills of the 2 teams will not be equal. 
	 *  No need to verify the teams in this function. 
	 *  The team with the greater team skill wins. 
	 * @return 1 if team1 wins and  2 if team2 wins. 
	 * 
	 *  
	 */

	public int findMatchWinningTeam(Team team1, Team team2, Stadium stadium) {
		int team1Skill = team1.calculateTeamSkill();
		int team2Skill = team2.calculateTeamSkill();
		if(stadium.getHomeTeamName().equalsIgnoreCase(team1.getTeamName())) {
			team1Skill += 10;
		}
		else if(stadium.getHomeTeamName().equalsIgnoreCase(team2.getTeamName())) {
			team2Skill += 10;
		}
		if(team1Skill > team2Skill) {
			return 1;
		}
		else { //test cases to make sure that team skills are not equal
			return 2;
		}
	}
	
	/**
	 * Simulate the Tournament. 
	 * The simulation is as follows:
	 * There are exactly 4 teams. A team plays 2 matches with every other team.
	 * There will hence be 12 matches. 
	 * the first match will be played in stadium at index 0 of the stadiumsArray.
	 * the next match will be played in the stadium at the next index 
	 * if there is no stadium at the next index, the match will be played in stadium at index 0 and the cycle continues.
	 * Refer to the question paper for better visualization
	 * The winning team will be awarded with 3 points.
	 * @Return False if the tournament is not valid.If the tournament is valid, this function conducts the simulation and returns true.
	 * 
	 * 
	 */
	
	public boolean simulateTournament() {
		if(!this.verifyTournamentValidity()) {
			return false;
		}
		int stadiumIndex = 0;
		int matchWinningTeamNumber;
		for(int i = 0; i<NUMBER_OF_TEAMS; i++) {
			for(int j = 0; j<NUMBER_OF_TEAMS; j++) {
				if(i==j) {
					continue;
				}
				matchWinningTeamNumber = 
						findMatchWinningTeam(this.teamsEnrolledArray[i], 
								this.teamsEnrolledArray[j], this.stadiumsArray[stadiumIndex]);
				if(matchWinningTeamNumber==1) {
					this.pointsArray[i] += 3;
				}
				else {
					this.pointsArray[j] += 3;
				}
				stadiumIndex = (stadiumIndex+1)%this.numberOfStadiums;
			}
		}
		return true;
	}
	
	/**
	 * Assume the simulation function has already been called
	 * Assume that there are no ties for first place in the points.
	 * @return The name of the winning team - the team with the highest number of points.
	 * 
	 * 
	 * 
	 */
	
	public String findTournamentWinningTeam() {
		int indexOfWinningTeam = 0;
		for(int i = 0; i<NUMBER_OF_TEAMS; i++) {
			if(this.pointsArray[i] > this.pointsArray[indexOfWinningTeam]) {
				indexOfWinningTeam = i;
			}
		}
		return this.teamsEnrolledArray[indexOfWinningTeam].getTeamName();
	}
	
	/**
	 * @return The profit of the event - calculated using revenue from the associated Stadiums,sponsorshipAmount and amountInvestedOnEvent.
	 */

	public int calculateProfit() {
		int revenueFromStadiums = 0;
		for(int i = 0; i<this.numberOfStadiums; i++) {
			revenueFromStadiums += this.stadiumsArray[i].getStadiumRevenue();
		}
		return revenueFromStadiums + this.sponsorshipAmount - this.amountInvestedOnEvent;
	}
	
	/**
	 * Conducting a simulation of the tournament.
	 * 
	 * @return If it is unsuccessful, return the String "Simulation failed." without the quotes.
	 * Else if the profit is 100000,and the winning team is Manchester United-
	 * Return: The String "Profit:100000;Winner-Manchester United" without the quotes.
	 */
	
	public String toString() {
		if(!this.simulateTournament()) {
			return "Simulation failed.";
		}
		return "Profit:" + this.calculateProfit() + ";Winner-" + this.findTournamentWinningTeam();
	}
}
