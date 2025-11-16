public class Policy {
    private int policyNumber;
    private String policyName; // print as "Provider Name" in toString
    private PolicyHolder holder;

    private static int policyCount = 0;

    public Policy() {
        policyNumber = 0; policyName = "";
        holder = new PolicyHolder();
        policyCount++;
    }

    public Policy(int policyNumber, String policyName, PolicyHolder holder) {
        this.policyNumber = policyNumber;
        this.policyName = policyName;
        this.holder = new PolicyHolder(holder); // defensive copy
        policyCount++;
    }

    // Getters/setters
    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int n) { policyNumber = n; }
    public String getPolicyName() { return policyName; }
    public void setPolicyName(String n) { policyName = n; }

    /** Defensive copy out */
    public PolicyHolder getPolicyHolder() { return new PolicyHolder(holder); }

    /** Defensive copy in */
    public void setPolicyHolder(PolicyHolder h) { holder = new PolicyHolder(h); }

    public static int getPolicyCount() { return policyCount; }

    // Renamed from priceOfInsurancePolicy()
    public double getPolicyPrice() {
        double price = 600.0;

        // keep your original pricing logic (Ch 2–8 OK)
        if (holder.getAge() > 50) price += 75; else price += 100;

        if ("smoker".equalsIgnoreCase(holder.getSmokingStatus())) price += 100;

        double bmi = holder.getBMI();
        if (bmi > 35) price += (bmi - 35) * 20;

        return price;
    }

    @Override
    public String toString() {
        return String.format(
            "Policy Number: %d%n%n" +
            "Provider Name: %s%n%n" +
            "%s%n%n" +
            "Policy Price: $%.2f",
            policyNumber, policyName, holder.toString(), getPolicyPrice()
        );
    }
}
