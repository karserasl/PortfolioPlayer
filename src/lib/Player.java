package lib;

public class Player {
	// Fields
	private Name name;
	private Rollable rollable;

	// Constructors
	public Player() {
		name = new Name();
		rollable = new PairOfDice();
	}

	public Player(Name name) {
		this.name = name;
		rollable = new PairOfDice();
	}

	public Player(Name name, Rollable rollable) {
		this.name = name;
		this.rollable = rollable;
	}

	// Getters & Setters
	public Name getName() {
		return this.name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Rollable getRollable() {
		return this.rollable;
	}

	// Methods
	public void rollDice() {
		this.rollable.roll();
	}

	public int getDiceScore() {
		return this.rollable.getScore();
	}

	public void setFullPlayerName(String name) {
		this.name.setFirstName(name.substring(0, name.indexOf(" ")));
		this.name.setFamilyName(name.substring(name.indexOf(" ") + 1));

	}

	@Override
	public String toString() {
		return "Player:[name=" + name + ", dices=" + rollable + "]";
	}

}
