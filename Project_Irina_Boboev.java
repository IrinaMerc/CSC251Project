import java.util.Scanner;
public class Project_Irina_Boboev{

public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

            System.out.print("Please enter the Policy Number: ");
            Integer policyNumber = input.nextInt();
            input.nextLine();

            System.out.print("Please enter the Provider Name: ");
            String providerName = input.nextLine();

            System.out.print("Please enter the Policyholder’s First Name: ");
            String firstName = input.nextLine();

            System.out.print("Please enter the Policyholder’s Last Name: ");
            String lastName = input.nextLine();

            System.out.print("Please enter the Policyholder’s Age: ");
            int age = input.nextInt();
            input.nextLine();

            System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
            String smokingStatus = input.nextLine();

            System.out.print("Please enter the Policyholder’s Height (in inches): ");
            double height = input.nextDouble();

            System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
            double weight = input.nextDouble();

            Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, height, weight, smokingStatus);

            System.out.println("Policy Number: " + policy.getPolicyNumber());
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
    }