// PolicyHolder.java  (Chapter 8: aggregate class used by Policy)
public class PolicyHolder {
    // Fields directly associated with the person
    private String firstName;
    private String lastName;
    private int age;
    // Use "smoker" or "non-smoker" (match sample output text exactly)
    private String smokingStatus;
    private double heightInches; // e.g., 65.0
    private double weightPounds; // e.g., 110.0

    // No-arg constructor
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        heightInches = 0.0;
        weightPounds = 0.0;
    }

    // Full constructor for convenience
    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double heightInches, double weightPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
    }

    // Copy constructor (used for defensive copying)
    public PolicyHolder(PolicyHolder other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.age = other.age;
        this.smokingStatus = other.smokingStatus;
        this.heightInches = other.heightInches;
        this.weightPounds = other.weightPounds;
    }

    // Getters / Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    public double getHeightInches() { return heightInches; }
    public void setHeightInches(double heightInches) { this.heightInches = heightInches; }

    public double getWeightPounds() { return weightPounds; }
    public void setWeightPounds(double weightPounds) { this.weightPounds = weightPounds; }

    /** Compute BMI = 703 * weight(lbs) / height(in)^2 */
    public double getBMI() {
        if (heightInches == 0) return 0.0;
        return 703.0 * weightPounds / (heightInches * heightInches);
    }

    @Override
    public String toString() {
        // Note: Keep wording/spacing to match sample output exactly
        return String.format(
            "Policyholder's First Name: %s%n" +
            "Policyholder's Last Name: %s%n" +
            "Policyholder's Age: %d%n" +
            "Policyholder's Smoking Status (Y/N): %s%n" +
            "Policyholder's Height: %.1f inches%n" +
            "Policyholder's Weight: %.1f pounds%n" +
            "Policyholder's BMI: %.2f",
            firstName, lastName, age, smokingStatus, heightInches, weightPounds, getBMI()
        );
    }
}
