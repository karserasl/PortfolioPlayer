package lib;

/**
 * Player Class is a Composition of Names and Rollables.
 * A Player has a name, and a pair of dices. It can be empty, named with default rollable type (PairOfDice),
 * or named and defined rollable of any type that implements the rollable Interface.
 * The Player has many features including but not limited to: rollDice, setFullPlayerName, getDiceScore etc.
 * The Player Class implements Comparable, so it can delegate to subclasses for comparisons.
 *
 * @author P2424629
 */
public class Player implements Comparable<Player> {

    // Fields

    private Name name;
    private Rollable rollable;

    // Constructors

    /**
     * Create an empty named Player with rollable as default PairOfDice (red and blue with 6 sides).
     */
    public Player() {

        name = new Name();
        rollable = new PairOfDice();
    }

    /**
     * Create a named Player with default rollable type PairOfDice (red and blue with 6 sides).
     *
     * @param name The name of the Player as FirstName and LastName.
     */
    public Player(Name name) {

        this.name = name;
        rollable = new PairOfDice();
    }

    /**
     * Create a named Player and define the rollable.
     *
     * @param name     The name of the Player as FirstName and LastName.
     * @param rollable The rollable type and arguments (Die, PairOfDice).
     */
    public Player(Name name, Rollable rollable) {

        this.name = name;
        this.rollable = rollable;
    }

    // Getters & Setters

    /**
     * Returns the name of the Player.
     *
     * @return The name of the Player.
     */
    public Name getName() {

        return this.name;
    }

    /**
     * Sets the name of the Player to the specified value.
     *
     * @param name The Player's name.
     */
    public void setName(Name name) {

        this.name = name;
    }

    /**
     * Returns the rollable of the Player.
     *
     * @return The rollable of the Player.
     */
    public Rollable getRollable() {

        return this.rollable;
    }

    // Methods

    /**
     * Roll the rollable type by delegate to rollable type.
     */
    public void rollDice() {

        this.rollable.roll();
    }

    /**
     * Returns the score of the rollable.
     *
     * @return The score of rollable.
     */
    public int getDiceScore() {

        return this.rollable.getScore();
    }

    /**
     * Sets the full name (FirstName, LastName) of the Player to the specified values.
     *
     * @param name The name of the Player.
     */
    public void setFullPlayerName(String name) {

        this.name.setFirstName(name.substring(0, name.indexOf(" ")));
        this.name.setFamilyName(name.substring(name.indexOf(" ") + 1));

    }

    /**
     * Returns the String representation of the Player, containing the name and the rollable, by delegate to their
     * respective
     * Class and call the toString method on each object.
     *
     * @return The Player's name and the rollable.
     */
    @Override
    public String toString() {

        return "Player:[name=" + name + ", dices=" + rollable + "]";
    }

    /**
     * Returns an integer representation of lexicographically comparing the name of Player to some other Player's name.
     * First it compares the LastName and, if lexicographically equal, the FirstName, by delegating to the Name Class.
     *
     * @param o The object of some other Player that we want to compare our Player to.
     * @return A number that can be either negative, zero, or positive.
     * Negative means the name of the Player comes lexicographically first than the other Player.
     * Zero means both names are the same.
     * Positive means the name of the Player comes lexicographically after the name of the other Player we compare to.
     */
    @Override
    public int compareTo(Player o) {

        return this.name.compareTo(o.name);
    }

    /**
     * Returns a Boolean value by comparing two objects for equality by their internal contents (Name and rollable).
     *
     * @param o Some other object we want to check for equality to our Player object.
     * @return The Boolean value result between the two objects, based on the equality of Name and rollable.
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true; // If we compare it to itself it's always true.
        // test exceptional cases, i.e. obj not null and is a Player.
        if (o == null || this.getClass() != o.getClass()) return false;

        Player player = (Player) o; // downcast to a Player object

        // Compare the Name's of the Players and the rollables.
        return this.name.equals(player.name) &&
                this.rollable.equals(player.rollable);
    }

}
