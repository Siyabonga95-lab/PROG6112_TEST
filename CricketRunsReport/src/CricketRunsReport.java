/**
 * Question 1
 *
 * This application displays the total runs scored by three batsmen at three different stadiums,
 * and identifies the stadium with the highest total runs.
 * 
 *Student Number:ST10488360
 *Student Name:Siyabonga Msimango
 */

public class CricketRunsReport {
    
    public static void main(String[] args) {
        // Stadium names array - stores the three stadium names
        String[] stadiums = {"Kingsmead", "St George's", "Wanderers"};
        
        // Batsmen names array - stores the three batsmen names
        String[] batsmen = {"Jacques Kallis", "Hashim Amla", "AB de Villiers"};
        
        // Two-dimensional array storing runs scored by each batsman at each stadium
        // Rows represent stadiums, columns represent batsmen
        int[][] runsScored = {
            {5000, 3800, 4200},  // Kingsmead: Kallis, Amla, AB
            {3500, 3700, 3900},  // St George's: Kallis, Amla, AB
            {6200, 5000, 5200}   // Wanderers: Kallis, Amla, AB
        };
        
        // Display the main report header
        System.out.println("========================================");
        System.out.println("  CRICKET RUNS REPORT - HIGHEST SCORER  ");
        System.out.println("========================================");
        System.out.println();
        
        // Display the data in a well-formatted table
        displayRunsTable(stadiums, batsmen, runsScored);
        
        // Calculate and display total runs per batsman
        System.out.println("\n--- TOTAL RUNS PER BATSMAN (Career) ---");
        displayBatsmenTotals(batsmen, runsScored);
        
        // Calculate and display total runs per stadium
        System.out.println("\n--- TOTAL RUNS PER STADIUM ---");
        int[] stadiumTotals = calculateStadiumTotals(stadiums, runsScored);
        
        // Find and display the stadium with the most runs
        System.out.println("\n========================================");
        findAndDisplayHighestScoringStadium(stadiums, stadiumTotals);
        System.out.println("========================================");
    }
    
    /**
     * Displays the runs scored in a formatted table showing each batsman's
     * performance at each stadium
     * 
     * @param stadiums Array of stadium names
     * @param batsmen Array of batsmen names
     * @param runsScored 2D array containing runs data
     */
    public static void displayRunsTable(String[] stadiums, String[] batsmen, int[][] runsScored) {
        // Print table header with batsmen names
        System.out.printf("%-15s", "Stadium");
        for (String batsman : batsmen) {
            System.out.printf("%-20s", batsman);
        }
        System.out.println();
        System.out.println("------------------------------------------------------------");
        
        // Print each row showing stadium and runs scored by each batsman
        for (int i = 0; i < stadiums.length; i++) {
            System.out.printf("%-15s", stadiums[i]);
            for (int j = 0; j < batsmen.length; j++) {
                System.out.printf("%-20d", runsScored[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
     * Calculates and displays the total runs scored by each batsman across all stadiums
     * This shows their career totals at these three venues
     * 
     * @param batsmen Array of batsmen names
     * @param runsScored 2D array containing runs data
     */
    public static void displayBatsmenTotals(String[] batsmen, int[][] runsScored) {
        // Loop through each batsman (columns)
        for (int j = 0; j < batsmen.length; j++) {
            int totalRuns = 0;
            
            // Sum up runs across all stadiums for this batsman
            for (int i = 0; i < runsScored.length; i++) {
                totalRuns += runsScored[i][j];
            }
            
            // Display batsman name and their total runs
            System.out.printf("%s: %d runs\n", batsmen[j], totalRuns);
        }
    }
    
    /**
     * Calculates the total runs scored at each stadium by all batsmen combined
     * 
     * @param stadiums Array of stadium names
     * @param runsScored 2D array containing runs data
     * @return Array containing total runs for each stadium
     */
    public static int[] calculateStadiumTotals(String[] stadiums, int[][] runsScored) {
        // Create array to store stadium totals
        int[] stadiumTotals = new int[stadiums.length];
        
        // Loop through each stadium (rows)
        for (int i = 0; i < stadiums.length; i++) {
            int total = 0;
            
            // Sum up all runs scored by all batsmen at this stadium
            for (int j = 0; j < runsScored[i].length; j++) {
                total += runsScored[i][j];
            }
            
            // Store the total and display it
            stadiumTotals[i] = total;
            System.out.printf("%s: %d runs\n", stadiums[i], total);
        }
        
        return stadiumTotals;
    }
    
    /**
     * Finds the stadium with the highest total runs and displays the result
     * This method uses a single-dimensional array approach as required
     * 
     * @param stadiums Array of stadium names
     * @param stadiumTotals Array of total runs per stadium
     */
    public static void findAndDisplayHighestScoringStadium(String[] stadiums, int[] stadiumTotals) {
        // Initialize variables to track the highest scoring stadium
        int maxRuns = stadiumTotals[0];
        int maxIndex = 0;
        
        // Find the stadium with maximum total runs
        for (int i = 1; i < stadiumTotals.length; i++) {
            if (stadiumTotals[i] > maxRuns) {
                maxRuns = stadiumTotals[i];
                maxIndex = i;
            }
        }
        
        // Display the result in a highlighted format
        System.out.println("STADIUM WITH THE MOST RUNS:");
        System.out.printf(">>> %s with %d total runs <<<\n", stadiums[maxIndex], maxRuns);
    }
}