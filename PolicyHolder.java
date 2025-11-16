public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private double heightInches;
    private double weightPounds;
    private String smokingStatus; // "smoker" or "non-smoker"

    public PolicyHolder() {
        firstName = ""; lastName = ""; age = 0;
        heightInches = 0.0; weightPounds = 0.0;
        smokingStatus = "non-smoker";
    }

    public PolicyHolder(String fn, String ln, int age, double hIn, double wLb, String status) {
        this.firstName = fn; this.lastName = ln; this.age = age;
        this.heightInches = hIn; this.weightPounds = wLb; this.smokingStatus = status;
    }

    // Copy constructor for defensive copying
    public PolicyHolder(PolicyHolder other) {
        this(other.firstName, other.lastName, other.age,
             other.heightInches, other.weightPounds, other.smokingStatus);
    }

    // Getters/setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String v) { firstName = v; }
    public String getLastName() { return lastName; }
    public void setLastName(String v) { lastName = v; }
    public int getAge() { return age; }
    public void setAge(int v) { age = v; }
    public double getHeightInches() { return heightInches; }
    public void setHeightInches(double v) { heightInches = v; }
    public double getWeightPounds() { return weightPounds; }
    public void setWeightPounds(double v) { weightPounds = v; }
    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String v) { smokingStatus = v; }

    /** BMI (imperial): 703 * weight(lb) / height(in)^2 */
    public double getBMI() {
        return heightInches > 0 ? 703.0 * weightPounds / (heightInches * heightInches) : 0.0;
    }

    @Override
    public String toString() {
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
