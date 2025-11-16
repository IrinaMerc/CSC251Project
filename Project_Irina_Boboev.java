import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project_Irina_Boboev {

       private static String nextNonEmptyLine(Scanner in) {
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (!line.isEmpty()) return line;
        }
        return null;     }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("PolicyInformation.txt"));

        int smokerCount = 0;
        int nonSmokerCount = 0;

            while (true) {
            String policyNumberLine = nextNonEmptyLine(input);
            if (policyNumberLine == null) break; 
            String providerName   = nextNonEmptyLine(input);   if (providerName   == null) break;
            String firstName      = nextNonEmptyLine(input);   if (firstName      == null) break;
            String lastName       = nextNonEmptyLine(input);   if (lastName       == null) break;
            String ageLine        = nextNonEmptyLine(input);   if (ageLine        == null) break;
            String smokingStatus  = nextNonEmptyLine(input);   if (smokingStatus  == null) break;
            String heightLine     = nextNonEmptyLine(input);   if (heightLine     == null) break;
            String weightLine     = nextNonEmptyLine(input);   if (weightLine     == null) break;
            int policyNumber = Integer.parseInt(policyNumberLine);
            int age          = Integer.parseInt(ageLine);
            double height    = Double.parseDouble(heightLine);
            double weight    = Double.parseDouble(weightLine);

                        PolicyHolder holder = new PolicyHolder(firstName, lastName, age,
                                                   smokingStatus, height, weight);
            Policy policy = new Policy(policyNumber, providerName, holder);

                      if ("smoker".equalsIgnoreCase(smokingStatus)) smokerCount++;
            else                                          nonSmokerCount++;

                     System.out.println(policy);
            System.out.println();
        }

             System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println();
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println();
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        input.close();
    }
}
