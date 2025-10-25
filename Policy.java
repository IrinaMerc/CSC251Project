/**
 * Policy
 * -------
 * A simple data class that stores policy and policyholder information,
 * and provides utilities to compute BMI and an insurance price estimate.
 */
public class Policy {

    // --------------------
    // Fields
    // --------------------
    private int policyNumber;
    private String policyName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private double policyholderHeight;     // in inches
    private double policyholderWeight;     // in pounds
    private String policyholderSmokingStatus; // "smoker" or "non-smoker"

    /**
     * No-argument constructor that initializes all fields to default values.
     */
    public Policy() {
        policyNumber = 0;
        policyName = "";
        policyholderFirstName = "";
        policyholderLastName = "";
        policyholderAge = 0;
        policyholderSmokingStatus = "non-smoker";
        policyholderHeight = 0.0;
        policyholderWeight = 0.0;
    }

    /**
     * Constructs a Policy with all fields initialized.
     *
     * @param policyNumber the unique policy number
     * @param policyName the name of the policy
     * @param policyholderFirstName the policyholder's first name
     * @param policyholderLastName the policyholder's last name
     * @param policyholderAge the policyholder's age in years
     * @param policyholderHeight the policyholder's height in inches
     * @param policyholderWeight the policyholder's weight in pounds
     * @param policyholderSmokingStatus the smoking status ("smoker" or "non-smoker")
     */
    public Policy(int policyNumber,
                  String policyName,
                  String policyholderFirstName,
                  String policyholderLastName,
                  int policyholderAge,
                  double policyholderHeight,
                  double policyholderWeight,
                  String policyholderSmokingStatus) {
        this.policyNumber = policyNumber;
        this.policyName = policyName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.policyholderHeight = policyholderHeight;
        this.policyholderWeight = policyholderWeight;
        this.policyholderSmokingStatus = policyholderSmokingStatus;
    }

    // --------------------
    // Accessors / Mutators
    // --------------------

    /**
     * Gets the policyholder's last name.
     * @return the last name
     */
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    /**
     * Sets the policyholder's last name.
     * @param policyholderLastName the last name to set
     */
    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    /**
     * Gets the policy number.
     * @return the policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     * @param policyNumber the policy number to set
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets the policy name.
     * @return the policy name
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * Sets the policy name.
     * @param policyName the policy name to set
     */
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    /**
     * Gets the policyholder's first name.
     * @return the first name
     */
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    /**
     * Sets the policyholder's first name.
     * @param policyholderFirstName the first name to set
     */
    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    /**
     * Gets the policyholder's age.
     * @return the age in years
     */
    public int getPolicyholderAge() {
        return policyholderAge;
    }

    /**
     * Sets the policyholder's age.
     * @param policyholderAge the age in years
     */
    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }

    /**
     * Gets the policyholder's height.
     * @return the height in inches
     */
    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    /**
     * Sets the policyholder's height.
     * @param policyholderHeight the height in inches
     */
    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }

    /**
     * Gets the policyholder's weight.
     * @return the weight in pounds
     */
    public double getPolicyholderWeight() {
        return policyholderWeight;
    }

    /**
     * Sets the policyholder's weight.
     * @param policyholderWeight the weight in pounds
     */
    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }

    /**
     * Gets the policyholder's smoking status.
     * @return the smoking status (e.g., "smoker" or "non-smoker")
     */
    public String getPolicyholderSmokingStatus() {
        return policyholderSmokingStatus;
    }

    /**
     * Sets the policyholder's smoking status.
     * @param policyholderSmokingStatus the smoking status to set
     */
    public void setPolicyholderSmokingStatus(String policyholderSmokingStatus) {
        this.policyholderSmokingStatus = policyholderSmokingStatus;
    }

    // --------------------
    // Computation methods
    // --------------------

    /**
     * Computes the Body Mass Index (BMI) of the policyholder using
     * the imperial formula: BMI = (weight * 703) / (height^2).
     * If height is not positive, returns 0.0 to avoid division by zero.
     *
     * @return the BMI value, or 0.0 if height is invalid
     */
    public double bmiOfPolicyholder() {
        if (policyholderHeight <= 0) {
            return 0.0; // avoid divide by zero
        }
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    /**
     * Estimates the insurance policy price.
     * Base price is $600.
     * - If age > 50, add $75; otherwise add $100.
     * - If smoker, add $100.
     * - If BMI > 35, add $20 for each BMI point over 35.
     *
     * @return the computed policy price
     */
    public double priceOfInsurancePolicy() {
        double price = 600;

        if (policyholderAge > 50) {
            price += 75;
        } else {
            price += 100;
        }

        if (policyholderSmokingStatus != null && policyholderSmokingStatus.equalsIgnoreCase("smoker")) {
            price += 100;
        }

        double bmi = bmiOfPolicyholder();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }
}
