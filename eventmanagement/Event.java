/**
 * Package containing 2 classes-Event and FootballEvent.
 */

package eventmanagement;
/** 
 * Event class.
 */
public abstract class Event {
	
	/**
	 * 
	 * The amount invested on this event.
	 */
	
	protected int amountInvestedOnEvent;
	
	/**
	 * The sponsorship amount for this event.
	 */
	protected int sponsorshipAmount;
	
	/**
	 * 
	 * @param amountInvestedOnEvent
	 * @param sponsorshipAmount
	 * 
	 */

	
	public Event(int amountInvestedOnEvent, int sponsorshipAmount) {
		this.amountInvestedOnEvent = amountInvestedOnEvent;
		this.sponsorshipAmount = sponsorshipAmount;
	}
	
	/**
	 * 
	 * 
	 * @return The amount invested on the event.
	 * 
	 */
		
	public int getAmountInvestedOnEvent() {
		return this.amountInvestedOnEvent;
	}
	
	/**
	 * 
	 * 
	 * @return The amount received from sponsorship for this event.
	 */
	
	public int getSponsorshipAmount() {
		return this.sponsorshipAmount;
	}
	
	/**
	 * 
	 * 
	 * @return An abstract function that gives profit of this event.
	 */
	
	public abstract int calculateProfit();
	
}
