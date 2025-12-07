import java.util.Scanner;

public class StudentScoresheetGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capturing School Details
        System.out.println("Enter School Name: ");
        String schoolName = scanner.nextLine();

        System.out.println("Enter Teacher Name: ");
        String teacherName = scanner.nextLine();

        System.out.println("Enter Grade: ");
        int grade = scanner.nextInt();

        System.out.println("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        // Capturing Student Records
        System.out.println("Enter number of students (minimum 12): ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        if( numStudents <12){
            System.out.println("A minimum number of 12 students is required");
            return;
        }

        // arrays to store student data
        String[] studentNames = new String[numStudents];
        double[] englishMarks = new double[numStudents];
        double[] mathMarks = new double[numStudents];
        double[] historyMarks = new double[numStudents];
        double[] geographyMarks = new double[numStudents];
        double[] scienceMarks = new double[numStudents];
        double[] programmingMarks = new double[numStudents];
        double[] totalMarks = new double[numStudents];
        String[] ranks = new String[numStudents];

        // Input student data
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n\t\t\tEnter details for Student " + (i + 1) + ":");

            System.out.print("Student Name: ");
            studentNames[i] = scanner.nextLine();

            System.out.print("English Mark: ");
            englishMarks[i] = scanner.nextDouble();

            System.out.print("Math Mark: ");
            mathMarks[i] = scanner.nextDouble();

            System.out.print("History Mark: ");
            historyMarks[i] = scanner.nextDouble();

            System.out.print("Geography Mark: ");
            geographyMarks[i] = scanner.nextDouble();

            System.out.print("Science Mark: ");
            scienceMarks[i] = scanner.nextDouble();

            System.out.print("Programming Mark: ");
            programmingMarks[i] = scanner.nextDouble();
            scanner.nextLine(); // Clear the buffer
        }

        // Compute Results
        for (int i = 0; i < numStudents; i++) {
            // Calculate total marks
            totalMarks[i] = englishMarks[i] + mathMarks[i] + historyMarks[i] +
                    geographyMarks[i] + scienceMarks[i] + programmingMarks[i];

            //  ranking using loop
            if (totalMarks[i] >= 540.0) {
                ranks[i] = "A";
            } else if (totalMarks[i] >= 480.0) {
                ranks[i] = "B";
            } else if (totalMarks[i] >= 420.0) {
                ranks[i] = "C";
            } else if (totalMarks[i] >= 360.0) {
                ranks[i] = "D";
            } else {
                ranks[i] = "F";
            }
        }

        //Compute Class Statistics
        double totalEnglish = 0, totalMath = 0, totalHistory = 0;
        double totalGeography = 0, totalScience = 0, totalProgramming = 0;
        double grandTotal = 0;
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int i = 0; i < numStudents; i++) {
            totalEnglish += englishMarks[i];
            totalMath += mathMarks[i];
            totalHistory += historyMarks[i];
            totalGeography += geographyMarks[i];
            totalScience += scienceMarks[i];
            totalProgramming += programmingMarks[i];
            grandTotal += totalMarks[i];

            // Count ranks
            if (ranks[i].equals("A")) {
                countA++;
            } else if (ranks[i].equals("B")) {
                countB++;
            } else if (ranks[i].equals("C")) {
                countC++;
            } else if (ranks[i].equals("D")) {
                countD++;
            } else if (ranks[i].equals("F")) {
                countF++;
            }
        }

        // Calculate averages
        double avgEnglish = totalEnglish / numStudents;
        double avgMath = totalMath / numStudents;
        double avgHistory = totalHistory / numStudents;
        double avgGeography = totalGeography / numStudents;
        double avgScience = totalScience / numStudents;
        double avgProgramming = totalProgramming / numStudents;
        double avgTotal = grandTotal / numStudents;

        // Output
        System.out.println("\n" + "-".repeat(100));
        System.out.println("                                     School Name: " + schoolName);
        System.out.println("                                     Teacher: " + teacherName);
        System.out.println("                                     Grade: " + grade);
        System.out.println("                                     Year: " + year);
        System.out.println("-".repeat(100));

        System.out.printf("%-20s %8s %8s %8s %10s %8s %12s %8s %5s%n",
                "Student Name", "English", "Math", "History", "Geography",
                "Science", "Programming", "Total", "Rank");
        System.out.println("=".repeat(100));


        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-20s %8.2f %8.2f %8.2f %10.2f %8.2f %12.2f %8.2f %5s%n",
                    studentNames[i], englishMarks[i], mathMarks[i],
                    historyMarks[i], geographyMarks[i], scienceMarks[i],
                    programmingMarks[i], totalMarks[i], ranks[i]);
        }

        System.out.println("-".repeat(100));


        System.out.printf("%-20s %8.2f %8.2f %8.2f %10.2f %8.2f %12.2f %8.2f%n",
                "", totalEnglish, totalMath, totalHistory,
                totalGeography, totalScience, totalProgramming, grandTotal);

        System.out.println("-".repeat(100));

        // Print averages
        System.out.printf("%-20s %8.2f %8.2f %8.2f %10.2f %8.2f %12.2f %8.2f%n",
                "", avgEnglish, avgMath, avgHistory,
                avgGeography, avgScience, avgProgramming, avgTotal);

        System.out.println("=".repeat(100));

        // Print rank distribution
        System.out.printf("%20s A's: %d    B's: %d    C's: %d    D's: %d    F's: %d%n",
                "Ranks", countA, countB, countC, countD, countF);

        System.out.println("=".repeat(100));

        scanner.close();
    }
}