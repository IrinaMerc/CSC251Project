public class Policy {

    private int policyNumber;
    private String policyName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private double policyholderHeight;
    private double policyholderWeight;
    private String policyholderSmokingStatus;

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

    public Policy(int policyNumber, String policyName, String policyholderFirstName, String policyholderLastName, int policyholderAge, double policyholderHeight, double policyholderWeight, String policyholderSmokingStatus) {
        this.policyNumber = policyNumber;
        this.policyName = policyName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.policyholderHeight = policyholderHeight;
        this.policyholderWeight = policyholderWeight;
        this.policyholderSmokingStatus = policyholderSmokingStatus;
    }

    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    public int getPolicyholderAge() {
        return policyholderAge;
    }

    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }

    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }

    public double getPolicyholderWeight() {
        return policyholderWeight;
    }

    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }

    public String getPolicyholderSmokingStatus() {
        return policyholderSmokingStatus;
    }

    public void setPolicyholderSmokingStatus(String policyholderSmokingStatus) {
        this.policyholderSmokingStatus = policyholderSmokingStatus;
    }

    public double bmiOfPolicyholder() {
        if (policyholderHeight <= 0) {
            return 0.0; // avoid divide by zero
        }
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);

    }

    public double priceOfInsurancePolicy(int age, String smokingStatus, double height, double weight) {
        double price = 600;
        if (age > 50) {
            price += 75;
        } else {
            price += 100;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100;
        }
        double bmi = bmiOfPolicyholder();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }
        return price;
    }
}
