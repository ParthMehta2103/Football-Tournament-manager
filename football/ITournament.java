/**
 * Package containing 5 classes-ITournament,Manager,Member,Player,Team.
 */

package football;

import infrastructure.*;

/**
 * ITournament interface
 */

public interface ITournament {
	/**
	 * The exact number of teams which will participate in one tournament. The value is 4.
	 */
	int NUMBER_OF_TEAMS = 4;
	
	/**
	 * Given 2 teams and the stadium in which the match will be played.
	 * The stadium can result in three cases:
	 *  1. The match is played in the home stadium of team1. 
	 *  2. The match is played in the home stadium of team2. 
	 *  3. The match is played in a neutral venue. 
	 *  If a team plays a match in its home stadium, its skill level is temporarily increased by 10 for that particular match only. 
	 *  Assume there will be no draws - i.e. assume the resultant team skills of the 2 teams will not be equal. 
	 * @param team1
	 * @param team2
	 * @param stadium
	 * 
	 * @return 1 if team1 wins and 2 if team2 wins. the team with the greater team skill wins.
	 * 
	 */
	
	public int findMatchWinningTeam(Team team1, Team team2, Stadium stadium);
	
	/**
	 * Simulation of the Tournament.
	 * The simulation is as follows:
	 * There are exactly 4 teams. A team plays 2 matches with every other team.
	 * There will hence be 12 matches. 
	 * The first match will be played in stadium at index 0.
	 * The next match will be played in the stadium at the next index  
	 * If there is no stadium at the next index, the match will be played in stadium at index 0 and the cycle continues.
	 * Refer to the question paper for better visualization
	 * The winning team will be awarded with 3 points.
	 * @return False if the tournament is not valid. If the tournament is valid, this function conducts the simulation and returns true.
	 * 
	 */
	
	public boolean simulateTournament();
	
	/**
	 * Assume that there are no ties for first place in the points.
	 * @return The name of the winning team - the team with the highest number of points.
	 * 
	 */
	
	public String findTournamentWinningTeam();
}
