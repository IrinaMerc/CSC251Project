import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project_Irina_Boboev{

   public static void main(String[] args) throws FileNotFoundException {
        //  File file = new File("PolicyInformation.txt");
        Scanner input = new Scanner(new File("PolicyInformation.txt"));

        int smokers = 0;
        int nonSmokers = 0;

        while (input.hasNext()) {
            int policyNumber = input.nextInt();
            input.nextLine();
            String providerName = input.nextLine();
            String firstName = input.nextLine();
            String lastName = input.nextLine();
            int age = input.nextInt();
            input.nextLine();
            String smokingStatus = input.nextLine();
            double height = input.nextDouble();
            input.nextLine();
            double weight = input.nextDouble();
            System.out.println();

            Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, height, weight, smokingStatus);

            if ("smoker".equalsIgnoreCase(policy.getPolicyholderSmokingStatus())) {
                smokers++;
            } else {
                nonSmokers++;
            }

            System.out.println("Policy Number: " + policyNumber);
            System.out.println("Provider Name: " + policy.getPolicyName());
            System.out.println("Policyholder’s First Name: " + policy.getPolicyholderFirstName());
            System.out.println("Policyholder’s Last Name: " + policy.getPolicyholderLastName());
            System.out.println("Policyholder’s Age: " + policy.getPolicyholderAge());
            System.out.println("Policyholder’s Smoking Status: " + policy.getPolicyholderSmokingStatus());
            System.out.println("Policyholder’s Height: " + policy.getPolicyholderHeight() + " inches");
            System.out.println("Policyholder’s Weight: " + policy.getPolicyholderWeight() + " pounds");
            System.out.printf("Policyholder’s BMI: %.2f\n", policy.bmiOfPolicyholder());
            System.out.printf("Policy Price: $%.2f\n", policy.priceOfInsurancePolicy());
        }
        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
        input.close();
    }    
}