
public class Policy {
    private int policyNumber;
    private String providerName;      // sample calls this "Provider Name"
    private PolicyHolder holder;      // aggregation


    private static int policyCount = 0;

  
    public Policy() {
        policyNumber = 0;
        providerName = "";
        holder = new PolicyHolder();
        policyCount++;
    }

    public Policy(int policyNumber, String providerName, PolicyHolder holder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.holder = new PolicyHolder(holder);
        policyCount++;
    }


    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public PolicyHolder getPolicyHolder() { return new PolicyHolder(holder); }


    public void setPolicyHolder(PolicyHolder holder) { this.holder = new PolicyHolder(holder); }


    public static int getPolicyCount() { return policyCount; }

    public double getPolicyPrice() {
        final double BASE = 600.0;
        double price = BASE;

        String status = holder.getSmokingStatus();
        boolean smoker = "smoker".equalsIgnoreCase(status);
        double bmi = holder.getBMI();

        if (smoker) {
            price += 100.0;
            if (bmi > 35.0) {
                price += (bmi - 35.0) * 20.0;
            }
        } else {
            if (bmi > 25.0) {
                price += 75.0;
            }
        }
        return price;
    }

    @Override
    public String toString() {
               return String.format(
            "Policy Number: %d%n%n" +
            "Provider Name: %s%n%n" +
            "%s%n%n" +
            "Policy Price: $%.2f",
            policyNumber, providerName, holder.toString(), getPolicyPrice()
        );
    }
}
