/*
Program Name: Module 6 Final Option 2
Author: Nathan Curtis
Date: 9/22/2024
-------------------
Requirements:
    Create home inventory class to maintain available houses in country
        private int square_feet
        private string address
        private string city
        private string state
        private int zip_code
        private string Model_name
        private string sale_status (sold, available, or under contract)
    Have methods succh as
        Constructor
        add new home
        remove home
        update home attributes
    Inculde try..catch constructs
        Should return a success or failure message
-------------------
Pseudocode:
    HomeInventory (seperate file)
        private int square_feet;
        private String address;
        private String city;
        private String state;
        private int zip_code;
        private String Model_name;
        private String sale_status;
        
        public Homeinventory (uses previously listed variables as parameters)
            this.variable = variable
            repeat for all
    
    Import scanner
    Main
        main
            while loop
                Switch choice
                    1: add
                    2: delete
                    3: update
                    4: print
                    5: exit
                    except: invalid choice
        add home
            Add house information
        delete home
            Delete house information
        update home
            Update house infomatino
        upload information
            Take house information and put into text file
        get information for other functions?
            Get user input for the house information they want to use for the other functions?

*/
import java.util.Scanner; // Allows user input
import java.util.ArrayList; // Allpos array lists
import java.io.File;  // Import the File class
import java.io.FileWriter;  // Import the File class

public class main {
    //Main Function
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean mainLoop = true;
        int choice;
        String returnCondition;

        ArrayList<HomeInventory> Homes = new ArrayList();

        while(mainLoop == true) { // Navigate menu
            System.out.println("Navigation Menu ");
            System.out.println("1 - Add new home into inventory");
            System.out.println("2 - Remove a home from inventory");
            System.out.println("3 - Update a home from inventory");
            System.out.println("4 - Print inventory");
            System.out.println("5 - Exit");
            System.out.println("Please enter your choice:  ");

            choice = input.nextInt(); // Get input

            switch(choice){
                case 1: // Add home
                returnCondition = AddHome(Homes, input);
                    break;
                case 2: // Delete Home
                    returnCondition = RemoveHome(Homes, input);
                    break;
                case 3: // Update Home
                    returnCondition = UpdateHome(Homes, input);
                    break;
                case 4: // Print Inventory
                    returnCondition = PrintInventory(Homes, input);
                    break;
                case 5: // Quit
                    input.close();
                    System.out.println("Exiting Program");
                    System.exit(0);
                    break;
                default: // Invalid input
                    System.out.println("Not a valid menu option. Please try again");
                    break;
            }
        }
    }

    //Add Home - Done
    public static String AddHome(ArrayList<HomeInventory> Homes, Scanner input) {
        int homeSquare_feet, homeZip_code;
        String homeAddress, homeCity, homeState, homeModel_name, homeSale_status;
        try {
            System.out.print("Square feet of the property: ");
            homeSquare_feet = input.nextInt();

            System.out.print("\nAddress of the property: ");
            homeAddress = input.nextLine();

            System.out.print("\nCity of the property: ");
            homeCity = input.nextLine();

            System.out.print("\nState of the property: ");
            homeState = input.nextLine();

            System.out.print("\nZip of the property: ");
            homeZip_code = input.nextInt();

            System.out.print("\nModel name of the property: ");
            homeModel_name = input.nextLine();

            System.out.print("\nSale status of the property: ");
            homeSale_status = input.nextLine();

            //-------------------
            HomeInventory home = new HomeInventory(homeSquare_feet, homeAddress, homeCity,
            homeState, homeZip_code, homeModel_name, homeSale_status);

            Homes.add(home);
            
            return("House information added");
        } catch (Exception e) {
            return("Information failed to be added");
        }
        
    }

    //Remove Home - Done
    public static String RemoveHome(ArrayList<HomeInventory> Homes, Scanner input) {
        String homeAddress, homeCity, homeState;
        try {
            System.out.println("Provide the address, city, state");
            System.out.print("\nAddress: ");
            homeAddress = input.nextLine();
            System.out.print("\nCity: ");
            homeCity = input.nextLine();
            System.out.print("\nState: ");
            homeState = input.nextLine();

            for (int i = 0; i < Homes.size();) {
                
                if (homeAddress.equals(Homes.get(i).get_address()) && homeCity.equals(Homes.get(i).get_city()) && homeState.equals(Homes.get(i).get_state())) {
                    Homes.remove(i);
                }
                i = i + 1;
            }
            return("House deleted");
        } catch (Exception e) {
            return("No data to delete");
        }
    }

    //Update Home - Done
    public static String UpdateHome(ArrayList<HomeInventory> Homes, Scanner input) {
        int homeSquare_feet, homeZip_code, tempChoice, tempChoiceTwo;
        String homeAddress, homeModel_name, homesale_status = "NA";
        boolean updateLoop = true, saleStatusLoop = true;
        try {
            while(updateLoop == true){
                System.out.println("Update Menu ");
                System.out.println("1 - Update Square Feet");
                System.out.println("2 - Update Model Name");
                System.out.println("3 - Update Sale Status");
                System.out.println("4 - Cancel");
                System.out.println("Please enter your choice:  ");
                tempChoice = input.nextInt();

                switch(tempChoice){
                    case 1: // SqrFeet
                        System.out.println("Provide Address: ");
                        homeAddress = input.nextLine();
                        System.out.println("Provide Zip Code: ");
                        homeZip_code = input.nextInt();

                        for (int i = 0; i < Homes.size();) {
                            if (homeAddress.equals(Homes.get(i).get_address()) && homeZip_code == Homes.get(i).get_zip_code()){
                                System.out.println("Provide Updated Square Feet: ");
                                homeSquare_feet = input.nextInt();
                                Homes.get(i).set_square_feet(homeSquare_feet);
                            }
                        }
                        updateLoop = false;
                        break;
                    case 2: // Model
                        System.out.println("Provide Address: ");
                        homeAddress = input.nextLine();
                        System.out.println("Provide Zip Code: ");
                        homeZip_code = input.nextInt();

                        for (int i = 0; i < Homes.size();) {
                            if (homeAddress.equals(Homes.get(i).get_address()) && homeZip_code == Homes.get(i).get_zip_code()){
                                System.out.println("Provide Updated House Model: ");
                                homeModel_name = input.nextLine();
                                Homes.get(i).set_model_name(homeModel_name);
                            }
                        }
                        updateLoop = false;
                        break;
                    case 3: // Sale Status
                        System.out.println("Provide Address: ");
                        homeAddress = input.nextLine();
                        System.out.println("Provide Zip Code: ");
                        homeZip_code = input.nextInt();

                        for (int i = 0; i < Homes.size();) {
                            if (homeAddress.equals(Homes.get(i).get_address()) && homeZip_code == Homes.get(i).get_zip_code()){
                                while (saleStatusLoop = true) {
                                    System.out.println("1 - Sold");
                                    System.out.println("2 - Available");
                                    System.out.println("3 - Under Contract");
                                    tempChoiceTwo = input.nextInt();

                                    switch(tempChoiceTwo){
                                        case 1:
                                            homesale_status = "Sold";
                                        case 2:
                                            homesale_status = "Available";
                                        case 3:
                                            homesale_status = "Under Contract";
                                        default:
                                            System.out.println("Not a valid choice");
                                            break;
                                    }
                                    Homes.get(i).set_sale_status(homesale_status);
                                }
                            }
                        }
                        updateLoop = false;
                        break;
                    case 4: // Cancel
                        System.out.println("Canceling . . .");
                        updateLoop = false;
                        break;
                    default: // Invalid
                        System.out.println("Not a valid option. Please try again.");
                        break;
                }

            }
            return("House information updated");
        } catch (Exception e) {
            return("Informatino not found");
        }
    }

    //Print Inventory to document
    public static String PrintInventory(ArrayList<HomeInventory> Homes, Scanner input) {
        try {
            File fileName = new File("HousingInventory.txt");
            FileWriter fw = new FileWriter(fileName);
            for (int i = 0; i < Homes.size();) {
                fw.write(Homes.get(i).toString() + "\n\n\n");
            }
            fw.close();
            return("Information added to document");
        } catch (Exception e) {
            return("Could not upload to file");
        }
    }
    //public static ? Get informatino: Get all house information from user?
}
