// PolicyHolder.java  (Project 3 - Chapter 8 aggregation)
public class PolicyHolder {
    // Fields that belong to the *person* (policy holder)
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;   // "smoker" or "non-smoker"
    private double heightInches;    // inches
    private double weightPounds;    // pounds

    // No-arg constructor
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        heightInches = 0.0;
        weightPounds = 0.0;
    }

        public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double heightInches, double weightPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
    }

      public PolicyHolder(PolicyHolder other) {
        this(other.firstName, other.lastName, other.age,
             other.smokingStatus, other.heightInches, other.weightPounds);
    }

    // Getters / Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String v) { firstName = v; }

    public String getLastName() { return lastName; }
    public void setLastName(String v) { lastName = v; }

    public int getAge() { return age; }
    public void setAge(int v) { age = v; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String v) { smokingStatus = v; }

    public double getHeightInches() { return heightInches; }
    public void setHeightInches(double v) { heightInches = v; }

    public double getWeightPounds() { return weightPounds; }
    public void setWeightPounds(double v) { weightPounds = v; }

    /** BMI in imperial units: 703 * weight(lb) / height(in)^2 */
    public double getBMI() {
        if (heightInches <= 0) return 0.0;
        return 703.0 * weightPounds / (heightInches * heightInches);
    }

    @Override
    public String toString() {
                return String.format(
            "Policyholder's First Name: %s%n%n" +
            "Policyholder's Last Name: %s%n%n" +
            "Policyholder's Age: %d%n%n" +
            "Policyholder's Smoking Status (Y/N): %s%n%n" +
            "Policyholder's Height: %.1f inches%n%n" +
            "Policyholder's Weight: %.1f pounds%n%n" +
            "Policyholder's BMI: %.2f",
            firstName, lastName, age, smokingStatus, heightInches, weightPounds, getBMI()
        );
    }
}
