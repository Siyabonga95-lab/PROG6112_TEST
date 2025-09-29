import java.util.Scanner;
/**
 * Question 2
 * Student Number: ST10488360
 * Student Name: Siyabonga Msimango
 */

// ============================================================================
// ICricket.java - Interface Definition
// ============================================================================
// An interface sets a contract. Any class that implements this interface
// MUST define these three methods.
interface ICricket {
    String getBatsman();
    String getStadium();
    int getRunsScored();
}

// ============================================================================
// Cricket.java - Abstract Base Class
// ============================================================================
// Abstract class: cannot be created directly, only extended.
// Stores common details that all cricket score classes will share.
abstract class Cricket {
    private String batsmanName;
    private String stadiumName;
    private int totalRunsScored;

    // Constructor to assign values when an object is created
    public Cricket(String batsmanName, String stadiumName, int totalRunsScored) {
        this.batsmanName = batsmanName;
        this.stadiumName = stadiumName;
        this.totalRunsScored = totalRunsScored;
    }

    // Getter methods to safely access private variables
    public String getBatsmanName() {
        return batsmanName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public int getTotalRunsScored() {
        return totalRunsScored;
    }
}

// ============================================================================
// CricketRunsScored.java - Concrete Class
// ============================================================================
// Inherits from Cricket (abstract class) and implements ICricket (interface).
// Shows use of inheritance + polymorphism in OOP.
class CricketRunsScored extends Cricket implements ICricket {

    public CricketRunsScored(String batsmanName, String stadiumName, int totalRunsScored) {
        super(batsmanName, stadiumName, totalRunsScored);
    }

    // Implementing interface methods
    @Override
    public String getBatsman() {
        return getBatsmanName();
    }

    @Override
    public String getStadium() {
        return getStadiumName();
    }

    @Override
    public int getRunsScored() {
        return getTotalRunsScored();
    }

    // Nicely formatted report output
    public void printReport() {
        System.out.println("********************************");
        System.out.println("       BATSMAN RUNS REPORT      ");
        System.out.println("********************************");
        System.out.println("CRICKET PLAYER: " + getBatsman());
        System.out.println("STADIUM: " + getStadium());
        System.out.println("TOTAL RUNS SCORED: " + getRunsScored());
        System.out.println("********************************");
    }
}

// ============================================================================
// RunApplication.java - Main Class
// ============================================================================
// This class runs the program. It asks the user for input, validates it,
// creates the object, and prints the final report.
public class RunApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --------- Get Cricketer Name (letters and spaces only) ----------
        String batsmanName;
        while (true) {
            System.out.print("Enter cricketer name: ");
            batsmanName = scanner.nextLine().trim();

            if (batsmanName.isEmpty()) {
                System.out.println("Error: Name cannot be empty. Try again.");
            } else if (!batsmanName.matches("[a-zA-Z ]+")) {
                System.out.println("Error: Name can only contain letters and spaces. Try again.");
            } else {
                break;
            }
        }

        // --------- Get Stadium Name (letters and spaces only) ----------
        String stadiumName;
        while (true) {
            System.out.print("Enter the stadium: ");
            stadiumName = scanner.nextLine().trim();

            if (stadiumName.isEmpty()) {
                System.out.println("Error: Stadium name cannot be empty. Try again.");
            } else if (!stadiumName.matches("[a-zA-Z ]+")) {
                System.out.println("Error: Stadium name can only contain letters and spaces. Try again.");
            } else {
                break;
            }
        }

        // --------- Get Runs Scored (must be a positive number) ----------
        int runsScored = 0;
        while (true) {
            System.out.print("Enter the total runs scored by " + batsmanName + " at " + stadiumName + ": ");

            if (scanner.hasNextInt()) {
                runsScored = scanner.nextInt();
                if (runsScored < 0) {
                    System.out.println("Error: Runs cannot be negative. Try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Error: Please enter a valid number for runs.");
                scanner.next(); // clear wrong input
            }
        }

        // Create object with valid input
        CricketRunsScored cricketScore = new CricketRunsScored(batsmanName, stadiumName, runsScored);

        System.out.println(); // blank line before report
        cricketScore.printReport(); // print results

        scanner.close(); // always close scanner
    }
}
